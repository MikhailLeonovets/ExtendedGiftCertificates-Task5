package com.itechart.certificates.gift.task5.service.crud;

import com.itechart.certificates.gift.task5.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.task5.service.exception.DataInputException;
import com.itechart.certificates.gift.task5.service.exception.GiftCertificateNotFoundException;

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
