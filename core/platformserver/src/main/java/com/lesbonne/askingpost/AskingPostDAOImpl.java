package com.lesbonne.askingpost;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author yucheng
 * @since 1
 * */
@Repository("AskingPostDAO")
public class AskingPostDAOImpl implements AskingPostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistAskingPost(AskingPost askingPost) {
		sessionFactory.getCurrentSession().persist(askingPost);
	}
	
	@Override
	public AskingPost getAskingPostById(String askingPostId) {
		return (AskingPost) sessionFactory.getCurrentSession().get(AskingPost.class, askingPostId);
	}

	@Override
	public AskingPost updateAskingPost(AskingPost askingPost) {
		sessionFactory.getCurrentSession().update(askingPost);
		return askingPost;
	}
	
	@Override
	public void deleteAskingPost(AskingPost askingPost) {
		sessionFactory.getCurrentSession().delete(askingPost);
	}
}
