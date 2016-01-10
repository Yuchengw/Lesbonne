package com.lesbonne.search.indexer;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;

public interface EntityIndexer {
	IndexResponse create() throws Exception;
	
	UpdateResponse update() throws Exception;
}
