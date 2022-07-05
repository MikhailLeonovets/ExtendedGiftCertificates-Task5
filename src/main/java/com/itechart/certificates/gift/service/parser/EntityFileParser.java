package com.itechart.certificates.gift.service.parser;

import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.IncorrectEntityFileException;
import com.itechart.certificates.gift.service.model.GiftCertificateAndItsTags;

import java.io.File;
import java.util.List;

public interface EntityFileParser {
	List<GiftCertificateAndItsTags> parse(File file) throws IncorrectEntityFileException, DataInputException;
}
