package com.lesbonne.partner;

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
@Table(name = "PARTNER")
public class Partner implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5749398012040736607L;

	@Id
	@Column(name="PARTNERID", columnDefinition="VARCHAR(18) NOT NULL")
	private String partnerId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERID1", referencedColumnName = "USERID", insertable=false, updatable=false)
	private User userPartner1;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERI2", referencedColumnName = "USERID", insertable=false, updatable=false)
	private User userPartner2;
	
	@Column(name = "CREATEDATE", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdDate;
	
	@Column(name = "LASTMODIFIEDATE", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedDate;
	
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public User getUserPartner1() {
		return userPartner1;
	}
	
	public void setUserPartner1(User userPartner1) {
		this.userPartner1 = userPartner1;
	}
	
	public User getUserPartner2() {
		return userPartner2;
	}
	
	public void setUserPartner2(User userPartner2) {
		this.userPartner2 = userPartner2;
	}
}
