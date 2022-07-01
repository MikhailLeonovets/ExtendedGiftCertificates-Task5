package com.itechart.certificates.gift.service.validator;

import com.itechart.certificates.gift.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.service.validator.constant.ValidationStatus;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Component;

import static com.itechart.certificates.gift.service.validator.constant.ValidationMessage.GIFT_CERTIFICATE_INCORRECT_DESCRIPTION_MSG;
import static com.itechart.certificates.gift.service.validator.constant.ValidationMessage.GIFT_CERTIFICATE_INCORRECT_INPUT_MSG;
import static com.itechart.certificates.gift.service.validator.constant.ValidationMessage.GIFT_CERTIFICATE_INCORRECT_NAME_MSG;
import static com.itechart.certificates.gift.service.validator.constant.ValidationMessage.GIFT_CERTIFICATE_INCORRECT_PRICE_MSG;
import static com.itechart.certificates.gift.service.validator.constant.ValidationMessage.ENTITY_IS_VALIDATED;

@Component
public class GiftCertificateValidator implements EntityValidator<GiftCertificate> {
	@Override
	public ImmutablePair<ValidationStatus, String> validate(GiftCertificate giftCertificate) {
		if (giftCertificate == null) {
			return new ImmutablePair<>(ValidationStatus.NOT_VALIDATED, GIFT_CERTIFICATE_INCORRECT_INPUT_MSG);
		}
		if (giftCertificate.getName().isEmpty()) {
			return new ImmutablePair<>(ValidationStatus.NOT_VALIDATED, GIFT_CERTIFICATE_INCORRECT_NAME_MSG);
		}
		if (giftCertificate.getDescription() == null || giftCertificate.getDescription().isEmpty()) {
			return new ImmutablePair<>(ValidationStatus.NOT_VALIDATED, GIFT_CERTIFICATE_INCORRECT_DESCRIPTION_MSG);
		}
		if (giftCertificate.getPrice() == null) {
			return new ImmutablePair<>(ValidationStatus.NOT_VALIDATED, GIFT_CERTIFICATE_INCORRECT_PRICE_MSG);
		}
		return new ImmutablePair<>(ValidationStatus.VALIDATED, ENTITY_IS_VALIDATED);
	}
}
