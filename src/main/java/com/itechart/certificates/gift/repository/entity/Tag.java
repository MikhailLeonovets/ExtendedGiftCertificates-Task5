package com.itechart.certificates.gift.repository.entity;

import com.itechart.certificates.gift.repository.entity.mapped_super_class.Identity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tag", schema = "gift_certificates_task5")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Tag extends Identity {
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Tag tag = (Tag) o;
		return getId() != null && Objects.equals(getId(), tag.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
