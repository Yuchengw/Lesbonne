package com.lesbonne.lib.platformService;

import org.springframework.context.annotation.Profile;

import com.lesbonne.api.rest.AppRestUserClientImpl;
import com.lesbonne.api.rest.RestClient;
import com.lesbonne.business.bean.Order;
import com.lesbonne.business.bean.Post;
import com.lesbonne.business.bean.PostComment;
import com.lesbonne.business.bean.User;

/**
 * This is the service layer concatenate platform UserEntityObject with appserver UserEntityProvider
 * 
 * Use Strategy pattern to decouple different ways of communicating with Platform code
 * 
 * @author yucheng
 * @since 1
 * */
public abstract class PlatformUserService implements PlatformService {
	
	public AppRestUserClientImpl getUserRestClient() {
		return new AppRestUserClientImpl(User.class);
	}
}
