package com.lesbonnes.service.s3;

public enum S3FileCategory {
	DEFAULT("");

	private final String category;
	
	private S3FileCategory(String category) {
		this.category = category;
	}
	
	public String getFileCategory() {
		return this.category;
	}
}	
