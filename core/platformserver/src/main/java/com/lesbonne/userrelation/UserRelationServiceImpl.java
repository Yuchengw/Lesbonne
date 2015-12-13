package com.lesbonne.userrelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yucheng
 * @since 1
 * */
@Service("UserRelationService")
public class UserRelationServiceImpl implements UserRelationService {

	@Autowired
	UserRelationDAO userRelationDAO;
	
	@Override
	public void persistUserRelation(UserRelation userRelation) {
		userRelationDAO.persistUserRelation(userRelation);
	}

	@Override
	public UserRelation getUserRelationByUserId(String userId) {
		return userRelationDAO.getUserRelationByUserId(userId);
	}

	@Override
	public UserRelation updateUserRelation(UserRelation userRelation) {
		return userRelationDAO.updateUserRelation(userRelation);
	}

	@Override
	public void deleteUserRelation(UserRelation userRelation) {
		userRelationDAO.deleteUserRelation(userRelation);
	}

}
