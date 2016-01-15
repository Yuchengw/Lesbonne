package com.lesbonne.entity;

import java.util.Map;

public interface EntityBean {
	
	Map<String, Object> getIndexedColumns();
	String getId();
}
