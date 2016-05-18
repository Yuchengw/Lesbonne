package com.lesbonnes.service.s3;

public enum S3FileLocation {
	DEFAULT("");
	
	private final String location;
	
	private S3FileLocation(String location) {
		this.location = location;
	}
	
	public String getS3FileLocation() {
		return this.location;
	}
}
