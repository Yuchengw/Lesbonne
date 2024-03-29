package com.lesbonne.web.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 * @author yucheng
 * @since 1
 * */
class LesbonneAuthenticationFilter extends GenericFilterBean {

	private final TokenAuthenticationService tokenAuthenticationService;

	protected LesbonneAuthenticationFilter(TokenAuthenticationService taService) {
		this.tokenAuthenticationService = taService;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
//		Authentication userContext = tokenAuthenticationService.getAuthentication((HttpServletRequest)req);
//		if (userContext != null && userContext.isAuthenticated()) {
//			SecurityContextHolder.getContext().setAuthentication(userContext);
//		} 
		chain.doFilter(req, res); // always continue
	}
}