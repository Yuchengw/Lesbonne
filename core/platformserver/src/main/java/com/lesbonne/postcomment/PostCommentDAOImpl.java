package com.lesbonne.postcomment;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * */
@Repository("PostCommentDAO")
public class PostCommentDAOImpl implements PostCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistPostComment(PostComment postComment) {
		sessionFactory.getCurrentSession().persist(postComment);
	}

	@Override
	public void deletePostComment(PostComment postComment) {
		sessionFactory.getCurrentSession().delete(postComment);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PostComment> getPostCommentById(String postCommentId) {
		return (List<PostComment>) sessionFactory.getCurrentSession().get(PostComment.class, postCommentId);
	}

	@Override
	public PostComment updatePostComment(PostComment postComment) {
		sessionFactory.getCurrentSession().update(postComment);
		return postComment;
	}

}
