package com.project.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.springrest.entities.Product;
import com.project.springrest.services.ProductService;


@RestController
public class ProductController
{

	@Autowired
	private ProductService productsevice;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome";
	}
	
	//get the menu
	@GetMapping("/menu")
	public List<Product> getProducts() 
	{
		return this.productsevice.getProducts();
	}
	
	@GetMapping("/menu/{productId}")
	public Product getProduct(@PathVariable String productId)
	{
		return this.productsevice.getProduct(Long.parseLong(productId));
	}
	
	@PostMapping("/menu")
	public Product addProduct(@RequestBody Product prod)
	{
		return this.productsevice.addProduct(prod);
	}
	
	@PutMapping("/menu")
	public Product updateProduct(@RequestBody Product prod) {
		return this.productsevice.updateProduct(prod);
		
	}
	
	//delete product
	@DeleteMapping("/menu/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId)
	{
		try {
			this.productsevice.deleteProduct(Long.parseLong(productId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
