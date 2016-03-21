package com.lesbonnes.service.s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

/**
 * @author yucheng
 * @since 
 * This is the actual S3 Service implementer of S3Service Client
 * */
public class S3ServiceClientImpl extends S3ServiceClient {
	
	private static final String S3_ACCESS_KEY_ID = "AKIAJYAM4VYTAD35PQIQ";
	private static final String S3_ACCESS_KEY = "pJdP06yX+uH+1bDh6Nd/AWBDs8ndftDsQx51V+Em";
	
	AmazonS3 getClient() {
		return AmazonS3InstanceProvider.AmazonS3Instance;
	}
	
	protected static class AmazonS3InstanceProvider {
		private static AWSCredentials s3credentials = new BasicAWSCredentials(S3_ACCESS_KEY_ID , S3_ACCESS_KEY);
		private static AmazonS3 AmazonS3Instance  = new AmazonS3Client(s3credentials);
	}
	
	AmazonS3 getBucket(String bucketName) {
		return (AmazonS3) getClient().getBucketAcl(bucketName);
	}
	
	AmazonS3 createBucket(String bucketName) {
		return (AmazonS3) getClient().createBucket(bucketName);
	}
}
