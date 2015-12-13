package com.lesbonne.userrelation;

/**
 * @author yucheng
 * @since 1
 * */
public interface UserRelationDAO {
	
	void persistUserRelation(UserRelation userRelation);
	
	void deleteUserRelation(UserRelation userRelation);
	
	UserRelation getUserRelationByUserId(String userId);
	
	UserRelation updateUserRelation(UserRelation userRelation);
}
