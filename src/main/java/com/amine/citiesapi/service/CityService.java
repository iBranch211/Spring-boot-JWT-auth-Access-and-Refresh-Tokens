package com.amine.citiesapi.service;

import java.util.List;
import java.util.Map;

import com.amine.citiesapi.entities.City;

public interface CityService {
	
	public List<City> findAllCities(int pageN, int pageSize);
	
	public Map<String, Long> getPaginationInformation();
	
	public City saveCity(City city);
	
	public City findCityById(int id);
	
	public City updateCityById(int id, City city);
	
	public void deleteCityById(int id);
	
	public List<City> findCitiesByIso3(String iso3);
	
}
