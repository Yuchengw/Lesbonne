package com.lesbonne.user;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author yucheng
 * @since 1
 * */
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return (User)sessionFactory.getCurrentSession().
				get(User.class, email);
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
