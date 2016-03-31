package com.lesbonne.search.searcher;

import org.elasticsearch.search.SearchHit;

public interface SearchClient {
	final String indexName = "elasticsearch";
	
	SearchHit[] searchUserEmail(SearchCriteria rule) throws Exception;
	
	SearchHit[] searchCityOrZipcode(SearchCriteria rule) throws Exception;
	
	SearchHit[] searchNearbyLocation(LocationSearchCriteria rule) throws Exception;
}
