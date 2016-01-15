package com.lesbonne.search.searcher;

import java.util.List;
import java.util.Map;

import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import com.google.common.collect.Lists;

public class UserSearcherImpl implements UserSearcher {
	
	@Override
	public List<Map<String, Object>> searchUserEmail(String keyword, int start, int end) throws Exception {
		SearchClient client = new SearchClientImpl();
		List<Map<String, Object>> results = Lists.newArrayList();
		
		SearchCriteria rule = new SearchCriteria("user",start,end);
		rule.addFieldQuery("email", keyword);
		SearchHits hits = client.search(rule);
		for (SearchHit hit : hits.getHits()) {
			results.add(hit.getSource());
		}
		
		return results;
	}
}
