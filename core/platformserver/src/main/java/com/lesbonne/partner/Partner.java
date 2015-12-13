package com.lesbonne.partner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yucheng
 * @since 1
 * */
@Entity
@Table(name = "PARTNER")
public class Partner {	
	
	@Id
	@Column(name="PARTNERID", columnDefinition="VARCHAR(18) NOT NULL")
	private String partnerId;
	
	@Column(name="ID1", columnDefinition="VARCHAR(18)")
	/**
	 * This is the master id.
	 * */
	private String id1;
	
	@Column(name="ID2", columnDefinition="VARCHAR(18)")
	private String id2;
}
