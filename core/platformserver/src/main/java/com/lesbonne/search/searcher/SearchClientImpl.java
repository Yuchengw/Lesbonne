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
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilteredQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

public class SearchClientImpl implements SearchClient {
	
	private Client client;
	
	public SearchClientImpl() throws Exception {
		init();
	}
	
	private void init() throws Exception{
		this.client = ElasticSearchClient.getInstance().getConnection();
	}
	
	private SearchHit[] search(SearchCriteria rule, QueryBuilder query) throws Exception {
		SearchRequestBuilder request = client.prepareSearch(indexName)
                .setTypes(rule.getType())
                .setSearchType(SearchType.QUERY_AND_FETCH);
		
		request.setQuery(query);
		
		SearchResponse response = request.setFrom(rule.getStart()).setSize(rule.getEnd()).setExplain(true)
                .execute()
                .get();
		
		return response.getHits().getHits();
	}
	
	@Override
	public SearchHit[] searchUserEmail(SearchCriteria rule) throws Exception {
		return null;
	}
	
	@Override
	public SearchHit[] searchCityOrZipcode(SearchCriteria rule) throws Exception {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        for (Entry<String, Object> entry : rule.getFieldQueries().entrySet()) {
        	boolQuery.should(QueryBuilders.termQuery(entry.getKey(), entry.getValue()));
        }
        
        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).filter(boolQuery);
        
        return search(rule, query);
	}

	@Override
	public SearchHit[] searchNearbyLocation(LocationSearchCriteria rule) throws Exception {
		GeoPoint pin = (GeoPoint)rule.getFieldQueries().get("location");
		QueryBuilder geoQuery = QueryBuilders.geoDistanceQuery("location")  
			    .point(pin.getLat(), pin.getLon())                                 
			    .distance(rule.getDistance(), DistanceUnit.MILES)         
			    .optimizeBbox("memory")                         
			    .geoDistance(GeoDistance.SLOPPY_ARC); 
		
		QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).filter(geoQuery);

		return search(rule, query);
	}
}
