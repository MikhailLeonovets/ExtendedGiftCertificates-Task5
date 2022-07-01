package com.itechart.certificates.gift.service.crud;

import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.GiftCertificateNotFoundException;
import com.itechart.certificates.gift.repository.entity.GiftCertificate;

import java.util.List;

public interface GiftCertificateCRUDService {
	GiftCertificate save(GiftCertificate giftCertificate) throws DataInputException;

	List<GiftCertificate> findAll();

	GiftCertificate findById(Long id) throws DataInputException, GiftCertificateNotFoundException;

	GiftCertificate findByName(String name) throws DataInputException, GiftCertificateNotFoundException;

	GiftCertificate update(GiftCertificate giftCertificate) throws DataInputException;

	void delete(GiftCertificate giftCertificate) throws DataInputException;

	void deleteById(Long id) throws DataInputException;
}
