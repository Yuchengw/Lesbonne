package com.lesbonne.user;

import java.util.List;

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
	@SuppressWarnings("rawtypes")
	public User getUserByEmail(String email) {
		List users = (List) sessionFactory.getCurrentSession().
				createQuery("FROM User WHERE userEmail =:userEmail").
				setParameter("userEmail", email).list();
		// List users = (List) sessionFactory.getCurrentSession().
		// createSQLQuery("select * FROM LESBONNEUSER WHERE USEREMAIL =:userEmail").addEntity(User.class).
		// setParameter("userEmail", email).list();
		return users.size() == 1 ? (User)users.get(0) : null;
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

	@Override
	public Boolean existsUserByEmail(String email) {
		return getUserByEmail(email) != null;
	}

	@Override
	public User getUserById(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}
}
