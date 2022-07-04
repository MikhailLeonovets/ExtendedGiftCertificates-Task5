package com.itechart.certificates.gift.service.crud.impl;

import com.itechart.certificates.gift.service.exception.DataInputException;
import com.itechart.certificates.gift.service.exception.TagNotFoundException;
import com.itechart.certificates.gift.service.validator.EntityValidator;
import com.itechart.certificates.gift.repository.TagRepository;
import com.itechart.certificates.gift.repository.entity.Tag;
import com.itechart.certificates.gift.service.crud.TagCRUDService;
import com.itechart.certificates.gift.service.validator.constant.ValidationStatus;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.INCORRECT_INPUT_MSG;
import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.NULL_INPUT_MSG;
import static com.itechart.certificates.gift.service.exception.constant.ExceptionMessage.TAG_NOT_FOUND_MSG;

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
		Pair<ValidationStatus, String> validationResult = tagValidator.validate(tag);
		if (validationResult.getLeft().equals(ValidationStatus.NOT_VALIDATED)) {
			throw new DataInputException(validationResult.getRight());
		}
		Optional<Tag> optionalTag = tagRepository.findByName(tag.getName());
		return optionalTag.orElseGet(() -> tagRepository.save(tag));
	}

	@Override
	public Tag save(String tagName) throws DataInputException {
		if (tagName == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		if (tagName.isEmpty()) {
			throw new DataInputException(INCORRECT_INPUT_MSG);
		}
		Optional<Tag> optionalTag = tagRepository.findByName(tagName);
		return optionalTag.orElseGet(() -> tagRepository.save(new Tag(tagName)));
	}

	@Override
	public List<Tag> findAll() {
		return tagRepository.findAll();
	}

	@Override
	public Tag findById(Long id) throws DataInputException, TagNotFoundException {
		if (id == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		return tagRepository.findById(id).orElseThrow(() -> new TagNotFoundException(TAG_NOT_FOUND_MSG));
	}

	@Override
	public Tag findByName(String tagName) throws DataInputException, TagNotFoundException {
		if (tagName == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		if (tagName.isEmpty()) {
			throw new DataInputException(INCORRECT_INPUT_MSG);
		}
		return tagRepository.findByName(tagName).orElseThrow(() -> new TagNotFoundException(TAG_NOT_FOUND_MSG));
	}

	@Override
	public Tag update(Tag tag) throws DataInputException {
		Pair<ValidationStatus, String> validationResult = tagValidator.validate(tag);
		if (tag.getId() == null) {
			throw new DataInputException(INCORRECT_INPUT_MSG);
		}
		if (validationResult.getLeft().equals(ValidationStatus.NOT_VALIDATED)) {
			throw new DataInputException(validationResult.getRight());
		}
		return tagRepository.save(tag);
	}

	@Override
	public void delete(Tag tag) throws DataInputException {
		if (tag.getId() == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		tagRepository.delete(tag);
	}

	@Override
	public void deleteById(Long id) throws DataInputException {
		if (id == null) {
			throw new DataInputException(NULL_INPUT_MSG);
		}
		tagRepository.deleteById(id);
	}
}
