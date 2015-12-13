package com.lesbonne.postcomment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.sharingpost.SharingPost;

@Entity
@Table(name = "POSTCOMMENT")
/**
 * @author yucheng
 * @since 1
 * */
public class PostComment {

	@Id
	@Column(name = "POSTCOMMENTID", columnDefinition="VARCHAR(18) NOT NULL")
	private String postCommentId;
	
	@Column(name = "OWNERID", columnDefinition="VARCHAR(18) NOT NULL")
	private String ownerId;
	
	@Column(name = "COMMENTBODY", columnDefinition="VARCHAR(1023)")
	private String commentBody;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASKINGPOSTID")
	private AskingPost askingPost;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHARINGPOSTID")
	private SharingPost sharingPost;
	
	@Column(name = "ATUSER", columnDefinition="VARCHAR(19999)")
	private String atUser;
	
	@Column(name = "CREATEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdTime;
	
	@Column(name = "LASTMODIFIEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedTime;
}
