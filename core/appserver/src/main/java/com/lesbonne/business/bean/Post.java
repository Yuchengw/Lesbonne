package com.lesbonne.business.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

/**
 * @author yucheng
 * @since 1
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post extends BeanObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8923263466009616568L;
	
	// Final static constant for different post types, Note: the post is immutable.
	final static String REQUEST = "REQUEST";
	final static String PROVIDE = "PROVIDE";

	// private fields
	private String Id;
	private String subject;
	private String location;
	private int quantity;
	private String commentsOrDescription;
	private double cost;
	private Object image;
	private User[] partners;
	private String postCategory;
	private int numberOfOrders; // TODO: more detail
	private int numberOfLikes;
	private User creator;
	private User lastModifiedBy;
	private String type;
	private Date startDate;
	private Date endDate;
	private Date expireDate;
	private boolean useMap;
	private boolean couldInvite;
	private boolean isSecret;

	public Post(String id, User creator, String subject, String location, int quantity) {
		setId(id);
		setCreator(creator);
		setSubject(subject);
		setLocation(location);
		setQuantity(quantity);
		setPostCategory("Food");
	}

	public Post(String id) {
		setId(id);
	}
	
	public Post() {
	}

	/* Getters and Setters */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getId() {
		return Id;
	}
	
	public void  setId(String id) {
		this.Id = id;
		super.setId(id);
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCommentsOrDescription() {
		return commentsOrDescription;
	}

	public void setCommentsOrDescription(String commentsOrDescription) {
		this.commentsOrDescription = commentsOrDescription;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Object getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User[] getPartners() {
		return partners;
	}

	public void setPartners(User[] partners) {
		this.partners = partners;
	}

	public String getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}

	public int getNumberOfOrders() {
		return numberOfOrders;
	}

	public void setNumberOfOrders(int numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}

	public int getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
	public boolean isUseMap() {
		return useMap;
	}

	public void setUseMap(boolean useMap) {
		this.useMap = useMap;
	}
	
	public boolean isCouldInvite() {
		return couldInvite;
	}

	public void setCouldInvite(boolean couldInvite) {
		this.couldInvite = couldInvite;
	}
	
	public boolean isSecret() {
		return isSecret;
	}

	public void setSecret(boolean isSecret) {
		this.isSecret = isSecret;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setImage(Object image) {
		this.image = image;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
