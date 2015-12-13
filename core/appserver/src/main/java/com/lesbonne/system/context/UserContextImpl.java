package com.lesbonne.system.context;

import com.lesbonne.business.bean.User;
import com.lesbonne.exception.ContextErrorCode;
import com.lesbonne.exception.UserErrorCode;
import com.lesbonne.exception.LesbonneRuntimeException;

/**
 * @author yucheng
 * @since 1
 * */
public class UserContextImpl implements UserContextIntf{

	private final User user;
	
	public UserContextImpl() {
		try {
			this.user = User.getInstance();
		} catch (Exception e) {
			throw new LesbonneRuntimeException("User Context can not be established", e, ContextErrorCode.CONTEXT_CANNOT_ESTABLISHED);
		}
	}
	
	@Override
	final public String getUserId() {
		return getUserId(false);
	}

	@Override
	final public String getUserId(boolean nullOk) {
		return getUserId(false, false);
	}

	@Override
	final public String getUserId(boolean nullOk, boolean notAuthenticatedOk) {
		if (!notAuthenticatedOk) {
			throw new LesbonneRuntimeException("User is not authenticated.", UserErrorCode.USER_NOT_AUTHENTICATED);
		} else if (this.user == null && !nullOk) {
			throw new LesbonneRuntimeException("User not exist.", UserErrorCode.USER_NOT_EXISTS);
		} else {
			return this.user.getId();
		}
	}

	@Override
	final public User getUser() {
		return getUser(false);
	}

	@Override
	final public User getUser(boolean nullOk) {
		return getUser(false, false);
	}

	@Override
	final public User getUser(boolean nullOk, boolean notAuthenticatedOk) {
		if (!notAuthenticatedOk) {
			throw new LesbonneRuntimeException("User is not authenticated.", UserErrorCode.USER_NOT_AUTHENTICATED);
		} else if (this.user == null && !nullOk) {
			throw new LesbonneRuntimeException("User not exist.", UserErrorCode.USER_NOT_EXISTS);
		} else {
			return this.user;
		}
	}
}
