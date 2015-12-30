package com.lesbonne.business.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author yucheng
 * @since 1
 * */
public class SharingPost extends BeanObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4300956584319358637L;

	private String sharingPostId;
	
	private User owner;
	
	private String sharingPostSubject;
	
	private String category;
	
	private List<PostComment> postComments;
	
	private String partnerId;
	
	private String expiredAt;

	public String getSharingPostId() {
		return sharingPostId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getSharingPostSubject() {
		return sharingPostSubject;
	}

	public void setSharingPostSubject(String sharingPostSubject) {
		this.sharingPostSubject = sharingPostSubject;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<PostComment> getPostComments() {
		return postComments;
	}

	public void setPostComments(List<PostComment> postComments) {
		this.postComments = postComments;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(String expiredAt) {
		this.expiredAt = expiredAt;
	}
}
