package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.entity.ProductDto;
import com.zensar.rest.CouponClient;
import com.zensar.service.ProductService;

@RestController
@RequestMapping("/productapi")
public class ProductController {

	/*
	 * @Autowired private RestTemplate restTemplate;
	 */

	@Autowired
	private CouponClient client;

	@Autowired
	private ProductService productService;;

	/*
	 * @RequestMapping(value="/product", method=RequestMethod.POST) public
	 * ProductDto createProduct(@RequestBody ProductDto product) { //Coupon coupon =
	 * restTemplate.getForObject("http://localhost:9000/couponapi/coupon/" +
	 * product.getCode(),Coupon.class); //Coupon coupon =
	 * restTemplate.getForObject("http://COUPON-SERVICES/couponapi/coupon/" +
	 * product.getCode(),Coupon.class); Coupon
	 * coupon=client.getCoupon(product.getCode());
	 * product.setPrice(product.getPrice()-(coupon.getDiscount())); return
	 * productRepository.save(product); }
	 */

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ProductDto createProduct(@RequestBody ProductDto product, @RequestHeader("auth-token") String token) {

		Coupon coupon = client.getCoupon(product.getCode());
		product.setPrice(product.getPrice() - (coupon.getDiscount()));

		return productService.createProduct(product, token);

	}

	// Read all products
	// http://localhost:9090/products
	// @GetMapping("/products")
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public List<ProductDto> getAllProducts() {
		return productService.getAllProducts();
	}

	// Read specific product
	// http:localhost:9000/products/{productId}
	// @GetMapping("/products/{productId}")
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	public ProductDto getProduct(@PathVariable long productId) {

		return productService.getProduct(productId);

	}

	/*
	 * // @PostMapping("/products") // Create a new product
	 * // @RequestMapping(value="/product",method = RequestMethod.POST)
	 * 
	 * @RequestMapping(value = "/product", method = RequestMethod.POST, produces = {
	 * MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes
	 * = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	 * public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto
	 * product,
	 * 
	 * @RequestHeader("auth-token") String token) {
	 * 
	 * ProductDto createProduct = productService.createProduct(product, token); if
	 * (createProduct == null) { return new
	 * ResponseEntity<ProductDto>(createProduct, HttpStatus.BAD_REQUEST); } else {
	 * 
	 * return new ResponseEntity<ProductDto>(createProduct, HttpStatus.CREATED); }
	 * 
	 * }
	 */

	// Delete specific product
	// @DeleteMapping("/products/{productId}")
	@DeleteMapping("/product/{productId}")
	public String deleteProduct(@PathVariable("productId") Integer id) {
		return productService.deleteProduct(id);
	}

	// @PutMapping("/products/{productId}")
	@PutMapping("/product/{productId}")
	public ProductDto updateProduct(@PathVariable Integer productId, @RequestBody ProductDto product) {
		return productService.updateProduct(productId, product);
	}

	// To Remove All products
	@DeleteMapping
	public ResponseEntity<String> deleteAllProducts() {
		String returnResult = productService.deleteAllProducts();

		return new ResponseEntity<String>(returnResult, HttpStatus.OK);

		// return productService.deleteAllProducts();

	}

}
