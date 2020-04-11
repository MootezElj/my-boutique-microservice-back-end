package com.targa.labs.myBoutique.product.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.targa.labs.myBoutique.commons.domain.AbstractEntity;
import com.targa.labs.myBoutique.product.domain.enmeration.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {
	
	@NotNull
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotNull
	@Column(name = "description", nullable = false)
	private String description;
	
	@NotNull
	@Column(name = "price", precision = 10, scale = 2, nullable = false)
	private BigDecimal price;

	private Integer discount = 0;

	@NotNull
	@Column(name = "price_before_discount", precision = 10, scale = 2, nullable = false)
	private BigDecimal priceBeforeDiscount;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status",nullable = false)
	private ProductStatus status;
	
	@Column(name = "sales_counter")
	private Integer salesCounter;

	@ManyToOne
	private Category category;

	private String image1 = "";
	private String image2 = "";
	private String image3 = "";
	private String image4 = "";




	public Product(@NotNull String name, @NotNull String description, @NotNull BigDecimal price,Integer discount, Integer quantity, @NotNull ProductStatus status, Integer salesCounter, String image1,String image2, String image3, String image4) {
		this.priceBeforeDiscount = price;
		if ( discount !=0 )
		{
			price = price.subtract(price.multiply(new BigDecimal(discount).divide(new BigDecimal(100))));
		}
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.status = status;
		this.salesCounter = salesCounter;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
	}

	public Product(@NotNull String name, @NotNull String description, @NotNull BigDecimal price, Integer quantity, @NotNull ProductStatus status, Integer salesCounter,  String image1,String image2, String image3, String image4) {
		this(name,description,price,0,quantity
				,status,salesCounter,image1,image2,image3,image4);
	}

	public Product(@NotNull String name, @NotNull String description, @NotNull BigDecimal price,Integer discount, Integer quantity, @NotNull ProductStatus status, Integer salesCounter,Category category,String image1,String image2, String image3, String image4) {
		this(name,description,price,discount,quantity
				,status,salesCounter,image1,image2,image3,image4);
		this.category = category;
	}


}
