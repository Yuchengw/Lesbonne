package com.lesbonnes.service.s3;

import java.io.File;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressEventType;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;

/**
 * @author yucheng
 * @since 
 * This is the actual S3 Service implementer of S3Service Client
 * */
public class S3ServiceClientImpl extends S3ServiceClient {
	
	private static final String S3_ACCESS_KEY_ID = "AKIAJYAM4VYTAD35PQIQ";
	private static final String S3_ACCESS_KEY = "pJdP06yX+uH+1bDh6Nd/AWBDs8ndftDsQx51V+Em";
	
	TransferManager getClient() {
		return AmazonS3InstanceProvider.AmazonS3TranferManager;
	}
	
	protected static class AmazonS3InstanceProvider {
		private static AWSCredentials s3credentials = new BasicAWSCredentials(S3_ACCESS_KEY_ID , S3_ACCESS_KEY);
		private static TransferManager AmazonS3TranferManager  = new TransferManager(s3credentials);
	}
	
	public AmazonS3 getBucket(String bucketName) {
		try {
			return (AmazonS3) getClient().getAmazonS3Client().getBucketAcl(bucketName);
		} catch (AmazonClientException ex) {
			// TODO: Add logger 
			throw new RuntimeException(ex);
		}
	}
	
	public void createBucket(String bucketName) {
		AmazonS3Client client = (AmazonS3Client) getClient().getAmazonS3Client();
		try {
			if (client.doesBucketExist(bucketName) == false) {
				client.createBucket(bucketName);
			}
		} catch (AmazonClientException ex) {
			// TODO: add logger
			throw new RuntimeException(ex);
		}
	}
	
	public String uploadFile(String bucketName, String fileName, File fileToUpload) {
		return uploadFile(bucketName, S3FileCategory.DEFAULT, fileName, fileToUpload);
	}
	
	
	public String uploadFile(String bucketName, S3FileCategory category, String fileName, File fileToUpload) {
		return uploadFile(bucketName, S3FileLocation.DEFAULT, category, fileName, fileToUpload);
	}
	
	public String uploadFile(String bucketName, S3FileLocation location, S3FileCategory category, String fileName, File fileToUpload) {
		String fileUrl;
		Upload upload;
		try {
			String s3FileName = constructS3FileName(location, fileName, category);
			upload = getClient().upload(bucketName, s3FileName, fileToUpload);
			upload.addProgressListener(new ProgressListener() {
				@Override
				public void progressChanged(ProgressEvent progressEvent) {
					if (progressEvent.getEventType() == ProgressEventType.TRANSFER_COMPLETED_EVENT) {
						// TODO: add logger 
					}
				}
			});
			upload.waitForUploadResult();
			fileUrl = constructS3FileURL(bucketName, s3FileName);
		} catch (AmazonClientException ex) {
			// TODO: add logger
			throw new RuntimeException(ex);
		} catch (Exception e) {
			// TODO: add retry 
			throw new RuntimeException(e);
		}
		return fileUrl;
	}
	
	public File downloadFile(String bucketName, String fileName) {
		return downloadFile(bucketName, S3FileCategory.DEFAULT, fileName);
	}
	
	public File downloadFile(String bucketName, S3FileCategory category, String fileName) {
		return downloadFile(bucketName, S3FileLocation.DEFAULT, category, fileName);
	}
	
	public File downloadFile(String bucketName, S3FileLocation location, S3FileCategory category, String fileName) {
		try {
			File downloadFile = new File(constructS3FileName(location, fileName, category));
			GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, (String) category.getObjectKey());
			Download download = getClient().download(getObjectRequest, downloadFile);
			download.addProgressListener(new ProgressListener() {
				@Override
				public void progressChanged(ProgressEvent progressEvent) {
					if (progressEvent.getEventType() == ProgressEventType.TRANSFER_COMPLETED_EVENT) {
						// TODO: add logger
					}
				}
			});
			return downloadFile;
		} catch (AmazonClientException ex) {
			// TODO: add logger
			throw new RuntimeException(ex);
		} catch (Exception e) {
			// TODO: add retry
			throw new RuntimeException(e);
		} 
	}
	
	private String constructS3FileName(S3FileLocation location, String fileName, S3FileCategory category) {
		StringBuilder builder = new StringBuilder();
		builder.append("Lesbonnes_");
		builder.append(location);
		builder.append("_");
		builder.append(category);
		builder.append("_");
		builder.append(fileName);
		return builder.toString();
	}
	
	private String constructS3FileURL(String bucketName, String fileName) {
		StringBuilder builder = new StringBuilder();
		builder.append(S3ServiceConstant.S3HOST);
		builder.append(bucketName);
		builder.append("/");
		builder.append(fileName);
		return builder.toString();
	}
}
