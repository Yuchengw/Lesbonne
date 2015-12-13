package com.lesbonne.postcomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yucheng
 * @since 1
 * */
@Service("PostCommentService")
public class PostCommentServiceImpl implements PostCommentService {

	@Autowired
	PostCommentDAO postCommentDAO;
	
	@Override
	public void persistPostCommentService(PostComment postComment) {
		postCommentDAO.persistPostComment(postComment);
	}

	@Override
	public PostComment getPostCommentById(String postCommentId) {
		return (PostComment) postCommentDAO.getPostCommentById(postCommentId);
	}

	@Override
	public PostComment updatePostComment(PostComment postComment) {
		return postCommentDAO.updatePostComment(postComment);
	}

	@Override
	public void deletePostComment(PostComment postComment) {
		postCommentDAO.deletePostComment(postComment);
	}
}
