package com.project.springrest.services;

import java.util.List;

import com.project.springrest.entities.Product;

public interface ProductService {

	public List<Product> getProducts();
	
	public Product getProduct(long productId);
	
	public Product addProduct(Product prod);
	
	public Product updateProduct(Product prod);
	
	public void deleteProduct(long parseLong);
}
