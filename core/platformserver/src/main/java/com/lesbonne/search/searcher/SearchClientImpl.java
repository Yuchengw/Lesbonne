package com.lesbonne.search.searcher;

import java.util.Map.Entry;

import com.lesbonne.search.ElasticSearchClient;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

public class SearchClientImpl implements SearchClient {
	
	private Client client;
	
	public SearchClientImpl() throws Exception {
		init();
	}
	
	private void init() throws Exception{
		this.client = ElasticSearchClient.getInstance().getConnection();
	}
	
	@Override
	public SearchHits search(SearchCriteria rule) throws Exception {
		SearchRequestBuilder request = client.prepareSearch(indexName)
                .setTypes(rule.getType())
                .setSearchType(SearchType.QUERY_AND_FETCH);
        
        for (Entry<String, Object> entry : rule.getFieldQueries().entrySet()) {
        	request.setQuery(QueryBuilders.wildcardQuery(entry.getKey(), String.format("*%s*", entry.getValue())));
        }
        
        SearchResponse response = request.setFrom(rule.getStart()).setSize(rule.getEnd()).setExplain(true)
                .execute()
                .get();
		
        return response.getHits();
	}

	@Override
	public SearchHit[] searchLocation(LocationSearchCriteria rule) throws Exception {
		SearchRequestBuilder request = client.prepareSearch(indexName)
                .setTypes(rule.getType())
                .setSearchType(SearchType.QUERY_AND_FETCH);
		
		GeoPoint pin = (GeoPoint)rule.getFieldQueries().get("location");
		QueryBuilder geoQuery = QueryBuilders.geoDistanceQuery("location")  
			    .point(pin.getLat(), pin.getLon())                                 
			    .distance(rule.getDistance(), DistanceUnit.MILES)         
			    .optimizeBbox("memory")                         
			    .geoDistance(GeoDistance.SLOPPY_ARC); 
		
		QueryBuilder qb = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).filter(geoQuery);

		request.setQuery(qb);
		SearchResponse response = request.setFrom(rule.getStart()).setSize(rule.getEnd()).setExplain(true)
                .execute()
                .get();
		
        return response.getHits().getHits();
	}
}
