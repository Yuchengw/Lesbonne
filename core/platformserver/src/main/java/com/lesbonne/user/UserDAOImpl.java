package com.lesbonne.user;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.postcomment.PostComment;
import com.lesbonne.promotion.PromotionCode;
import com.lesbonne.promotionusage.PromotionUsage;
import com.lesbonne.sharingpost.SharingPost;

/**
 * @author yucheng
 * @since 1
 * */
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User persistUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
		return user;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public User getUserByEmail(String email) {
		List users = (List) sessionFactory.getCurrentSession().
				createQuery("FROM User WHERE userEmail =:userEmail").
				setString("userEmail", email).list();
		
		if (users.size() == 0) {
			throw new RuntimeException("There is no user with this email address.");
		}
		if (users.size() > 1) {
			throw new RuntimeException("There are multiple users with this email address.");
		}
		return (User)users.get(0);
	}

	@Override
	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return user;
	}

	@Override
	public void deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		User toBeRemoved = (User) session.get(User.class, user.getUserId());
		for (SharingPost post : toBeRemoved.getSharingPosts()) {
			post.setOwner(null);
		}
		for (AskingPost post : toBeRemoved.getAskingPosts()) {
            post.setOwner(null);
        }
		for (PostComment comment : toBeRemoved.getPostComments()) {
		    comment.setOwner(null);
        }
		for (PromotionCode code : toBeRemoved.getPromotionCodes()) {
            code.setOwner(null);
        }
		for (PromotionUsage usage : toBeRemoved.getPromotionUsages()) {
		    usage.setUsedBy(null);
        }
		session.delete(toBeRemoved);
	}

	@Override
	public Boolean existsUserByEmail(String email) {
		List users = (List) sessionFactory.getCurrentSession().
				createQuery("FROM User WHERE userEMAIL =:userEmail").
				setString("userEmail", email).list();
		return users.size() > 0;
	}

	@Override
	public User getUserById(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}
}
