package com.targa.labs.myBoutique.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.targa.labs.myBoutique.commons.domain.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends AbstractEntity {

	@NotNull
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotNull
	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne
	private Department department;

	public Category(@NotNull String name, @NotNull String description) {
		this.name = name;
		this.description = description;
	}
}
