package com.lesbonne.search.indexer;

import java.io.IOException;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;

import com.lesbonne.entity.EntityBean;

public interface IndexerClient {
	
	final String indexName = "elasticsearch";
	
	IndexResponse createIndex(String type, EntityBean entity) throws IOException;
	
	UpdateResponse updateIndex(String type, EntityBean entity) throws Exception;
	
	void deleteIndex();
	
	void getIndex();
}
