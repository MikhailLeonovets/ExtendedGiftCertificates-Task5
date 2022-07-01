package com.itechart.certificates.gift.service.validator;

import com.itechart.certificates.gift.repository.entity.mapped_super_class.Identity;
import com.itechart.certificates.gift.service.validator.constant.ValidationStatus;
import org.apache.commons.lang3.tuple.ImmutablePair;

public interface EntityValidator<T extends Identity> {
	/**
	 * @param t is an entity to be validated
	 * @return true if entity is validated and false if is not
	 */
	ImmutablePair<ValidationStatus, String> validate(T t);
}
