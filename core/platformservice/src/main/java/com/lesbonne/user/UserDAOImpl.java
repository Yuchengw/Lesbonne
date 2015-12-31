package com.lesbonne.user;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author yucheng
 * @since 1
 * */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	@Override
	public User getUserByEmail(String userEmail) {
		return (User)sessionFactory.getCurrentSession().
				get(User.class, userEmail);
	}
	
	@Override
	public User getUserById(String userId) {
		return (User)sessionFactory.getCurrentSession().
				get(User.class, userId);
	}

	@Override
	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return user;
	}

	@Override
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
}
