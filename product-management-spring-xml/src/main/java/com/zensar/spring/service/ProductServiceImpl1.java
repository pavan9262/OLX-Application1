package com.zensar.spring.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.spring.beans.Product;
import com.zensar.spring.repository.ProductRepository;


public class ProductServiceImpl1 implements ProductService {

	
	private ProductRepository repositoryImpl;

	public int insertProduct(Product product) {

		return repositoryImpl.insertProduct(product);
	}
	
	public boolean deleteProductById(int productId) {
		return repositoryImpl.deleteProductById(productId);
		
	}

	public int updateProduct(Product product) {
		return repositoryImpl.updateProduct(product);
		
		
	}
	
	public ProductRepository getRepositoryImpl() {
		return repositoryImpl;
	}

	public void setRepositoryImpl(ProductRepository repositoryImpl) {
		System.out.println("inside public void setRepositoryImpl(ProductRepository repositoryImpl !!)");
		this.repositoryImpl = repositoryImpl;
	}

	@PostConstruct
	public void myInit() {
		System.out.println("inside myInit() !!!");
	}

	@PreDestroy
	public void myDestroy() {
		System.out.println(" inside myDestroy()");
	}

}
