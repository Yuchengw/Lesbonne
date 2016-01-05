package com.lesbonne.business.bean;

import java.io.Serializable;

/**
 * @author yucheng
 * @since 1
 * */
public class Partner extends BeanObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6574391556742383238L;

	private String partnerId;
	
	private User userPartner1;
	
	private User userPartner2;

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
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
