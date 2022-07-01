package com.itechart.certificates.gift.service.crud.impl;

import com.itechart.certificates.gift.repository.GiftCertificateTagRepository;
import com.itechart.certificates.gift.repository.entity.GiftCertificateTag;
import com.itechart.certificates.gift.service.crud.GiftCertificateTagCRUDService;
import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.GiftCertificateTagNotFoundException;
import com.itechart.certificates.gift.service.validator.EntityValidator;
import com.itechart.certificates.gift.service.validator.constant.ValidationStatus;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.GIFT_CERT_TAG_NOT_FOUND_MSG;
import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.NULL_INPUT_MSG;

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
		Pair<ValidationStatus, String>  validationResult
				= giftCertificateTagEntityValidator.validate(giftCertificateTag);
		if (validationResult.getLeft().equals(ValidationStatus.NOT_VALIDATED)) {
			throw new DataInputException(validationResult.getRight());
		}
		return giftCertificateTagRepository.save(giftCertificateTag);
	}

	@Override
	public GiftCertificateTag findById(Long id) throws DataInputException, GiftCertificateTagNotFoundException {
		if (id == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		return giftCertificateTagRepository.findById(id)
				.orElseThrow(() -> new GiftCertificateTagNotFoundException(GIFT_CERT_TAG_NOT_FOUND_MSG));
	}

	@Override
	public List<GiftCertificateTag> findAll() {
		return giftCertificateTagRepository.findAll();
	}

	@Override
	public List<GiftCertificateTag> findByTagId(Long tagId) throws DataInputException {
		if (tagId == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		return giftCertificateTagRepository.findByTagId(tagId);
	}

	@Override
	public List<GiftCertificateTag> findByGiftCertificateId(Long giftCertificateId) throws DataInputException {
		if (giftCertificateId == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		return giftCertificateTagRepository.findByGiftCertificateId(giftCertificateId);
	}

	@Override
	public GiftCertificateTag update(GiftCertificateTag giftCertificateTag) throws DataInputException {
		Pair<ValidationStatus, String> validationResult
				= giftCertificateTagEntityValidator.validate(giftCertificateTag);
		if (validationResult.getLeft().equals(ValidationStatus.NOT_VALIDATED)) {
			throw new DataInputException(validationResult.getRight());
		}
		return giftCertificateTagRepository.save(giftCertificateTag);
	}

	@Override
	public void delete(GiftCertificateTag giftCertificateTag) throws DataInputException {
		if (giftCertificateTag.getId() == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		giftCertificateTagRepository.delete(giftCertificateTag);
	}

	@Override
	public void deleteById(Long id) throws DataInputException {
		if (id == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		giftCertificateTagRepository.deleteById(id);
	}
}
