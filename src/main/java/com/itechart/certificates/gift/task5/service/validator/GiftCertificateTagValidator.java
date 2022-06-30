package com.itechart.certificates.gift.task5.service.validator;

import com.itechart.certificates.gift.task5.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.task5.repository.entity.GiftCertificateTag;
import com.itechart.certificates.gift.task5.repository.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public boolean validate(GiftCertificateTag giftCertificateTag) {
		return giftCertificateTag != null
				&& giftCertificateEntityValidator.validate(giftCertificateTag.getGiftCertificate())
				&& tagValidatorEntityValidator.validate(giftCertificateTag.getTag());
	}
}
