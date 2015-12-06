package com.yummet.exception;

public enum PostCommentErrorCode implements ErrorCode {
	PostCommentErrorCode(30001);

	private final int number;
	
	PostCommentErrorCode(int number) {
		this.number = number;
	}
	
	@Override
	public int getNumber() {
		return this.number;
	}

}
