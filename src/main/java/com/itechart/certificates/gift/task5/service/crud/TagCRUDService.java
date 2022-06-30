package com.itechart.certificates.gift.task5.service.crud;

import com.itechart.certificates.gift.task5.repository.entity.Tag;
import com.itechart.certificates.gift.task5.service.exception.DataInputException;
import com.itechart.certificates.gift.task5.service.exception.TagNotFoundException;

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
