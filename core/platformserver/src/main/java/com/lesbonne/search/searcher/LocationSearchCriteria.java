package com.lesbonne.search.searcher;

public class LocationSearchCriteria extends SearchCriteria{
	
	private int distance;
	private String type;
	
	public LocationSearchCriteria(String type, int start, int end) {
		super(type, start, end);
	}
	
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
