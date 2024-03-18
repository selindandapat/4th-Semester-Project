package com.project.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springrest.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
