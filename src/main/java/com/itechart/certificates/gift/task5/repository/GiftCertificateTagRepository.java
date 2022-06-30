package com.itechart.certificates.gift.task5.repository;

import com.itechart.certificates.gift.task5.repository.entity.GiftCertificateTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftCertificateTagRepository extends JpaRepository<GiftCertificateTag, Long> {
	List<GiftCertificateTag> findByTagId(Long tagId);

	List<GiftCertificateTag> findByGiftCertificateId(Long giftCertificateId);

}
