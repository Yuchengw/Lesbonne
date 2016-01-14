package com.lesbonne.search.indexer;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.Map.Entry;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;

import com.lesbonne.entity.EntityBean;
import com.lesbonne.search.ElasticSearchClient;

public class IndexerClientImpl implements IndexerClient {
	
	private Client client;
	
	public IndexerClientImpl() throws Exception{
		init();
	}
	
	private void init() throws Exception{		
		this.client = ElasticSearchClient.getInstance().getConnection();
	}

	@Override
	public IndexResponse createIndex(String type, EntityBean entity) throws IOException {
		XContentBuilder builder = jsonBuilder().startObject();
		
		for (Entry<String, Object> entry : entity.getIndexedColumns().entrySet()) {
			builder.field(entry.getKey(), entry.getValue());
		}
        builder.endObject();
		
		return this.client.prepareIndex(indexName, type, entity.getId()).setSource(builder).get();
	}

	@Override
	public UpdateResponse updateIndex(String type, EntityBean entity) throws Exception {
		XContentBuilder builder = jsonBuilder().startObject();
		
		for (Entry<String, Object> entry : entity.getIndexedColumns().entrySet()) {
			builder.field(entry.getKey(), entry.getValue());
		}
        builder.endObject();
		
		return this.client.prepareUpdate(indexName, type, entity.getId()).setSource(builder).get();
	}

	@Override
	public void deleteIndex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getIndex() {
		// TODO Auto-generated method stub
		
	}
}
