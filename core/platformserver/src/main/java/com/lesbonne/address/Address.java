package com.lesbonne.address;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.elasticsearch.common.geo.GeoPoint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.lesbonne.entity.EntityBean;
import com.lesbonne.user.User;

/**
 * @author shuchun.yang
 * @since 1
 * */
@Entity
@Table(name = "Address")
public class Address implements Serializable, EntityBean{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5977747993416662711L;

	@Id
	@Column(name="ADDRESSID", columnDefinition="VARCHAR(18) NOT NULL")
	@GenericGenerator(strategy="com.lesbonne.mysqldb.DBIdGenerator",name="addressIdGenerator",
		parameters = {@Parameter(name = "prefix", value = "005")})
	@GeneratedValue(generator="addressIdGenerator")
	private String addressId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERID", referencedColumnName = "USERID", insertable=false, updatable=false)
	private User userAddress;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR(100) NOT NULL")
	private String name;
	
	@Column(name = "STREET1", columnDefinition = "VARCHAR(255) NOT NULL")
	private String street1;
	
	@Column(name = "STREET2", columnDefinition = "VARCHAR(255)")
	private String street2;
	
	@Column(name = "CITY", columnDefinition = "VARCHAR(50) NOT NULL")
	private String city;
	
	@Column(name = "STATE", columnDefinition = "VARCHAR(2) NOT NULL")
	private String state;
	
	@Column(name = "ZIPCODE", columnDefinition = "VARCHAR(10) NOT NULL")
	private String zipcode;
	
	@Column(name = "COUNTRY", columnDefinition = "VARCHAR(10)")
	private String country;
	
	@Column(name = "CREATEDATE", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private Date createdDate;
	
	@Column(name = "LASTMODIFIEDATE", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date lastModifiedDate;
	
	@Column(name = "LONGITUDE", columnDefinition="DOUBLE(3,10)")
	private double longitude;
	
	@Column(name = "LATITUDE", columnDefinition="DOUBLE(3,10)")
	private double latitude;

	@PrePersist
	public void onCreate() {
		lastModifiedDate = createdDate = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		lastModifiedDate = new Date();
	}
	
	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public User getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(User userAddress) {
		this.userAddress = userAddress;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public GeoPoint getGeoPoint() {
		return new GeoPoint(getLatitude(), getLongitude());
	}

	@Override
	public Map<String, Object> getIndexedColumns() {
		Map<String, Object> searchableColumns = new HashMap<String, Object>();
		searchableColumns.put("name", getName());
		searchableColumns.put("street1", getStreet1());
		searchableColumns.put("street2", getStreet2());
		searchableColumns.put("city", getCity());
		searchableColumns.put("state", getState());
		searchableColumns.put("zipcode", getZipcode());
		searchableColumns.put("location", getGeoPoint());
		searchableColumns.put("userId", getUserAddress().getUserId());
		return searchableColumns;
	}

	@Override
	public String getId() {
		return getAddressId();
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
