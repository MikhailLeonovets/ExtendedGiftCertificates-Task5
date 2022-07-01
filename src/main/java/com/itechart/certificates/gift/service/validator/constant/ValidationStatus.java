package com.itechart.certificates.gift.service.validator.constant;

import lombok.Getter;

@Getter
public enum ValidationStatus {
	VALIDATED(true),
	NOT_VALIDATED(false);

	public final Boolean boolean_status;

	ValidationStatus(Boolean boolean_status) {
		this.boolean_status = boolean_status;
	}

}
