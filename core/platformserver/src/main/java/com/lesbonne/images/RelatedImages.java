package com.lesbonne.images;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Represents the image information from UserProfiles, Posts and so on
 * @author jassica
 *
 */
@Entity
@Table(name="LESBONNEIMAGES")
public class RelatedImages {
	@Id
	@Column(name = "id", nullable = false, unique = true, columnDefinition = "VARCHAR(18)")
	@GenericGenerator(strategy="com.lesbonne.mysqldb.DBIdGenerator",name="imageIdGenerator",
					parameters = {@Parameter(name = "prefix", value = "002")})
	@GeneratedValue(generator="imageIdGenerator")
    private String id;
 
    @Column(name="name")
    private String name;
 
    @Column(name="description")
    private String description;
 
    @Column(name="filename")
    private String filename;
 
//    @Column(name="content")
//    @Lob
//    private Blob content;
    @Column(name="content")
    private String content;
     
    @Column(name="content_type")
    private String contentType;
     
    @Column(name="created")
    private Date created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContentType() {
		return contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
