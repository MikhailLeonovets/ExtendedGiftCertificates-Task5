package com.itechart.certificates.gift.repository;

import com.itechart.certificates.gift.repository.entity.GiftCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GiftCertificateRepository extends JpaRepository<GiftCertificate, Long> {
	Optional<GiftCertificate> findByName(String name);

}
