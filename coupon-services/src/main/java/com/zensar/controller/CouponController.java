package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Coupon;
import com.zensar.entity.CouponDto;
import com.zensar.repository.CouponRepository;
import com.zensar.service.CouponService;

@RestController
@RequestMapping("/couponapi")
public class CouponController {
	
	@Autowired
	private CouponService couponService;

	@GetMapping(value="/coupon/{couponCode}")
	public CouponDto findByCouponCode(@PathVariable String couponCode) {
		System.out.println("Server Instance 1");
	     return couponService.findByCouponCode(couponCode);
	}
	
	// Read all coupons
	// http://localhost:9000/coupon
	// @GetMapping("/coupons")
	@RequestMapping(method = RequestMethod.GET)
	public List<CouponDto> getAllCoupons() {
		return couponService.getAllCoupons();
	}


	// @PostMapping("/coupons")
	// Create a new coupon
	// @RequestMapping(value="/coupons",method = RequestMethod.POST)
	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping("/create")
	public ResponseEntity<CouponDto> createCoupons(@RequestBody CouponDto coupon,
			@RequestHeader("auth-token") String token) {

		CouponDto createCoupon = couponService.createCoupon(coupon, token);
		if (createCoupon == null) {
			return new ResponseEntity<CouponDto>(createCoupon, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<CouponDto>(createCoupon, HttpStatus.CREATED);
		}

	}

	// Delete specific coupon
	// @DeleteMapping("/coupons/{couponId}")
	@DeleteMapping("/coupon/{couponId}")
	public String deleteProduct(@PathVariable("couponId") long id) {
		return couponService.deleteCoupon(id);
	}

	// @PutMapping("/coupons/{couponId}")
	@PutMapping("/update/{productId}")
	public CouponDto updateCoupon(@PathVariable Integer couponId, @RequestBody CouponDto coupon) {
		return couponService.updateCoupon(couponId, coupon);
	}

	// To Remove All coupons
	@DeleteMapping
	public ResponseEntity<String> deleteAllCoupons() {
		String returnResult = couponService.deleteAllCoupons();

		return new ResponseEntity<String>(returnResult, HttpStatus.OK);

		// return couponService.deleteAllCoupons();

	}

}
