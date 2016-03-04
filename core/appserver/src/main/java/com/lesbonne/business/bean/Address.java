package com.lesbonne.business.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends BeanObject implements Serializable {
	
	@JsonProperty("addressId")
	private String addressId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("street1")
	private String street1;
	@JsonProperty("street2")
	private String street2;
	@JsonProperty("city")
	private String city;
	@JsonProperty("country")
	private String country;
	@JsonProperty("state")
	private String state;
	@JsonProperty("zipcode")
	private String zipcode;
	@JsonProperty("user")
	private User user;
	@JsonProperty("longitude")
	private String longitude;
	@JsonProperty("latitude")
	private String latitude;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public double getLongitude() {
		return Double.valueOf(longitude);
	}
	public void setLongitude(double longitude) {
		this.longitude = String.valueOf(longitude);
	}
	public double getLatitude() {
		return Double.valueOf(latitude);
	}
	public void setLatitude(double latitude) {
		this.latitude = String.valueOf(latitude);
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	/**
	 * @return
	 * Salesforce.com
	 * 1 Market Street
	 * San Francisco, CA 94105
	 */
	public String toString() {
		return String.format("%s\n%s\n%s\n%s, %s %s", getName(), getStreet1(), getStreet2(), getCity(), getState(), getZipcode());
	}
}
