package com.itechart.certificates.gift.task5.repository.entity;

import com.itechart.certificates.gift.task5.repository.entity.mapped_super_class.Identity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "gift_certificate")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GiftCertificate extends Identity {
	private String name;
	private String description;
	private BigDecimal price;
	private LocalDateTime dateOfCreation;
	private LocalDateTime dateOfModification;
	private Period interval;
}
