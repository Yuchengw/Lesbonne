package com.yummet.exception;

/**
 * @author yucheng
 * @since 1
 * */
public enum ContextErrorCode implements ErrorCode{
	
	CONTEXT_CANNOT_ESTABLISHED(50001);

	private final int number;

	ContextErrorCode(int number) {
		this.number = number;
	}
	
	@Override
	public int getNumber() {
		return this.number;
	}
}
