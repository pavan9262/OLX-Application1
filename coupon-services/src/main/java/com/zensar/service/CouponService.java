package com.zensar.service;

import java.util.List;

import com.zensar.entity.CouponDto;

public interface CouponService {

	List<CouponDto> getAllCoupons();

	CouponDto createCoupon(CouponDto coupon, String token);

	String deleteCoupon(long id);

	CouponDto updateCoupon(long couponId, CouponDto coupon);

	String deleteAllCoupons();

	CouponDto findByCouponCode(String couponCode);
}
