package com.lesbonne.bean.rest.controller;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lesbonne.business.bean.Post;
import com.lesbonne.business.bean.User;
import com.lesbonne.lib.objectProvider.UserProvider;

/**
 * @author yucheng
 * @since 1
 * */
@Controller
public class ProfileControllerImpl implements ProfileController {
	
	private UserProvider userProvider;
	
	public void setUserProvider(UserProvider userProvider) {
		this.userProvider = userProvider;
	}
	
	@RequestMapping(method=RequestMethod.GET, value=ProfileRestURIConstants.GET_PROFILE)
	public @ResponseBody User getProfile(@RequestHeader("Cookie") String credentials) {
		return null;
	}

	@RequestMapping(method=RequestMethod.POST, value=ProfileRestURIConstants.UPDATE_PROFILE)
	public User updateProfile(String userInfo, String updateInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
