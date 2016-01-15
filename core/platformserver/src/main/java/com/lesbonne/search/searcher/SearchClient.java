package com.lesbonne.search.searcher;

import java.io.IOException;

import org.elasticsearch.search.SearchHits;

public interface SearchClient {
	final String indexName = "elasticsearch";
	
	SearchHits search(SearchCriteria rule) throws IOException;
}
