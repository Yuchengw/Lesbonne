package com.yummet.exception;

/**
 * @author yucheng
 * @since 1
 * */
public enum UserErrorCode implements ErrorCode{
	USER_NOT_EXISTS(10001),
	USER_NOT_AUTHENTICATED(10002);

	private final int number;

	UserErrorCode(int number) {
		this.number = number;
	}
	
	@Override
	public int getNumber() {
		return this.number;
	}

}
