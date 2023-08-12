package com.amine.citiesapi.dao.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amine.citiesapi.entities.auth.AuthUser;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer>  {
	
	Optional<AuthUser> findByUsername(String username);
	Boolean existsByUsername(String username);
}
