package com.itechart.certificates.gift.service.validator.constant;

public class ValidationMessage {
	/**
	 * String message is for validated status of Entity
	 */
	public static final String ENTITY_IS_VALIDATED = "Entity is validated";

	/**
	 * String messages are for not validated status of GiftCertificate Entity
	 */
	public static final String GIFT_CERTIFICATE_INCORRECT_INPUT_MSG = "Gift Certificate is null!";
	public static final String GIFT_CERTIFICATE_INCORRECT_NAME_MSG = "Incorrect Gift Certificate's name!";
	public static final String GIFT_CERTIFICATE_INCORRECT_DESCRIPTION_MSG = "Incorrect Gift Certificate's " +
			"description!";
	public static final String GIFT_CERTIFICATE_INCORRECT_PRICE_MSG = "Incorrect Gift Certificate's price!";

	/**
	 * String messages are for not validated status of Tag Entity
	 */
	public static final String TAG_INCORRECT_INPUT_MSG = "Tag is null!";
	public static final String TAG_INCORRECT_NAME_MSG = "Incorrect Tag's name!";

	/**
	 * String messages are for not validated status of GiftCertificateTag Entity
	 */
	public static final String GIFT_CERT_TAG_INCORRECT_INPUT_MSG = "Gift Certificate Tag is null!";
}
