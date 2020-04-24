package com.targa.labs.myBoutique.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Embeddable
@NoArgsConstructor
public class Address {

	@Column(name = "address_1")
	private String address1;

	@Column(name = "address_2")
	private String address2;

	@Column(name = "city")
	private String City;


	@Column(name = "postcode")
	private String postcode;


	@Column(name = "country")
	private String country ;

}
