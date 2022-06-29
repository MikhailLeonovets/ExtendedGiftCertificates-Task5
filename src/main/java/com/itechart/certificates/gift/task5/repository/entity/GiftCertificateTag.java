package com.itechart.certificates.gift.task5.repository.entity;

import com.itechart.certificates.gift.task5.repository.entity.mapped_super_class.Identity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "gift_certificate_tag", schema = "gift_certificates_task5")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GiftCertificateTag extends Identity {
	@ManyToOne
	@JoinColumn(name = "gift_certificate_id")
	private GiftCertificate giftCertificate;
	@ManyToOne
	@JoinColumn(name = "tag_id")
	private Tag tag;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		GiftCertificateTag that = (GiftCertificateTag) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
