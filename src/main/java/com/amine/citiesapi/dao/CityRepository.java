package com.amine.citiesapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amine.citiesapi.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	
	@Query("SELECT c FROM City c WHERE c.iso3 = ?1")
	public List<City> findCitiesByIso3(String iso3);
	
}
