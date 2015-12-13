package com.lesbonne.askingpost;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lesbonne.postcomment.PostComment;

/**
 * @author yucheng
 * @since 1
 * */
@Entity
@Table(name = "ASKINGPOST")
public class AskingPost {
	
	@Id
	@Column(name="ASKINGPOSTID", columnDefinition="VARCHAR(18) NOT NULL")
	private String askingPostId;
	
	@Column(name="OWNERID", columnDefinition="VARHCHAR(18) NOT NULL")
	private String ownerId;
	
	@Column(name="ASKINGPOSTSUBJECT", columnDefinition="VARCHAR(255) NOT NULL")
	private String askingPostSubject;
	
	@Column(name="CATEGORY", columnDefinition="VARCHAR(255) NOT NULL")
	private String category;
	
	@OneToMany(mappedBy = "askingPost")
	private List<PostComment> postComments;
		
	@Column(name="PARTNERID", columnDefinition="VARCHAR(18)")
	private String partnerId;
	
	@Column(name="EXPIREDAT", columnDefinition="DATETIME NOT NULL")
	private String expiredAt;
	
	@Column(name = "CREATEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdTime;
	
	@Column(name = "LASTMODIFIEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedTime;
	
	public String getAskingPostId() {
		return askingPostId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getAskingPostSubject() {
		return askingPostSubject;
	}

	public void setAskingPostSubject(String askingPostSubject) {
		this.askingPostSubject = askingPostSubject;
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
