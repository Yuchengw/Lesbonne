package com.lesbonne.sharingpost;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.lesbonne.postcomment.PostComment;
import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * @author Jassica
 * @since 2
 * */
@Entity
@Table(name = "SHARINGPOST")
public class SharingPost implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3170417062437731814L;

	@Id
	@Column(name = "SHARINGPOSTID", nullable = false, unique = true, columnDefinition = "VARCHAR(18)")
	@GenericGenerator(strategy="com.lesbonne.mysqldb.DBIdGenerator",name="sharingPostIdGenerator",
					parameters = {@Parameter(name = "prefix", value = "00s")})
	@GeneratedValue(generator="sharingPostIdGenerator")
	private String sharingPostId;
	
	@Column(name="SHARINGPOSTSUBJECT", columnDefinition="VARCHAR(255) NOT NULL")
	private String sharingPostSubject;
	
	@Column(name="CATEGORY", columnDefinition="VARCHAR(255) NOT NULL")
	private String category;
	
	@Column(name="PARTNERID", columnDefinition="VARCHAR(18)")
	private String partnerId;
	
	@Column(name="EXPIREDAT", columnDefinition="DATETIME NOT NULL")
	private String expiredAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATE", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LASTMODIFIEDDATE", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date lastModifiedDate;
	
	// Foreign keys
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", referencedColumnName = "USERID", nullable = false)//, insertable=false, updatable=false)
	private User owner;
	
	@OneToMany(mappedBy = "sharingPost", fetch = FetchType.LAZY)
	private Set<PostComment> postComments;
	
	
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

	public Set<PostComment> getPostComments() {
		return postComments;
	}

	public void setPostComments(Set<PostComment> postComments) {
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

	public void setCreatedTime(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedTime(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
