package com.lesbonne.search.searcher;

import java.io.IOException;
import java.util.Map.Entry;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.elasticsearch.search.SearchHits;

public class SearchClientImpl implements SearchClient {
	
	private Client client;
	
	public SearchClientImpl() throws Exception {
		init();
	}
	
	private void init() throws Exception{
		Node node = new NodeBuilder()
			        .settings(Settings.settingsBuilder().put("http.enabled", false))
			        .client(true)
			    .node();

		this.client = node.client();
	}
	
	@Override
	public SearchHits search(SearchCriteria rule) throws IOException {
		SearchRequestBuilder request = client.prepareSearch("lesbonne")
                .setTypes(rule.getType())
                .setSearchType(SearchType.QUERY_AND_FETCH);
        
        for (Entry<String, String> entry : rule.getFieldQueries().entrySet()) {
        	request.setQuery(QueryBuilders.wildcardQuery(entry.getKey(), String.format("*%s*", entry.getValue())));
        }
        
        SearchResponse response = request.setFrom(rule.getStart()).setSize(rule.getEnd()).setExplain(true)
                .execute()
                .actionGet();
		
        return response.getHits();
	}
	
	@Override
	public void close() {
		this.client.close();
	}
}
