package com.zensar.spring.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	private NamedParameterJdbcTemplate template;

	public ProductRepositoryImpl1() {

	}

	/*public int insertProduct(Product product) {
		// createTable();
		String sql = "insert into product values(" + product.getProductId() + ",'" + product.getProductName() + "',"
				+ product.getProductCost() + ");";
		template.execute(sql);
		return 1;
	}*/

	public int insertProduct(Product product) {
		String sql = "INSERT INTO product (productId, productName, productCost) VALUES (:productId, :productName, :productCost)";

		Map<String, String> params = new HashMap<String, String>();

		params.put("productId", "1");
		params.put("productName", "Laptop");
		params.put("productCost", "80000");
		return template.update(sql, params);
	}

	// delete

	public boolean deleteProductById(int productId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("productId", productId);
		String sql = "delete from product where productId=:productId";

		return template.update(sql, namedParameters) > 0;
	}

//	// update

	public int updateProduct(Product product) {
		String sql = "update product set productName = :productName, productCost = :productCost where productId=:productId";

		Map<String, String> params = new HashMap<String, String>();

		params.put("productId", "2");
		params.put("productName", "Laptop");
		params.put("productCost", "80000");
		return template.update(sql, params);
	}
//
//	public void createTable() {
//		template.execute("create table product(productId int ,productName varchar(50),productCost int)");
//	}
//
	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

}
