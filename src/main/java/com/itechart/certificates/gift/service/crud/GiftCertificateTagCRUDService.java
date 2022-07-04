package com.itechart.certificates.gift.service.crud;

import com.itechart.certificates.gift.repository.entity.GiftCertificateTag;
import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.GiftCertificateTagNotFoundException;

import java.util.List;

public interface GiftCertificateTagCRUDService {
	GiftCertificateTag save(GiftCertificateTag giftCertificateTag) throws DataInputException;

	GiftCertificateTag findById(Long id) throws DataInputException, GiftCertificateTagNotFoundException;

	List<GiftCertificateTag> findAll();

	List<GiftCertificateTag> findByTagId(Long tagId) throws DataInputException;

	List<GiftCertificateTag> findByGiftCertificateId(Long giftCertificateId) throws DataInputException;

	GiftCertificateTag update(GiftCertificateTag giftCertificateTag) throws DataInputException;

	void delete(GiftCertificateTag giftCertificateTag) throws DataInputException;

	void deleteById(Long id) throws DataInputException;

	void deleteByGiftCertificateIdAndTagId(Long giftCertificateId, Long tagId) throws DataInputException;
}
