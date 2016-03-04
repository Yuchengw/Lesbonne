package com.lesbonne.search.searcher;

public class LocationSearchCriteria extends SearchCriteria{
	
	private int distance;
	
	public LocationSearchCriteria(String type, int start, int end, int distance) {
		super(type, start, end);
		this.distance = distance;
	}
	
	public int getDistance() {
		return distance;
	}	
}
