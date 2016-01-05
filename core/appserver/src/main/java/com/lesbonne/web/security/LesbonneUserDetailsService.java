package com.lesbonne.web.security;

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
		
	private final LesbonneUserDetailsChecker detailsChecker = new LesbonneUserDetailsChecker();

	@Override
	public final User loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		final User user = new UserProvider().getUserByEmail(userEmail);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		try {
			detailsChecker.check(user);
		} catch (Exception e) {
			throw new RuntimeException("user is not authenticated." + e);
		}
		return user;
	}
}
