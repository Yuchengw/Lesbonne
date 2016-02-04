package com.lesbonne.postcomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yucheng
 * @since 1
 * */
@Service("PostCommentService")
public class PostCommentServiceImpl implements PostCommentService {

	@Autowired
	PostCommentDAO postCommentDAO;
	
	@Override
	@Transactional
	public PostComment persistPostComment(PostComment postComment) {
		postCommentDAO.persistPostComment(postComment);
		return postComment;
	}

	@Override
	@Transactional
	public PostComment getPostCommentById(String postCommentId) {
		return (PostComment) postCommentDAO.getPostCommentById(postCommentId);
	}

	@Override
	@Transactional
	public PostComment updatePostComment(PostComment postComment) {
		return postCommentDAO.updatePostComment(postComment);
	}

	@Override
	@Transactional
	public void deletePostComment(PostComment postComment) {
		postCommentDAO.deletePostComment(postComment);
	}
}
