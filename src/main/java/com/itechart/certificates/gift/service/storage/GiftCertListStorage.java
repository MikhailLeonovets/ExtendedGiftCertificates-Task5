package com.itechart.certificates.gift.service.storage;

import com.itechart.certificates.gift.service.model.GiftCertificateAndItsTags;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
public class GiftCertListStorage {
	private List<List<GiftCertificateAndItsTags>> giftCertLists;


}
