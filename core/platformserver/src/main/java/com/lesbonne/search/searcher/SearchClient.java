package com.lesbonne.search.searcher;

import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

public interface SearchClient {
	final String indexName = "elasticsearch";
	
	SearchHits search(SearchCriteria rule) throws Exception;
	
	SearchHit[] searchLocation(LocationSearchCriteria rule) throws Exception;
}
