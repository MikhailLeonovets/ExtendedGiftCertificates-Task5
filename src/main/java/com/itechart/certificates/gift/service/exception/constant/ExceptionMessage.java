package com.itechart.certificates.gift.service.exception.constant;

public class ExceptionMessage {
	/**
	 * DataInputException messages
	 */
	public static final String NULL_INPUT_MSG = "Input is null!";
	public static final String INCORRECT_INPUT_MSG = "Incorrect input!";
	public static final String NULL_FILE_MSG = "Incorrect file input!";

	/**
	 * GiftCertificateNotFoundException message
	 */
	public static final String GIFT_CERT_NOT_FOUND_MSG = "Gift Certificate not found!";
	public static final String GIFT_CERT_NAME_IS_BUSY = "This Gift Certificate's name is busy! Please create with " +
			"another one.";

	/**
	 * TagNotFoundException message
	 */
	public static final String TAG_NOT_FOUND_MSG = "Tag not found!";

	/**
	 * GiftCertificateTagNotFoundException message
	 */
	public static final String GIFT_CERT_TAG_NOT_FOUND_MSG = "Gift Certificate not found!";

	/**
	 * IncorrectEntityFileException message
	 */
	public static final String INCORRECT_ENTITY_FILE_MSG = "This file is incorrect! Cannot parse it into the entities";
}
