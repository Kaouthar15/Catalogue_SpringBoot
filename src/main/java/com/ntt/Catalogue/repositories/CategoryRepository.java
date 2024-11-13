package com.ntt.Catalogue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.Catalogue.models.Category;

@Repository
public interface CategoryRepository extends  JpaRepository<Category, Long>{

}
