package com.itechart.certificates.gift.service.impl;

import com.itechart.certificates.gift.repository.GiftCertificateRepository;
import com.itechart.certificates.gift.repository.TagRepository;
import com.itechart.certificates.gift.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.repository.entity.GiftCertificateTag;
import com.itechart.certificates.gift.repository.entity.Tag;
import com.itechart.certificates.gift.service.crud.GiftCertificateCRUDService;
import com.itechart.certificates.gift.service.crud.TagCRUDService;
import com.itechart.certificates.gift.service.crud.GiftCertificateTagCRUDService;
import com.itechart.certificates.gift.service.GiftCertificateAndItsTagsService;
import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.GiftCertificateNotFoundException;
import com.itechart.certificates.gift.service.model.GiftCertificateAndItsTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.GIFT_CERT_NAME_IS_BUSY;

@Service
public class GiftCertificateAndItsTagsServiceImpl implements GiftCertificateAndItsTagsService {
	private final GiftCertificateCRUDService giftCertificateCRUDService;
	private final TagCRUDService tagCRUDService;
	private final GiftCertificateTagCRUDService giftCertificateTagCRUDService;

	private final GiftCertificateRepository giftCertificateRepository;

	@Autowired
	public GiftCertificateAndItsTagsServiceImpl(GiftCertificateCRUDService giftCertificateCRUDService,
	                                            TagCRUDService tagCRUDService,
	                                            GiftCertificateTagCRUDService giftCertificateTagCRUDService,
	                                            GiftCertificateRepository giftCertificateRepository) {
		this.giftCertificateCRUDService = giftCertificateCRUDService;
		this.tagCRUDService = tagCRUDService;
		this.giftCertificateTagCRUDService = giftCertificateTagCRUDService;
		this.giftCertificateRepository = giftCertificateRepository;
	}

	@Override
	@Transactional
	public GiftCertificateAndItsTags save(GiftCertificateAndItsTags giftCertificateAndItsTags)
			throws DataInputException {
		Optional<GiftCertificate> optionalGiftCertificate =
				giftCertificateRepository.findByName(giftCertificateAndItsTags.getGiftCertificate().getName());
		if (optionalGiftCertificate.isPresent()) {
			throw new DataInputException(GIFT_CERT_NAME_IS_BUSY);
		}
		GiftCertificate savedGiftCertificate
				= giftCertificateCRUDService.save(giftCertificateAndItsTags.getGiftCertificate());
		giftCertificateAndItsTags.setGiftCertificate(savedGiftCertificate);
		Set<Tag> updatedItsTags = new HashSet<>();
		for (Tag tag : giftCertificateAndItsTags.getItsTags()) {
			tag = tagCRUDService.save(tag);
			updatedItsTags.add(tag);
			giftCertificateTagCRUDService.save(new GiftCertificateTag(savedGiftCertificate, tag));
		}
		giftCertificateAndItsTags.setItsTags(updatedItsTags);
		return giftCertificateAndItsTags;
	}

	@Override
	public Set<GiftCertificateAndItsTags> findAll() throws DataInputException {
		Set<GiftCertificateAndItsTags> giftCertificateAndItsTagsList = new HashSet<>();
		for (GiftCertificate giftCertificate : giftCertificateCRUDService.findAll()) {
			giftCertificateAndItsTagsList.add(new GiftCertificateAndItsTags(giftCertificate,
					findItsTags(giftCertificate)));
		}
		return giftCertificateAndItsTagsList;
	}

	@Override
	public GiftCertificateAndItsTags findByGiftCertificateId(Long giftCertificateId)
			throws GiftCertificateNotFoundException, DataInputException {
		GiftCertificate giftCertificate = giftCertificateCRUDService.findById(giftCertificateId);
		return new GiftCertificateAndItsTags(giftCertificate, findItsTags(giftCertificate));

	}

	@Override
	public Set<GiftCertificateAndItsTags> findByTagId(Long tagId) throws DataInputException {
		Set<GiftCertificateAndItsTags> giftCertificateAndItsTagsSet = new HashSet<>();
		List<GiftCertificateTag> giftCertificateTagList = giftCertificateTagCRUDService.findByTagId(tagId);
		for (GiftCertificateTag giftCertificateTag : giftCertificateTagList) {
			giftCertificateAndItsTagsSet.add(new GiftCertificateAndItsTags(giftCertificateTag.getGiftCertificate(),
					findItsTags(giftCertificateTag.getGiftCertificate())));
		}
		return giftCertificateAndItsTagsSet;
	}

	@Override
	@Transactional
	public GiftCertificateAndItsTags update(GiftCertificateAndItsTags giftCertificateAndItsTags)
			throws DataInputException, GiftCertificateNotFoundException {
		giftCertificateCRUDService.update(giftCertificateAndItsTags.getGiftCertificate());
		Set<Tag> legacyTags =
				findByGiftCertificateId(giftCertificateAndItsTags.getGiftCertificate().getId()).getItsTags();
		Set<Tag> actualTags = giftCertificateAndItsTags.getItsTags();
		for (Tag tag : legacyTags) {
			if (!actualTags.contains(tag)) {
				giftCertificateTagCRUDService.deleteByGiftCertificateIdAndTagId
						(giftCertificateAndItsTags.getGiftCertificate().getId(), tag.getId());
			}
		}
		for (Tag tag : actualTags) {
			if (!legacyTags.contains(tag)) {
				giftCertificateAndItsTags.getItsTags().remove(tag);
				giftCertificateAndItsTags.getItsTags().add(tagCRUDService.save(tag));
				giftCertificateTagCRUDService.save
						(new GiftCertificateTag(giftCertificateAndItsTags.getGiftCertificate(), tag));
			}
		}
		return giftCertificateAndItsTags;
	}

	@Override
	public void delete(GiftCertificate giftCertificate) throws DataInputException {
		giftCertificateCRUDService.delete(giftCertificate);
	}

	@Override
	public void deleteById(Long giftCertificateId) throws DataInputException {
		giftCertificateCRUDService.deleteById(giftCertificateId);
	}

	private Set<Tag> findItsTags(GiftCertificate giftCertificate) throws DataInputException {
		return giftCertificateTagCRUDService.findByGiftCertificateId(giftCertificate.getId())
				.stream()
				.map(GiftCertificateTag::getTag)
				.collect(Collectors.toSet());
	}
}