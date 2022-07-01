package com.itechart.certificates.gift.service.management;

import com.itechart.certificates.gift.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.repository.entity.Tag;
import com.itechart.certificates.gift.service.model.GiftCertificateAndItsTags;

import java.util.List;

public interface GiftCertificateAndItsTagsService {
	GiftCertificateAndItsTags save(GiftCertificateAndItsTags giftCertificateAndItsTags);

	List<GiftCertificateAndItsTags> findAll();

	GiftCertificateAndItsTags findByGiftCertificateId(Long giftCertificateId);

	List<GiftCertificateAndItsTags> findByTagId(Long tagId);

	GiftCertificateAndItsTags update(GiftCertificateAndItsTags giftCertificateAndItsTags);

	void delete(GiftCertificate giftCertificate);

	void update(GiftCertificate giftCertificate, List<Tag> itsTags);
}
