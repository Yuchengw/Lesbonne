package com.lesbonne.search.searcher;

import java.util.HashMap;
import java.util.Map;

public class SearchCriteria {
	private final String type;
	private final int start;
	private final int end;
	private final Map<String, Object> fieldQueries;
	
	public SearchCriteria(String type, int start, int end) {
		this.type = type;
		this.start = start;
		this.end = end;
		this.fieldQueries = new HashMap<String, Object>();
	}
	
	public void addFieldQuery(String field, Object keyword) {
		this.fieldQueries.put(field, keyword);
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
	
	public Map<String, Object> getFieldQueries() {
		return this.fieldQueries;
	}
	
}
