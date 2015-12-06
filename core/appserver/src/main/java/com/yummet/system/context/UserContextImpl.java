package com.yummet.system.context;

import com.yummet.business.bean.User;
import com.yummet.exception.ContextErrorCode;
import com.yummet.exception.UserErrorCode;
import com.yummet.exception.YummetRuntimeException;

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
			throw new YummetRuntimeException("User Context can not be established", e, ContextErrorCode.CONTEXT_CANNOT_ESTABLISHED);
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
			throw new YummetRuntimeException("User is not authenticated.", UserErrorCode.USER_NOT_AUTHENTICATED);
		} else if (this.user == null && !nullOk) {
			throw new YummetRuntimeException("User not exist.", UserErrorCode.USER_NOT_EXISTS);
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
			throw new YummetRuntimeException("User is not authenticated.", UserErrorCode.USER_NOT_AUTHENTICATED);
		} else if (this.user == null && !nullOk) {
			throw new YummetRuntimeException("User not exist.", UserErrorCode.USER_NOT_EXISTS);
		} else {
			return this.user;
		}
	}
}
