package com.itechart.certificates.gift.task5.repository;

import com.itechart.certificates.gift.task5.repository.entity.GiftCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GiftCertificateRepository extends JpaRepository<GiftCertificate, Long> {
	Optional<GiftCertificate> findByName(String name);
}
