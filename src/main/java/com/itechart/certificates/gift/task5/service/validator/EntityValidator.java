package com.itechart.certificates.gift.task5.service.validator;

import com.itechart.certificates.gift.task5.repository.entity.mapped_super_class.Identity;

public interface  EntityValidator <T extends Identity>{
	/**
	 *
	 * @param t is an entity to be validated
	 * @return true if entity is validated and false if is not
	 */
	boolean validate(T t);
}
