package com.tcs.mvc.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String name;
	private String brand;
	private String madein;
	private double price;
	private int quantity;
	private int discountrate;
	private double discountprice;
	private double stockvalue;
	private double taxrate;
	private double offerprice;
	private double finalprice;
}