package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long>{

	Coupon findByCouponCode(String couponCode);
	
}
