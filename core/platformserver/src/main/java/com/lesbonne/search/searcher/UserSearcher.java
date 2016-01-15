package com.lesbonne.search.searcher;

import java.util.List;
import java.util.Map;

public interface UserSearcher {
	
	List<Map<String, Object>> searchUserEmail(String keyword, int start, int end) throws Exception;
}
