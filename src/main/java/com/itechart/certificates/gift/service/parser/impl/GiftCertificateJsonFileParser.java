package com.itechart.certificates.gift.service.parser.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.IncorrectEntityFileException;
import com.itechart.certificates.gift.service.model.GiftCertificateAndItsTags;
import com.itechart.certificates.gift.service.parser.EntityFileParser;
import net.minidev.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.INCORRECT_INPUT_MSG;
import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.NULL_FILE_MSG;

@Service
public class GiftCertificateJsonFileParser implements EntityFileParser {
	@Override
	public List<GiftCertificateAndItsTags> parse(File file) throws IncorrectEntityFileException, DataInputException {
		if (file == null) {
			throw new DataInputException(NULL_FILE_MSG);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			new JSONObject(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
			objectMapper.readTree(file);
			return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class,
					GiftCertificateAndItsTags.class));
		} catch (IOException e) {
			throw new DataInputException(INCORRECT_INPUT_MSG);
		}
	}
}
