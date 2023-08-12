package com.amine.citiesapi.dao.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amine.citiesapi.entities.auth.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Optional<Role> findByName(String name);

}
