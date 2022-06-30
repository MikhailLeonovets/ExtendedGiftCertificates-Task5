package com.itechart.certificates.gift.task5.service;

import com.itechart.certificates.gift.task5.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.task5.repository.entity.Tag;

import java.util.List;

public interface GiftCertificateAndItsTagsManagement {
	void save(GiftCertificate giftCertificate, List<Tag> itsTags);



	void delete(GiftCertificate giftCertificate);

	void update(GiftCertificate giftCertificate, List<Tag> itsTags);
}
