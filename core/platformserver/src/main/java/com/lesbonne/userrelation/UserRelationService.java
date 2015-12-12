package com.lesbonne.userrelation;

import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * */
public interface UserRelationService {
	
	void persistUserRelation(UserRelation user);
	
	UserRelation getUserRelationByUserId(String userId);
	
	UserRelation updateUserRelation(UserRelation userRelation);
	
	void deleteUserRelation(UserRelation userRelation);
}
