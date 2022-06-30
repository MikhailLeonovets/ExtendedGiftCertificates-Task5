package com.itechart.certificates.gift.task5.service.model;

import com.itechart.certificates.gift.task5.repository.entity.GiftCertificate;
import com.itechart.certificates.gift.task5.repository.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class GiftCertificateAndItsTags {
	private GiftCertificate giftCertificate;
	private List<Tag> itsTags;
}
