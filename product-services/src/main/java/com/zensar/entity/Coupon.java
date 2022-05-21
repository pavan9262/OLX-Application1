package com.zensar.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

	private long couponId;
	private String couponCode;
	private double discount;
	private String expDate;
}
