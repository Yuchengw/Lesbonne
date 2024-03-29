package com.lesbonne.bean.rest.controller;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;

import com.lesbonne.business.bean.PostComment;
import com.lesbonne.business.bean.PostCommentList;
import com.lesbonne.lib.objectProvider.PostCommentProvider;

/**
 * This class is used for Restful API User Control.
 * 
 * @author yucheng
 * @since 1
 * */
@Controller
public class PostCommentControllerImpl implements PostCommentController {

	private PostCommentProvider postCommentProvider;
	private Jaxb2Marshaller jaxb2Mashaller;
	
	public void setUserProvider(PostCommentProvider postCommentProvider) {
		this.postCommentProvider = postCommentProvider;
	}
	
	public void setJaxb2Mashaller(Jaxb2Marshaller jaxb2Mashaller) {
		this.jaxb2Mashaller = jaxb2Mashaller;
	}
	
	@Override
	public PostComment getPostComment(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostComment updatePostComment(String body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostComment addPostComment(String body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostCommentList removePostComment(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
