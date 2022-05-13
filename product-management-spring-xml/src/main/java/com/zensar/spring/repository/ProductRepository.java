package com.zensar.spring.repository;

import com.zensar.spring.beans.Product;

public interface ProductRepository {

	public int insertProduct(Product product);

	public int updateProduct(Product product);

	public boolean deleteProductById(int productId);

}
