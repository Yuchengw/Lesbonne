package com.lesbonne.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * */
@Entity
@Table(name="ORDER")
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 379661088187729287L;

	@Id
	@Column(name = "ORDERID", columnDefinition="VARCHAR(18) NOT NULL")
	private String orderId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERID", referencedColumnName="USERID", insertable=false, updatable=false)
	private User owner;
	
	@Column(name = "ID2", columnDefinition="VARCHAR(18) NOT NULL")
	private String id2;
	
	@Column(name = "CREATEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdTime;
	
	@Column(name = "LASTMODIFIEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedTime;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
