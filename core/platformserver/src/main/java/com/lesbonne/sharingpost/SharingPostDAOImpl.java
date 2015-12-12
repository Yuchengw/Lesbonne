package com.lesbonne.sharingpost;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author yucheng
 * @since 1
 * */
@Repository("SharingPostDAO")
public class SharingPostDAOImpl implements SharingPostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistSharingPost(SharingPost sharingPost) {
		sessionFactory.getCurrentSession().persist(sharingPost);
	}

	@Override
	public SharingPost getSharingPostById(String sharingPostId) {
		return (SharingPost) sessionFactory.getCurrentSession().get(SharingPost.class, sharingPostId);
	}

	@Override
	public SharingPost updateSharingPost(SharingPost sharingPost) {
		sessionFactory.getCurrentSession().update(sharingPost);
		return sharingPost;
	}
	
	@Override
	public void deleteSharingPost(SharingPost sharingPost) {
		sessionFactory.getCurrentSession().delete(sharingPost);
	}
}
