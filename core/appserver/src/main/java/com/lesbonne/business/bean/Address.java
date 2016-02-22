package com.lesbonne.business.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("state")
	private String state;
	@JsonProperty("zipcode")
	private String zipcode;
	@JsonProperty("userId")
	private String userId;
	private String longitude;
	private String latitude;
	
	public String getUserID() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
}
