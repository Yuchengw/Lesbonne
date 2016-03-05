package com.lesbonne.entity;

import java.util.Map;

public interface EntityBean {
	
	Map<String, Object> indexedColumns();
	String id();
}
