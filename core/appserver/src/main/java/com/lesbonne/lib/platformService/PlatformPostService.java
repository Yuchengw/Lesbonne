package com.lesbonne.lib.platformService;

import java.util.List;

import com.lesbonne.api.rest.AppRestPostClientImpl;
import com.lesbonne.api.rest.AppRestUserClientImpl;
import com.lesbonne.business.bean.Post;
import com.lesbonne.business.bean.User;

/**
 * This is the service layer concatenate platform PostEntityObject with appserver PostEntityProvider
 * 
 * @author yucheng
 * @version 1
 * */
public abstract class PlatformPostService implements PlatformService{

	public AppRestPostClientImpl getPostRestClient() {
		return new AppRestPostClientImpl(Post.class);
	}	
	
	public AppRestUserClientImpl getUserRestClient() {
		return new AppRestUserClientImpl(User.class);
	}
}
