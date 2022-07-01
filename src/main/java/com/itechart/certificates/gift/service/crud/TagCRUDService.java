package com.itechart.certificates.gift.service.crud;

import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.TagNotFoundException;
import com.itechart.certificates.gift.repository.entity.Tag;

import java.util.List;

public interface TagCRUDService {
	Tag save(Tag tag) throws DataInputException;

	Tag save(String tagName) throws DataInputException;

	List<Tag> findAll();

	Tag findById(Long id) throws TagNotFoundException, DataInputException;

	Tag findByName(String name) throws DataInputException, TagNotFoundException;

	Tag update(Tag tag) throws DataInputException;

	void delete(Tag tag) throws DataInputException;

	void deleteById(Long id) throws DataInputException;

}
