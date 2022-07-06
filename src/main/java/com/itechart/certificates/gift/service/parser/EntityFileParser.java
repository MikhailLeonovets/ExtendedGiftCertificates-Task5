package com.itechart.certificates.gift.service.parser;

import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.IncorrectEntityFileException;

import java.io.File;
import java.util.List;

public interface EntityFileParser<T> {
	List<T> parse(File file) throws IncorrectEntityFileException, DataInputException;
}
