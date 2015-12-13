package com.lesbonne.postcomment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.sharingpost.SharingPost;
import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * */
@Entity
@Table(name="POSTCOMMENT")
public class PostComment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8338209811001418675L;

	@Id
	@Column(name="POSTCOMMENTID", columnDefinition="VARCHAR(18) NOT NULL")
	private String postCommentId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERID", referencedColumnName = "USERID", insertable=false, updatable=false)
	private User owner;
	
	@Column(name="COMMENTBODY", columnDefinition="VARCHAR(1023)")
	private String commentBody;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ASKINGPOSTID", referencedColumnName = "ASKINGPOSTID", insertable=false, updatable=false)
	private AskingPost askingPost;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SHARINGPOSTID", referencedColumnName = "SHARINGPOSTID", insertable=false, updatable=false)
	private SharingPost sharingPost;
	
	@Column(name="ATUSER", columnDefinition="VARCHAR(19999)")
	private String atUser;
	
	@Column(name="CREATEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdTime;
	
	@Column(name="LASTMODIFIEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedTime;
	
	public String getPostCommentId() {
		return postCommentId;
	}
	
	public void setPostCommentId(String postCommentId) {
		this.postCommentId = postCommentId;
	}
	
	public User  getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public AskingPost getAskingPost() {
		return askingPost;
	}
	
	public void setAskingPost(AskingPost askingPost) {
		this.askingPost = askingPost;
	}
	
	public SharingPost getSharingPost() {
		return sharingPost;
	}
	
	public void setSharingPost(SharingPost sharingPost) {
		this.sharingPost = sharingPost;
	}
	
	public String getAtUser() {
		return atUser;
	}
	
	public void setAtUser(String atUser) {
		this.atUser = atUser;
	}
	
	public String getCreatedTime() {
		return createdTime;
	}
	
	public String getlastModifiedTime() {
		return lastModifiedTime;
	}
	
	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
