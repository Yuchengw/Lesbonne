package com.lesbonne.askingpost;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lesbonne.entity.CommonEntityInfo;
import com.lesbonne.postcomment.PostComment;
import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * @author Jassica
 * @since 2
 * */
@Entity
@Table(name = "ASKINGPOST")
public class AskingPost extends CommonEntityInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7116449282620644263L;

	@Id
	@Column(name = "ASKINGPOSTID", nullable = false, unique = true, columnDefinition = "VARCHAR(18)")
	@GenericGenerator(strategy="com.lesbonne.mysqldb.DBIdGenerator",name="askingPostIdGenerator",
					parameters = {@Parameter(name = "prefix", value = "00a")})
	@GeneratedValue(generator="askingPostIdGenerator")
	private String askingPostId;
	
    @Column(name="ASKINGPOSTSUBJECT", columnDefinition="VARCHAR(255) NOT NULL")
	private String askingPostSubject;
	
	@Column(name="CATEGORY", columnDefinition="VARCHAR(255) NOT NULL")
	private String category;
	
	@Column(name="PARTNERID", columnDefinition="VARCHAR(18)")
	private String partnerId;
	
	@Column(name = "EXPIREDAT", columnDefinition = "DATETIME NOT NULL")
    private String expiredAt;
	
	// Foreign keys
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "USERID", referencedColumnName = "USERID", nullable = false)
    @JsonBackReference(value="user-askingpost")
	private User owner;
	
	@OneToMany(
            mappedBy = "askingPost", fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL }, targetEntity = PostComment.class)
    @JsonManagedReference(value="askingpost-postcomment")
	private Set<PostComment> postComments;
	
	public String getAskingPostId() {
		return askingPostId;
	}

	public void setAskingPostId(String askingPostId) {
        this.askingPostId = askingPostId;
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
}
