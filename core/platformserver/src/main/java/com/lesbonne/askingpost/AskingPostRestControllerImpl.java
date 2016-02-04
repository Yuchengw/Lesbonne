package com.lesbonne.askingpost;

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
 * Rest controller implementation for AskingPost
 * @author jassica
 * @version 1
 */
@Controller
public class AskingPostRestControllerImpl implements AskingPostRestController {
	private static final Logger logger = LoggerFactory
			.getLogger(AskingPostRestControllerImpl.class);

	@Autowired
	private AskingPostService askingPostService;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = AskingPostRestURIConstants.GET_ASKINGPOST_BY_ID, produces = "application/json")
	public @ResponseBody ResponseEntity<AskingPost> getAskingPostById(
			@PathVariable String askingPostId) {
	    AskingPost post = null;
		try {
			post = askingPostService.getAskingPostById(askingPostId);
		} catch (Exception e) {
			return new ResponseEntity<AskingPost>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<AskingPost>(post, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, value = AskingPostRestURIConstants.UPDATE_ASKINGPOST, produces = "application/json")
	public @ResponseBody ResponseEntity<AskingPost> updateAskingPost(@RequestBody AskingPost askingPost) {
	    AskingPost updatedAskingPost = null;
		try {
			// TODO: Add validation on the basic required field
			if (askingPost == null) {
				return new ResponseEntity<AskingPost>(HttpStatus.BAD_REQUEST);
			}
			updatedAskingPost = askingPostService.updateAskingPost(askingPost);
		} catch (Exception e) {
			return new ResponseEntity<AskingPost>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<AskingPost>(updatedAskingPost, HttpStatus.OK);	
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value=AskingPostRestURIConstants.CREATE_ASKINGPOST, produces = "application/json")
	public @ResponseBody ResponseEntity<AskingPost> addAskingPost(@RequestBody AskingPost askingPost) {
	    AskingPost result = null;
		try {
			// TODO: Add required field validation
			if (askingPost == null) {
				return new ResponseEntity<AskingPost>(HttpStatus.BAD_REQUEST);
			}
			result = askingPostService.persistAskingPost(askingPost);
		} catch (Exception e) {
			return new ResponseEntity<AskingPost>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<AskingPost>(result, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value=AskingPostRestURIConstants.DELETE_ASKINGPOST)
	public ResponseEntity<Boolean> deleteAskingPost(@RequestBody AskingPost askingPost) {
		try {
			askingPostService.deleteAskingPost(askingPost);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
