package com.lesbonne.api.rest;

/**
 * @author yucheng
 * @since 1
 * */
import java.io.IOException;

import org.apache.commons.httpclient.HttpMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lesbonne.api.config.ApiProtocol;

public interface RestApiUtil {

	void setSetAuthHeader(boolean b);

	public <T> T deserializeFromJson(HttpMethod method, Class<T> expectedType) throws JsonParseException, JsonMappingException, IOException;

	int executeRequest(String url, HttpMethod method, ApiProtocol protocol) throws Exception;

	int executeRequest(HttpMethod method, ApiProtocol restjson) throws Exception;
}
