package com.itechart.certificates.gift.task5.service.validator;

import com.itechart.certificates.gift.task5.repository.entity.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagValidator implements EntityValidator<Tag> {
	@Override
	public boolean validate(Tag tag) {
		return tag != null
				&& tag.getName() != null
				&& !tag.getName().isEmpty();
	}
}
