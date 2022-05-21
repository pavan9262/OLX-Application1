package com.zensar.rest;


import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.entity.Coupon;

@FeignClient("COUPON-SERVICES")
//@LoadBalancerClient("COUPON-SERVICES")
public interface CouponClient {
	
	@GetMapping("/couponapi/coupon/{couponCode}")
	Coupon getCoupon(@PathVariable("couponCode") String code);
}
