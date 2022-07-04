package com.itechart.certificates.gift.service.model;

import com.itechart.certificates.gift.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.repository.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class GiftCertificateAndItsTags {
	private GiftCertificate giftCertificate;
	private Set<Tag> itsTags;
}
