package com.lesbonne.search.searcher;

import java.io.IOException;

import org.elasticsearch.search.SearchHits;

public interface SearchClient {
	final String indexName = "lesbonne";
	
	SearchHits search(SearchCriteria rule) throws IOException;
}
