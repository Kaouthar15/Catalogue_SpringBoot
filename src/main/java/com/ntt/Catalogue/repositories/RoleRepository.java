package com.ntt.Catalogue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.Catalogue.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
