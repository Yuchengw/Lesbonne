package com.lesbonne.sharingpost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Rest controller implementation for SharingPost
 * @author jassica
 * @version 1
 */
@Controller
public class SharingPostRestControllerImpl implements SharingPostRestController {
	private static final Logger logger = LoggerFactory
			.getLogger(SharingPostRestControllerImpl.class);

	@Autowired
	private SharingPostService sharingPostService;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = SharingPostRestURIConstants.GET_SHARINGPOST_BY_ID, produces = "application/json")
	public @ResponseBody ResponseEntity<SharingPost> getSharingPostById(
			@PathVariable String sharingPostId) {
		SharingPost post = null;
		try {
			post = sharingPostService.getSharingPostById(sharingPostId);
		} catch (Exception e) {
			return new ResponseEntity<SharingPost>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SharingPost>(post, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, value = SharingPostRestURIConstants.UPDATE_SHARINGPOST, produces = "application/json")
	public @ResponseBody ResponseEntity<SharingPost> updateSharingPost(@RequestBody SharingPost sharingPost) {
		SharingPost updatedSharingPost = null;
		try {
			// TODO: Add validation on the basic required field
			if (sharingPost == null) {
				return new ResponseEntity<SharingPost>(HttpStatus.BAD_REQUEST);
			}
			updatedSharingPost = sharingPostService.updateSharingPost(sharingPost);
		} catch (Exception e) {
			return new ResponseEntity<SharingPost>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SharingPost>(updatedSharingPost, HttpStatus.OK);	
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value=SharingPostRestURIConstants.CREATE_SHARINGPOST, produces = "application/json")
	public @ResponseBody ResponseEntity<SharingPost> addSharingPost(@RequestBody SharingPost sharingPost) {
		SharingPost result = null;
		try {
			// TODO: Add required field validation
			if (sharingPost == null) {
				return new ResponseEntity<SharingPost>(HttpStatus.BAD_REQUEST);
			}
			result = sharingPostService.persistSharingPost(sharingPost);
		} catch (Exception e) {
			return new ResponseEntity<SharingPost>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SharingPost>(result, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value=SharingPostRestURIConstants.DELETE_SHARINGPOST)
	public ResponseEntity<Boolean> deleteSharingPost(@RequestBody SharingPost sharingPost) {
		try {
			sharingPostService.deleteSharingPost(sharingPost);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
