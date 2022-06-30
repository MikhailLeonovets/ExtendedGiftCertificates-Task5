package com.itechart.certificates.gift.task5.service.validator;

import com.itechart.certificates.gift.task5.repository.entity.GiftCertificate;
import org.springframework.stereotype.Component;

@Component
public class GiftCertificateValidator implements EntityValidator<GiftCertificate> {
	@Override
	public boolean validate(GiftCertificate giftCertificate) {
		return giftCertificate != null
				&& giftCertificate.getName() != null
				&& !giftCertificate.getName().isEmpty()
				&& giftCertificate.getDescription() != null
				&& !giftCertificate.getDescription().isEmpty()
				&& giftCertificate.getPrice() != null;
	}
}
