package com.lesbonne.api.util;

import com.lesbonne.business.bean.User;
import com.lesbonne.web.security.TokenHandler;

/**
 * @author yucheng
 * @since 1
 * */
public class UserApiUtil {

	public static String getXSRFTokenForUser(User user) {
		TokenHandler tokenHandler = new TokenHandler();
		return tokenHandler.createTokenForUser(user);
	}
}
