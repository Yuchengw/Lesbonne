package com.lesbonne.postcomment;

import java.util.List;

import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * */
public interface PostCommentDAO {
	
	void persistPostComment(PostComment postComment);
	
	void deletePostComment(PostComment postComment);
	
	List<PostComment> getPostCommentById(String postCommentId);
	
	PostComment updatePostComment(PostComment postComment);
}
