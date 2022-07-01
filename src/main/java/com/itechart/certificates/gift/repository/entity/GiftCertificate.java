package com.itechart.certificates.gift.repository.entity;

import com.itechart.certificates.gift.repository.entity.mapped_super_class.Identity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;

@Entity
@Table(name = "gift_certificate", schema = "gift_certificates_task5")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GiftCertificate extends Identity {
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	@Column(name = "description", nullable = false, unique = true)
	private String description;
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	@Column(name = "date_of_creation", nullable = false)
	private LocalDateTime dateOfCreation;
	@Column(name = "date_of_modification")
	private LocalDateTime dateOfModification;
	@Column(name = "duration")
	private Period duration;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		GiftCertificate that = (GiftCertificate) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
