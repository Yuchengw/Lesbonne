package com.lesbonne.images;

import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

/**
 * The helper method to help save the image to the remote server
 * @author jassica
 *
 */
public class RelatedImagesRemoteSaver {
	private final String FILE_DIVIDER = "/";

	/**
	 * The file location will be something like images/[year]/[month]/[date]/[hour]/[minute]/filename
	 * The reason for the format should be found under spike document
	 * @param fileName
	 * @return
	 */
	public String createdNewRemotePath(String fileName) {
		Calendar cal = Calendar.getInstance();
		StringBuilder imageRemoteLocation = new StringBuilder("images"
				+ FILE_DIVIDER);
		imageRemoteLocation.append(cal.get(Calendar.YEAR)).append(FILE_DIVIDER);
		imageRemoteLocation.append(cal.get(Calendar.MONTH) + 1).append(
				FILE_DIVIDER);
		imageRemoteLocation.append(cal.get(Calendar.DATE)).append(FILE_DIVIDER);
		imageRemoteLocation.append(cal.get(Calendar.HOUR_OF_DAY)).append(
				FILE_DIVIDER);
		imageRemoteLocation.append(cal.get(Calendar.MINUTE)).append(
				FILE_DIVIDER);
		imageRemoteLocation.append(fileName);
		return imageRemoteLocation.toString();
	}

	public void saveToRemoteServer(String path, MultipartFile file) {

	}
}
