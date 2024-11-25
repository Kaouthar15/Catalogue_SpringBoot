package com.ntt.Catalogue.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ntt.Catalogue.models.Category;

@Repository
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(excerptProjection = Category.class)
public interface CategoryRepository extends  JpaRepository<Category, Long>{
	List<Category> findByName(String name);
}
