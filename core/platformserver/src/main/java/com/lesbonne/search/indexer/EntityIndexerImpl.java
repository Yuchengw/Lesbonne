package com.lesbonne.search.indexer;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;

import com.lesbonne.entity.EntityBean;

public class EntityIndexerImpl implements EntityIndexer {
	
	private EntityBean entity;
	private String type;
	
	public EntityIndexerImpl(String type, EntityBean entity) {
		this.entity = entity;
		this.type = type;
	}
	
	@Override
	public IndexResponse create() throws Exception {
		IndexerClient client = new IndexerClientImpl();
		
		return client.createIndex(this.type, this.entity);
	}

	@Override
	public UpdateResponse update() throws Exception {
		IndexerClient client = new IndexerClientImpl();
		
		return client.updateIndex(this.type, this.entity);
	}
	
}
