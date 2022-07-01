package com.itechart.certificates.gift.service.validator;

import com.itechart.certificates.gift.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.repository.entity.GiftCertificateTag;
import com.itechart.certificates.gift.repository.entity.Tag;
import com.itechart.certificates.gift.service.validator.constant.ValidationStatus;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.itechart.certificates.gift.service.validator.constant.ValidationMessage.ENTITY_IS_VALIDATED;
import static com.itechart.certificates.gift.service.validator.constant.ValidationMessage.GIFT_CERT_TAG_INCORRECT_INPUT_MSG;

@Component
public class GiftCertificateTagValidator implements EntityValidator<GiftCertificateTag> {
	private final EntityValidator<GiftCertificate> giftCertificateEntityValidator;
	private final EntityValidator<Tag> tagValidatorEntityValidator;

	@Autowired
	public GiftCertificateTagValidator(EntityValidator<GiftCertificate> giftCertificateEntityValidator,
	                                   EntityValidator<Tag> tagValidatorEntityValidator) {
		this.giftCertificateEntityValidator = giftCertificateEntityValidator;
		this.tagValidatorEntityValidator = tagValidatorEntityValidator;
	}

	@Override
	public ImmutablePair<ValidationStatus, String> validate(GiftCertificateTag giftCertificateTag) {
		if (giftCertificateTag == null) {
			return new ImmutablePair<>(ValidationStatus.NOT_VALIDATED, GIFT_CERT_TAG_INCORRECT_INPUT_MSG);
		}
		ImmutablePair<ValidationStatus, String> giftCertificateValidationResult =
				giftCertificateEntityValidator.validate(giftCertificateTag.getGiftCertificate());
		if (giftCertificateValidationResult.getLeft().equals(ValidationStatus.NOT_VALIDATED)) {
			return giftCertificateValidationResult;
		}
		ImmutablePair<ValidationStatus, String> tagValidationResult =
				tagValidatorEntityValidator.validate(giftCertificateTag.getTag());
		if (tagValidationResult.getLeft().equals(ValidationStatus.NOT_VALIDATED)) {
			return tagValidationResult;
		}
		return new ImmutablePair<>(ValidationStatus.VALIDATED, ENTITY_IS_VALIDATED);
	}
}
