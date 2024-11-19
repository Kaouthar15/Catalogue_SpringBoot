package com.ntt.Catalogue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.Catalogue.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
