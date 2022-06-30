package com.itechart.certificates.gift.task5.service.crud.impl;

import com.itechart.certificates.gift.task5.repository.GiftCertificateRepository;
import com.itechart.certificates.gift.task5.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.task5.service.crud.GiftCertificateCRUDService;
import com.itechart.certificates.gift.task5.service.exception.DataInputException;
import com.itechart.certificates.gift.task5.service.exception.GiftCertificateNotFoundException;
import com.itechart.certificates.gift.task5.service.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftCertificateCRUDServiceImpl implements GiftCertificateCRUDService {
	private final GiftCertificateRepository giftCertificateRepository;
	private final EntityValidator<GiftCertificate> giftCertificateValidator;

	@Autowired
	public GiftCertificateCRUDServiceImpl(GiftCertificateRepository giftCertificateRepository,
	                                      EntityValidator<GiftCertificate> giftCertificateValidator) {
		this.giftCertificateRepository = giftCertificateRepository;
		this.giftCertificateValidator = giftCertificateValidator;
	}

	@Override
	public GiftCertificate save(GiftCertificate giftCertificate) throws DataInputException {
		if (!giftCertificateValidator.validate(giftCertificate)) {
			throw new DataInputException();
		}
		return giftCertificateRepository.save(giftCertificate);
	}

	@Override
	public List<GiftCertificate> findAll() {
		return giftCertificateRepository.findAll();
	}

	@Override
	public GiftCertificate findById(Long id) throws DataInputException, GiftCertificateNotFoundException {
		if (id == null) {
			throw new DataInputException();
		}
		return giftCertificateRepository.findById(id).orElseThrow(GiftCertificateNotFoundException::new);
	}

	@Override
	public GiftCertificate findByName(String name) throws DataInputException, GiftCertificateNotFoundException {
		if (name == null || name.isEmpty()) {
			throw new DataInputException();
		}
		return giftCertificateRepository.findByName(name).orElseThrow(GiftCertificateNotFoundException::new);
	}

	@Override
	public GiftCertificate update(GiftCertificate giftCertificate) throws DataInputException {
		if (!giftCertificateValidator.validate(giftCertificate) || giftCertificate.getId() == null) {
			throw new DataInputException();
		}
		return giftCertificateRepository.save(giftCertificate);
	}

	@Override
	public void delete(GiftCertificate giftCertificate) throws DataInputException {
		if (giftCertificate.getId() == null) {
			throw new DataInputException();
		}
		giftCertificateRepository.delete(giftCertificate);
	}

	@Override
	public void deleteById(Long id) throws DataInputException {
		if (id == null) {
			throw new DataInputException();
		}
		giftCertificateRepository.deleteById(id);
	}
}
