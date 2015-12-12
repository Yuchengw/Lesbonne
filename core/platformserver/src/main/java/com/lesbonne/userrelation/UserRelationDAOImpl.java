package com.lesbonne.userrelation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author yucheng
 * @since 1
 * */
@Repository("UserRelationDAO")
public class UserRelationDAOImpl implements UserRelationDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistUserRelation(UserRelation userRelation) {
		sessionFactory.getCurrentSession().persist(userRelation);
	}

	@Override
	public void deleteUserRelation(UserRelation userRelation) {
		sessionFactory.getCurrentSession().delete(userRelation);
	}

	@Override
	public UserRelation getUserRelationByUserId(String userId1) {
		return (UserRelation) sessionFactory.getCurrentSession().get(UserRelation.class, userId1);
	}

	@Override
	public UserRelation updateUserRelation(UserRelation userRelation) {
		sessionFactory.getCurrentSession().update(userRelation);
		return userRelation;
	}
}
