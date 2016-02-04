package com.lesbonne.postcomment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.entity.CommonEntityInfo;
import com.lesbonne.sharingpost.SharingPost;
import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * @author Jassica
 * @since 2
 * */
@Entity
@Table(name = "POSTCOMMENT")
public class PostComment extends CommonEntityInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8338209811001418675L;

	@Id
	@Column(name = "POSTCOMMENTID", nullable = false, unique = true, columnDefinition = "VARCHAR(18)")
	@GenericGenerator(strategy="com.lesbonne.mysqldb.DBIdGenerator",name="postCommentIdGenerator",
					parameters = {@Parameter(name = "prefix", value = "00c")})
	@GeneratedValue(generator="postCommentIdGenerator")
	private String postCommentId;

	@Column(name = "COMMENTBODY", columnDefinition = "VARCHAR(1023) NOT NULL")
	private String commentBody;


	@Column(name = "ATUSER", columnDefinition = "VARCHAR(19999)")
	private String atUser;

	// Foreign Keys
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "USERID", referencedColumnName = "USERID", nullable = false)
    @JsonBackReference(value="user-postcomment")
	private User owner;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHARINGPOSTID", referencedColumnName = "SHARINGPOSTID", nullable = true)
    @JsonBackReference(value="sharingpost-postcomment")
	private SharingPost sharingPost;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASKINGPOSTID", referencedColumnName = "ASKINGPOSTID", nullable = true)
	@JsonBackReference(value="askingpost-postcomment")
	private AskingPost askingPost;

	public String getPostCommentId() {
		return postCommentId;
	}

	public void setPostCommentId(String postCommentId) {
		this.postCommentId = postCommentId;
	}

	public User getOwner() {
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
	
	public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
}
