package com.lesbonne.search.searcher;

import java.util.HashMap;
import java.util.Map;

public class SearchCriteria {
	private final String type;
	private final int start;
	private final int end;
	private final Map<String, String> fieldQueries;
	
	public SearchCriteria(String type, int start, int end) {
		this.type = type;
		this.start = start;
		this.end = end;
		this.fieldQueries = new HashMap<String, String>();
	}
	
	public void addFieldQuery(String field, String keywords) {
		this.fieldQueries.put(field, keywords);
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getStart() {
		return this.start;
	}
	
	public int getEnd() {
		return this.end;
	}
	
	public Map<String, String> getFieldQueries() {
		return this.fieldQueries;
	}
	
}
