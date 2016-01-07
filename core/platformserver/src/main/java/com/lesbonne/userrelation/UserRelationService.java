package com.lesbonne.userrelation;

import org.springframework.stereotype.Service;

/**
 * @author yucheng
 * @since 1
 * */
@Service
public interface UserRelationService {
	
	void persistUserRelation(UserRelation user);
	
	UserRelation getUserRelationByUserId(String userId);
	
	UserRelation updateUserRelation(UserRelation userRelation);
	
	void deleteUserRelation(UserRelation userRelation);
}
