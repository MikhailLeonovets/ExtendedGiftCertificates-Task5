package com.itechart.certificates.gift.service.parser.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.IncorrectEntityFileException;
import com.itechart.certificates.gift.service.model.GiftCertificateAndItsTags;
import com.itechart.certificates.gift.service.parser.EntityFileParser;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.INCORRECT_ENTITY_FILE_MSG;
import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.INCORRECT_INPUT_MSG;
import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.NULL_FILE_MSG;

@Service
public class GiftCertificateJsonFileParser implements EntityFileParser<GiftCertificateAndItsTags> {
	@Override
	public List<GiftCertificateAndItsTags> parse(File file) throws IncorrectEntityFileException, DataInputException {
		if (file == null) {
			throw new DataInputException(NULL_FILE_MSG);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class,
					GiftCertificateAndItsTags.class));
		} catch (IOException e) {
			throw new DataInputException(INCORRECT_INPUT_MSG);
		} catch (Exception e) {
			throw new IncorrectEntityFileException(INCORRECT_ENTITY_FILE_MSG);
		}
	}
}
