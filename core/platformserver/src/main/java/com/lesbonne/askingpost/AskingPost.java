package com.lesbonne.askingpost;

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
@Table(name = "ASKINGPOST")
public class AskingPost implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7116449282620644263L;

	@Id
	@Column(name="ASKINGPOSTID", columnDefinition="VARCHAR(18) NOT NULL")
	private String askingPostId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERID", referencedColumnName = "USERID", insertable=false, updatable=false)
	private User owner;
	
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
	
	@Column(name = "CREATEDATE", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdDate;
	
	@Column(name = "LASTMODIFIEDDATE", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedDate;
	
	public String getAskingPostId() {
		return askingPostId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
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
