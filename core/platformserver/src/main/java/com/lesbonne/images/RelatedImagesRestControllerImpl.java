package com.lesbonne.images;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

/**
 * 
 * @author jassica
 * @since 1
 */
@Controller
public class RelatedImagesRestControllerImpl implements
		RelatedImagesRestController {

	private static final Logger logger = LoggerFactory
			.getLogger(RelatedImagesRestControllerImpl.class);

	@Autowired
	private RelatedImagesService relatedImagesService;

	@Override
	@RequestMapping(value = RelatedImagesRestURIConstants.CREATE_IMAGE, headers = ("content-type=multipart/*"), method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RelatedImages> save(// @ModelAttribute("document")
												// RelatedImages document,
			@RequestParam("file") MultipartFile file) {
		// Blob blob = Hibernate.createBlob(file.getInputStream());
		// TODO: Save the file to the remote with Path information
		RelatedImagesRemoteSaver remoteSaver = new RelatedImagesRemoteSaver();
		String remoteFileLocation = remoteSaver.createdNewRemotePath(file
				.getOriginalFilename());
		remoteSaver.saveToRemoteServer(remoteFileLocation, file);
		RelatedImages document = new RelatedImages();
		document.setName(file.getName());
		document.setContent(remoteFileLocation);
		document.setContentType(file.getContentType());
		try {
			relatedImagesService.persistRelatedImages(document);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<RelatedImages>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<RelatedImages>(document, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = RelatedImagesRestURIConstants.GET_IMAGE_BY_ID)
	public ResponseEntity<RelatedImages> getRelatedImagesById(String imageId) {
		RelatedImages image = null;
		Integer idValue = new Integer(imageId);
		try {
			image = relatedImagesService.getRelatedImagesById(idValue);
		} catch (Exception e) {
			return new ResponseEntity<RelatedImages>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RelatedImages>(image, HttpStatus.OK);
	}

}
