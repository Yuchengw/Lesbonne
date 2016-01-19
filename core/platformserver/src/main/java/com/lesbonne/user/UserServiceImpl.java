package com.lesbonne.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author yucheng
 * @since 1
 * */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	@Transactional
	public User persistUser(User user){
		return userDAO.persistUser(user);
		
		//TODO - move this to async job
//		UserIndexer indexer = new UserIndexer("user", user);
//		IndexResponse response = indexer.create();
//		
//		System.out.println("CREATE");
//		System.out.println(response);
	}
	
	@Override
	@Transactional
	public User getUserByEmail(String userEmail){
		return userDAO.getUserByEmail(userEmail);
	}
	
	@Override
	@Transactional
	public User updateUser(User user){
		User newUser = userDAO.updateUser(user);
		
		//TODO - move this to async job
//		UserIndexer indexer = new UserIndexer("user", user);
//		UpdateResponse response = indexer.update();
//		
//		System.out.println("UPDATE");
//		System.out.println(response);
		
		return newUser;
	}
	
	@Override
	@Transactional
	public void deleteUser(User user){
		userDAO.deleteUser(user);
	}

	@Override
	public Boolean existsUserByEmail(String userEmail) {
		return userDAO.existsUserByEmail(userEmail);
	}

	@Override
	public User getUserById(String userId) {
		return userDAO.getUserById(userId);
	}
}
