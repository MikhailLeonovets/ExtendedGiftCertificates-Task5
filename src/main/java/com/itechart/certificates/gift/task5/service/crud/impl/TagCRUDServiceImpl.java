package com.itechart.certificates.gift.task5.service.crud.impl;

import com.itechart.certificates.gift.task5.repository.TagRepository;
import com.itechart.certificates.gift.task5.repository.entity.Tag;
import com.itechart.certificates.gift.task5.service.crud.TagCRUDService;
import com.itechart.certificates.gift.task5.service.exception.DataInputException;
import com.itechart.certificates.gift.task5.service.exception.TagNotFoundException;
import com.itechart.certificates.gift.task5.service.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagCRUDServiceImpl implements TagCRUDService {
	private final TagRepository tagRepository;
	private final EntityValidator<Tag> tagValidator;

	@Autowired
	public TagCRUDServiceImpl(TagRepository tagRepository,
	                          EntityValidator<Tag> tagValidator) {
		this.tagRepository = tagRepository;
		this.tagValidator = tagValidator;
	}

	@Override
	public Tag save(Tag tag) throws DataInputException {
		if (tagValidator.validate(tag)) {
			throw new DataInputException();
		}
		return tagRepository.save(tag);
	}

	@Override
	public Tag save(String tagName) throws DataInputException {
		if (tagName == null || tagName.isEmpty()) {
			throw new DataInputException();
		}
		return tagRepository.save(new Tag(tagName));
	}

	@Override
	public List<Tag> findAll() {
		return tagRepository.findAll();
	}

	@Override
	public Tag findById(Long id) throws DataInputException, TagNotFoundException {
		if (id == null) {
			throw new DataInputException();
		}
		return tagRepository.findById(id).orElseThrow(TagNotFoundException::new);
	}

	@Override
	public Tag findByName(String name) throws DataInputException, TagNotFoundException {
		if (name == null || name.isEmpty()) {
			throw new DataInputException();
		}
		return tagRepository.findByName(name).orElseThrow(TagNotFoundException::new);
	}

	@Override
	public Tag update(Tag tag) throws DataInputException {
		if (!tagValidator.validate(tag)) {
			throw new DataInputException();
		}
		return tagRepository.save(tag);
	}

	@Override
	public void delete(Tag tag) throws DataInputException {
		if (tag.getId() == null) {
			throw new DataInputException();
		}
		tagRepository.delete(tag);
	}

	@Override
	public void deleteById(Long id) throws DataInputException {
		if (id == null) {
			throw new DataInputException();
		}
		tagRepository.deleteById(id);
	}
}
