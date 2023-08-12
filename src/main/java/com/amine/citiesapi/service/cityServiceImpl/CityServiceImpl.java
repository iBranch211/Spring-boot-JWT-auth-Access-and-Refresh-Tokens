package com.amine.citiesapi.service.cityServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.amine.citiesapi.dao.CityRepository;
import com.amine.citiesapi.entities.City;
import com.amine.citiesapi.exceptions.CityNotFoundException;
import com.amine.citiesapi.service.CityService;
import com.amine.citiesapi.utils.GlobalValues;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository cityRepository;

	public List<City> findAllCities(int pageN, int pageSize) {
		Pageable pageable = PageRequest.of(pageN, pageSize);
		Page<City> pageableCities = cityRepository.findAll(pageable);
		List<City> cities = pageableCities.getContent();
		return cities;
	}
	
	public Map<String, Long> getPaginationInformation(){
		Pageable pageable = PageRequest.of(0, GlobalValues.paginationPageSize);
		Page<City> pageableCities = cityRepository.findAll(pageable);
		Map<String, Long> map = new HashMap<>();
		map.put("totalPages",  Integer.toUnsignedLong(pageableCities.getTotalPages()));
		map.put("totalElements", pageableCities.getTotalElements());
		
		return map;
	}

	public City saveCity(City city) {
		cityRepository.save(city);
		return city;
	}

	public City findCityById(int id) {
		Optional<City> city = cityRepository.findById(id);
		if (city.isEmpty()) {
			throw new CityNotFoundException("Cannot find this city");
		} else {
			return city.get();
		}
	}

	public City updateCityById(int id, City city) {
		
		City cityToUpdate = findCityById(id);

		cityToUpdate.setCity(city.getCity());

		cityToUpdate.setCity_ascii(city.getCity_ascii());

		cityToUpdate.setLat(city.getLat());

		cityToUpdate.setLng(city.getLng());

		cityToUpdate.setCountry(city.getCountry());

		cityToUpdate.setIso2(city.getIso2());

		cityToUpdate.setIso3(city.getIso3());

		cityToUpdate.setAdmin_name(city.getAdmin_name());

		cityToUpdate.setCapital(city.getCapital());

		cityToUpdate.setPopulation(city.getPopulation());

		cityToUpdate.setCity_id(city.getCity_id());

		return cityRepository.save(cityToUpdate);
	}

	public void deleteCityById(int id) {
		City cityToDelete = findCityById(id);
		cityRepository.delete(cityToDelete);
	}
	
	public List<City> findCitiesByIso3(String iso3) {
		return cityRepository.findCitiesByIso3(iso3);
	}

}