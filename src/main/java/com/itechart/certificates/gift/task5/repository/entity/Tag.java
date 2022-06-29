package com.itechart.certificates.gift.task5.repository.entity;

import com.itechart.certificates.gift.task5.repository.entity.mapped_super_class.Identity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tag", schema = "gift_certificates_task5")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Tag extends Identity {
	@Column(name = "name", nullable = false)
	private String name;
}
