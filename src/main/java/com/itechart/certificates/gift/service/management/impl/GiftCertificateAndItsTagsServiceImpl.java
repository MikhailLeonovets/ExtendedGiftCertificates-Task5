package com.itechart.certificates.gift.service.management.impl;

import com.itechart.certificates.gift.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.repository.entity.Tag;
import com.itechart.certificates.gift.service.crud.GiftCertificateCRUDService;
import com.itechart.certificates.gift.service.crud.TagCRUDService;
import com.itechart.certificates.gift.service.crud.GiftCertificateTagCRUDService;
import com.itechart.certificates.gift.service.management.GiftCertificateAndItsTagsService;
import com.itechart.certificates.gift.service.model.GiftCertificateAndItsTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GiftCertificateAndItsTagsServiceImpl implements GiftCertificateAndItsTagsService {
	private final GiftCertificateCRUDService giftCertificateCRUDService;
	private final TagCRUDService tagCRUDService;
	private final GiftCertificateTagCRUDService giftCertificateTagCRUDService;

	@Autowired
	public GiftCertificateAndItsTagsServiceImpl(GiftCertificateCRUDService giftCertificateCRUDService,
	                                            TagCRUDService tagCRUDService,
	                                            GiftCertificateTagCRUDService giftCertificateTagCRUDService) {
		this.giftCertificateCRUDService = giftCertificateCRUDService;
		this.tagCRUDService = tagCRUDService;
		this.giftCertificateTagCRUDService = giftCertificateTagCRUDService;
	}

	@Override
	@Transactional
	public GiftCertificateAndItsTags save(GiftCertificateAndItsTags giftCertificateAndItsTags) {

		return null;
	}

	@Override
	public List<GiftCertificateAndItsTags> findAll() {
		return null;
	}

	@Override
	public GiftCertificateAndItsTags findByGiftCertificateId(Long giftCertificateId) {
		return null;
	}

	@Override
	public List<GiftCertificateAndItsTags> findByTagId(Long tagId) {
		return null;
	}

	@Override
	public GiftCertificateAndItsTags update(GiftCertificateAndItsTags giftCertificateAndItsTags) {
		return null;
	}

	@Override
	public void delete(GiftCertificate giftCertificate) {

	}

	@Override
	public void update(GiftCertificate giftCertificate, List<Tag> itsTags) {

	}
}
