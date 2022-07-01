package com.itechart.certificates.gift.service.crud.impl;

import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.TagNotFoundException;
import com.itechart.certificates.gift.service.validator.EntityValidator;
import com.itechart.certificates.gift.repository.TagRepository;
import com.itechart.certificates.gift.repository.entity.Tag;
import com.itechart.certificates.gift.service.crud.TagCRUDService;
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
