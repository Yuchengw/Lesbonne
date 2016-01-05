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
@Table(name="LESBONNEORDER")
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 379661088187729287L;
	@Id
	@Column(name = "ORDERID", columnDefinition="VARCHAR(18)")
	private String orderId;

	// TODO: need another ID to specify the order target.
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERID", referencedColumnName = "USERID", insertable=false, updatable=false)
	private User owner;
	
	@Column(name = "CREATEDATE", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdDate;
	
	@Column(name = "LASTMODIFIEDATE", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedDate;

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

	public String getCreatedDate() {
		return createdDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedTime(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
