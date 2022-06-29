package com.itechart.certificates.gift.task5.repository.entity;

import com.itechart.certificates.gift.task5.repository.entity.mapped_super_class.Identity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "gift_certificate", schema = "gift_certificates_task5")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GiftCertificate extends Identity {
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	@Column(name = "date_of_creation", nullable = false)
	private LocalDateTime dateOfCreation;
	@Column(name = "date_of_modification")
	private LocalDateTime dateOfModification;
	@Column(name = "duration")
	private Period duration;
}
