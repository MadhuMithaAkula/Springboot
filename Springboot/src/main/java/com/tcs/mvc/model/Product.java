package com.tcs.mvc.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
	@NotBlank(message = "Product name can not be Blank")
	private String name;
	
	@NotBlank(message = "Brand can not be blant")
	private String brand;

	@NotBlank(message = "Made-in field can not be blank")
	private String madein;
	
	@Min(value = 0, message = "Price Shoudle Be greater than zero")
	private double price;
	
	@Max(value = 1, message = "Quantity must be at least one")
	private int quantity;

	@DecimalMax(value = "100.0",message = "Discountrate can not exceed 100")
	private int discountrate;
	
}
