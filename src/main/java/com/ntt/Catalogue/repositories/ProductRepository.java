package com.ntt.Catalogue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.Catalogue.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{ 

}
