package com.lesbonne.postcomment;

/**
 * @author yucheng
 * @since 1
 * */
public interface PostCommentService {
	
    PostComment persistPostComment(PostComment postComment);
	
	PostComment getPostCommentById(String postCommentId);
	
	PostComment updatePostComment(PostComment postComment);
	
	void deletePostComment(PostComment postComment);
}
