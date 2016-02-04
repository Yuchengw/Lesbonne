package com.lesbonne.sharingpost;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lesbonne.postcomment.PostComment;
import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * */
@Repository("sharingPostDAO")
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
		Session session = sessionFactory.getCurrentSession();
		SharingPost toBeRemoved = (SharingPost) session.get(SharingPost.class, sharingPost.getSharingPostId());
        for (PostComment comment : toBeRemoved.getPostComments()) {
            comment.setSharingPost(null);
        }
        session.delete(toBeRemoved);
	}
}
