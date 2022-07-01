package com.itechart.certificates.gift.service.crud.impl;

import com.itechart.certificates.gift.repository.GiftCertificateTagRepository;
import com.itechart.certificates.gift.repository.entity.GiftCertificateTag;
import com.itechart.certificates.gift.service.crud.GiftCertificateTagCRUDService;
import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.GiftCertificateTagNotFoundException;
import com.itechart.certificates.gift.service.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftCertificateTagCRUDServiceImpl implements GiftCertificateTagCRUDService {
	private final GiftCertificateTagRepository giftCertificateTagRepository;
	private final EntityValidator<GiftCertificateTag> giftCertificateTagEntityValidator;

	@Autowired
	public GiftCertificateTagCRUDServiceImpl(GiftCertificateTagRepository giftCertificateTagRepository,
	                                         EntityValidator<GiftCertificateTag> giftCertificateTagEntityValidator) {
		this.giftCertificateTagRepository = giftCertificateTagRepository;
		this.giftCertificateTagEntityValidator = giftCertificateTagEntityValidator;
	}

	@Override
	public GiftCertificateTag save(GiftCertificateTag giftCertificateTag) throws DataInputException {
		if (!giftCertificateTagEntityValidator.validate(giftCertificateTag)) {
			throw new DataInputException();
		}
		return giftCertificateTagRepository.save(giftCertificateTag);
	}

	@Override
	public GiftCertificateTag findById(Long id) throws DataInputException, GiftCertificateTagNotFoundException {
		if (id == null) {
			throw new DataInputException();
		}
		return giftCertificateTagRepository.findById(id).orElseThrow(GiftCertificateTagNotFoundException::new);
	}

	@Override
	public List<GiftCertificateTag> findAll() {
		return giftCertificateTagRepository.findAll();
	}

	@Override
	public List<GiftCertificateTag> findByTagId(Long tagId) throws DataInputException {
		if (tagId == null) {
			throw new DataInputException();
		}
		return giftCertificateTagRepository.findByTagId(tagId);
	}

	@Override
	public List<GiftCertificateTag> findByGiftCertificateId(Long giftCertificateId) throws DataInputException {
		if (giftCertificateId == null) {
			throw new DataInputException();
		}
		return giftCertificateTagRepository.findByGiftCertificateId(giftCertificateId);
	}

	@Override
	public GiftCertificateTag update(GiftCertificateTag giftCertificateTag) throws DataInputException {
		if (!giftCertificateTagEntityValidator.validate(giftCertificateTag)) {
			throw new DataInputException();
		}
		return giftCertificateTagRepository.save(giftCertificateTag);
	}

	@Override
	public void delete(GiftCertificateTag giftCertificateTag) throws DataInputException {
		if (giftCertificateTag.getId() == null) {
			throw new DataInputException();
		}
		giftCertificateTagRepository.delete(giftCertificateTag);
	}

	@Override
	public void deleteById(Long id) throws DataInputException {
		if (id == null) {
			throw new DataInputException();
		}
		giftCertificateTagRepository.deleteById(id);
	}
}
