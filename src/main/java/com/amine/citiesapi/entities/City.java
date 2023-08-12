package com.amine.citiesapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@NotBlank(message = "City can't be blank")
	private String city;
	@NotNull
	@NotBlank(message = "City ascii can't be blank")
	private String city_ascii;
	@NotNull
	private Double lat;
	@NotNull
	private Double lng;
	@NotNull
	@NotBlank(message = "Country can't be blank")
	private String country;
	@NotNull
	@NotBlank(message = "Iso2 can't be blank")
	private String iso2;
	@NotNull
	@NotBlank(message = "Iso3 can't be blank")
	private String iso3;
	@NotBlank(message = "Admin name can't be blank")
	private String admin_name;
	@NotBlank(message = "Capital can't be blank")
	private String capital;
	private Long population;
	@NotNull
	private Long city_id;

	public City(int id, String city, String city_ascii, Double lat, Double lng,
			String country, String iso2, String iso3, String admin_name,
			 String capital, Long population, Long city_id) {
		super();
		this.id = id;
		this.city = city;
		this.city_ascii = city_ascii;
		this.lat = lat;
		this.lng = lng;
		this.country = country;
		this.iso2 = iso2;
		this.iso3 = iso3;
		this.admin_name = admin_name;
		this.capital = capital;
		this.population = population;
		this.city_id = city_id;
	}

	public City() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity_ascii() {
		return city_ascii;
	}

	public void setCity_ascii(String city_ascii) {
		this.city_ascii = city_ascii;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Long getCity_id() {
		return city_id;
	}

	public void setCity_id(Long city_id) {
		this.city_id = city_id;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + ", city_ascii=" + city_ascii + ", lat=" + lat + ", lng=" + lng
				+ ", country=" + country + ", iso2=" + iso2 + ", iso3=" + iso3 + ", admin_name=" + admin_name
				+ ", capital=" + capital + ", population=" + population + ", city_id=" + city_id + "]";
	}

}
