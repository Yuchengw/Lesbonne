package com.lesbonne.bean.rest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesbonne.business.bean.Post;
import com.lesbonne.business.bean.PostList;
import com.lesbonne.business.bean.User;
import com.lesbonne.lib.objectProvider.PostProvider;
import com.lesbonne.lib.objectProvider.UserProvider;

/**
 * This class is used for Restful API User Control.
 * 
 * @author yucheng
 * @version 1
 * */
@Controller
public class PostControllerImpl implements PostController {

	private PostProvider postProvider;
	private UserProvider userProvider;
	
	public void setPostProvider(PostProvider postProvider) {
		this.postProvider = postProvider;
	}
	
	public void setUserProvider(UserProvider userProvider) {
		this.userProvider = userProvider;
	}
	
	@RequestMapping(method=RequestMethod.GET, value=PostRestURIConstants.GET_POST)
	public Post getPost(@PathVariable String id, @RequestBody String body) {
		return postProvider.get(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value=PostRestURIConstants.GET_POSTS)
	public PostList getPosts(@PathVariable final String id, @RequestParam(value="step") final String step,
			@RequestParam(value="cursor") final String cursor, String body) throws Exception {
		PostList postList = new PostList();
		User user = userProvider.getUserByEmail(id);
		Authentication userContext = SecurityContextHolder.getContext().getAuthentication();
		if (user == null) {
			throw new Exception("user object not find: " + userContext.getName());
		}
		List<Post> posts = postProvider.get(user.getUserEmail(), Integer.parseInt(step), Integer.parseInt(cursor));
		postList.setPosts(posts);
		return postList;
	}

	@RequestMapping(method=RequestMethod.PUT, value=PostRestURIConstants.UPDATE_POST)
	public Post updatePost(@PathVariable String id, @RequestBody String body) throws Exception {
		// Check if old post exists
		Post oldPost = postProvider.get(id);
		if(oldPost == null) {
			throw new Exception("Post does not exist: " + id);
		}
		Authentication userContext = SecurityContextHolder.getContext().getAuthentication();
		User user = userProvider.getUserByEmail(userContext.getName());
		if (user == null) {
			throw new Exception("user object not find: " + userContext.getName());
		}
		Post newPost = new ObjectMapper().readValue(body, Post.class);
		newPost.setId(id);
		Post updatedPost = postProvider.update(user, newPost);
		return updatedPost;
	}

	@RequestMapping(method=RequestMethod.POST, value=PostRestURIConstants.CREATE_POST)
	public Post addPost(@RequestBody String body) throws Exception {
		Authentication userContext = SecurityContextHolder.getContext().getAuthentication();
		User user = userProvider.getUserByEmail(userContext.getName());
		if (user == null) {
			throw new Exception("user object not find: " + userContext.getName());
		}
		Post newPost = null;
		try {
			newPost = new ObjectMapper().readValue(body, Post.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Post createdPost = postProvider.add(user, newPost);
		return createdPost;
	}

	@RequestMapping(method=RequestMethod.DELETE, value=PostRestURIConstants.DELETE_POST)
	public void removePost(@PathVariable String id, @RequestBody String body) {
		this.postProvider.remove(id);
	}
}
