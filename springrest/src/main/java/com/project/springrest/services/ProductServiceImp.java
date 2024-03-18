package com.project.springrest.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springrest.entities.Product;
import com.project.springrest.repository.ProductRepo;

@Service
public class ProductServiceImp implements ProductService {
	
	 @Autowired
	 private ProductRepo productRepo;
	
	 //get menu
	 @Override
	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	 //get product from menu using id
	 @Override
		public Product getProduct(long productId) {
			return productRepo.findById(productId).get();
		}

	//add product to menu
	@Override
	public Product addProduct(Product prod)
	{
		productRepo.save(prod);
		return prod;
	}
	
	//update product in the menu
	@Override
	public Product updateProduct(Product prod) {
		
		productRepo.save(prod);
		return prod;
	}

	//delete product from menu
	@Override
	public void deleteProduct(long productId) {

		Product entity = productRepo.findById(productId).get();
		productRepo.delete(entity);
	}

}
