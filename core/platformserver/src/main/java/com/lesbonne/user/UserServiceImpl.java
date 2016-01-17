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
	}
	
	@Override
	@Transactional
	public User getUserByEmail(String userEmail){
		return userDAO.getUserByEmail(userEmail);
	}
	
	@Override
	@Transactional
	public User updateUser(User user){
		return userDAO.updateUser(user);
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
