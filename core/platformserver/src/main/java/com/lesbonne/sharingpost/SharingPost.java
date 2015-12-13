package com.lesbonne.sharingpost;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lesbonne.postcomment.PostComment;
import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * */
@Entity
@Table(name = "SHARINGPOST")
public class SharingPost implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3170417062437731814L;

	@Id
	@Column(name="SHARINGPOSTID", columnDefinition="VARCHAR(18) NOT NULL")
	private String sharingPostId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable=false, updatable=false)
	private User owner;
	
	@Column(name="SHARINGPOSTSUBJECT", columnDefinition="VARCHAR(255) NOT NULL")
	private String sharingPostSubject;
	
	@Column(name="CATEGORY", columnDefinition="VARCHAR(255) NOT NULL")
	private String category;
	
	@OneToMany(mappedBy = "sharingPost")
	private List<PostComment> postComments;
	
	@Column(name="PARTNERID", columnDefinition="VARCHAR(18)")
	private String partnerId;
	
	@Column(name="EXPIREDAT", columnDefinition="DATETIME NOT NULL")
	private String expiredAt;
	
	@Column(name="CREATEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdTime;
	
	@Column(name="LASTMODIFIEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedTime;
	
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

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
