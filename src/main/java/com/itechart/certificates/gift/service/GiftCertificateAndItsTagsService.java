package com.itechart.certificates.gift.service;

import com.itechart.certificates.gift.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.repository.entity.Tag;
import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.GiftCertificateNotFoundException;
import com.itechart.certificates.gift.service.model.GiftCertificateAndItsTags;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface GiftCertificateAndItsTagsService {
	@Transactional
	GiftCertificateAndItsTags save(GiftCertificateAndItsTags giftCertificateAndItsTags) throws DataInputException;

	Set<GiftCertificateAndItsTags> findAll() throws DataInputException;

	GiftCertificateAndItsTags findByGiftCertificateId(Long giftCertificateId) throws GiftCertificateNotFoundException, DataInputException;

	Set<GiftCertificateAndItsTags> findByTagId(Long tagId) throws DataInputException;

	@Transactional
	GiftCertificateAndItsTags update(GiftCertificateAndItsTags giftCertificateAndItsTags) throws DataInputException, GiftCertificateNotFoundException;

	@Transactional
	void delete(GiftCertificate giftCertificate) throws DataInputException;

	@Transactional
	void deleteById(Long giftCertificateId) throws DataInputException;
}
