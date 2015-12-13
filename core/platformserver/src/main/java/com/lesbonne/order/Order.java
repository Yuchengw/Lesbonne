package com.lesbonne.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER")
public class Order {

	@Id
	@Column(name = "ORDERID", columnDefinition="VARCHAR(18) NOT NULL")
	private String orderId;
	
	@Column(name = "ID1", columnDefinition="VARCHAR(18) NOT NULL")
	/**
	 * BUYER ID
	 * */
	private String id1;
	
	@Column(name = "ID2", columnDefinition="VARCHAR(18) NOT NULL")
	private String id2;
	
	
	@Column(name = "CREATEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdTime;
	
	@Column(name = "LASTMODIFIEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedTime;
}
