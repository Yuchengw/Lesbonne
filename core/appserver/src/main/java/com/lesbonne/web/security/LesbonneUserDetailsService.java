package com.lesbonne.web.security;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lesbonne.business.bean.User;
import com.lesbonne.lib.objectProvider.UserProvider;

/**
 * @author yucheng
 * @since 1
 * */
@Service
public class LesbonneUserDetailsService implements UserDetailsService {

	private UserProvider userProvider;
	
	public void setUserProvider(UserProvider userProvider) {
		this.userProvider = userProvider;
	}
	
	private final LesbonneUserDetailsChecker detailsChecker = new LesbonneUserDetailsChecker();

	@Override
	public final User loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		final User user = userProvider.get(userEmail);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		try {
			detailsChecker.check(user);
		} catch (Exception e) {
			throw e;
		}
		
		return user;
	}
}
