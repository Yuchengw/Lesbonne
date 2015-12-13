package com.lesbonne.api.rest;

import com.lesbonne.api.config.ApiConstants;

public class Rest implements RestConstants, ApiConstants{

	public static String getPlatformBaseURL(boolean useSecure) {
		//TODO: we should use property files to specify this.
		return useSecure ? "localhost:8081" : "https://localhost:8081";
	}

}
