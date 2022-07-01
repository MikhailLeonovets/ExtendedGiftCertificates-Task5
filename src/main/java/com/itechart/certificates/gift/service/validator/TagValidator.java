package com.itechart.certificates.gift.service.validator;

import com.itechart.certificates.gift.repository.entity.Tag;
import com.itechart.certificates.gift.service.validator.constant.ValidationStatus;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Component;

import static com.itechart.certificates.gift.service.validator.constant.ValidationMessage.ENTITY_IS_VALIDATED;
import static com.itechart.certificates.gift.service.validator.constant.ValidationMessage.TAG_INCORRECT_INPUT_MSG;
import static com.itechart.certificates.gift.service.validator.constant.ValidationMessage.TAG_INCORRECT_NAME_MSG;

@Component
public class TagValidator implements EntityValidator<Tag> {
	@Override
	public ImmutablePair<ValidationStatus, String> validate(Tag tag) {
		if (tag == null) {
			return new ImmutablePair<>(ValidationStatus.NOT_VALIDATED, TAG_INCORRECT_INPUT_MSG);
		}
		if (tag.getName() == null || tag.getName().isEmpty()) {
			return new ImmutablePair<>(ValidationStatus.VALIDATED, TAG_INCORRECT_NAME_MSG);
		}
		return new ImmutablePair<>(ValidationStatus.VALIDATED, ENTITY_IS_VALIDATED);
	}
}
