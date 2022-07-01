package com.itechart.certificates.gift.service.crud.impl;

import com.itechart.certificates.gift.service.crud.GiftCertificateCRUDService;
import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.GiftCertificateNotFoundException;
import com.itechart.certificates.gift.service.validator.EntityValidator;
import com.itechart.certificates.gift.repository.GiftCertificateRepository;
import com.itechart.certificates.gift.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.service.validator.constant.ValidationStatus;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.GIFT_CERT_NOT_FOUND_MSG;
import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.GIFT_CERT_TAG_NOT_FOUND_MSG;
import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.INCORRECT_INPUT_MSG;
import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.NULL_INPUT_MSG;

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
		Pair<ValidationStatus, String> validationResult = giftCertificateValidator.validate(giftCertificate);
		if (validationResult.getLeft().equals(ValidationStatus.NOT_VALIDATED)) {
			throw new DataInputException(validationResult.getRight());
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
			throw new DataInputException(NULL_INPUT_MSG);
		}
		return giftCertificateRepository.findById(id)
				.orElseThrow(() -> new GiftCertificateNotFoundException(GIFT_CERT_TAG_NOT_FOUND_MSG));
	}

	@Override
	public GiftCertificate findByName(String name) throws DataInputException, GiftCertificateNotFoundException {
		if (name == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		if (name.isEmpty()) {
			throw new DataInputException(INCORRECT_INPUT_MSG);
		}
		return giftCertificateRepository.findByName(name).orElseThrow(() ->
				new GiftCertificateNotFoundException(GIFT_CERT_NOT_FOUND_MSG));
	}

	@Override
	public GiftCertificate update(GiftCertificate giftCertificate) throws DataInputException {
		Pair<ValidationStatus, String> validationResult = giftCertificateValidator.validate(giftCertificate);
		if (validationResult.getLeft().equals(ValidationStatus.NOT_VALIDATED)) {
			throw new DataInputException(validationResult.getRight());
		}
		if (giftCertificate.getId() == null) {
			throw new DataInputException(INCORRECT_INPUT_MSG);
		}
		return giftCertificateRepository.save(giftCertificate);
	}

	@Override
	public void delete(GiftCertificate giftCertificate) throws DataInputException {
		if (giftCertificate.getId() == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		giftCertificateRepository.delete(giftCertificate);
	}

	@Override
	public void deleteById(Long id) throws DataInputException {
		if (id == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		giftCertificateRepository.deleteById(id);
	}
}
