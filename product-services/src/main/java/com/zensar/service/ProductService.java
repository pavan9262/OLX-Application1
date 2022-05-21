package com.zensar.service;

import java.util.List;

import com.zensar.entity.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProducts();

	ProductDto getProduct(long productId);

	ProductDto createProduct(ProductDto product, String token);

	String deleteProduct(long productId);

	ProductDto updateProduct(long productId, ProductDto product);

	String deleteAllProducts();
}
