package com.lesbonne.postcomment;

/**
 * @author yucheng
 * @since 1
 * */
public interface PostCommentService {
	
	void persistPostCommentService(PostComment postComment);
	
	PostComment getPostCommentById(String postCommentId);
	
	PostComment updatePostComment(PostComment postComment);
	
	void deletePostComment(PostComment postComment);
}
