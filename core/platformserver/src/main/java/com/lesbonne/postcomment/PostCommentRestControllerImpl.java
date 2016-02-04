package com.lesbonne.postcomment;

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
 * Rest controller implementation for PostComment
 * 
 * @author jassica
 * @version 1
 */
@Controller
public class PostCommentRestControllerImpl implements PostCommentRestController {
    private static final Logger logger = LoggerFactory
            .getLogger(PostCommentRestControllerImpl.class);
    
    @Autowired
    private PostCommentService postCommentService;
    
    @Override
    @RequestMapping(
            method = RequestMethod.GET,
            value = PostCommentRestURIConstants.GET_POSTCOMMENT_BY_ID,
            produces = "application/json")
    public @ResponseBody ResponseEntity<PostComment> getPostCommentById(
            @PathVariable String postCommentId) {
        PostComment comment = null;
        try {
            comment = postCommentService.getPostCommentById(postCommentId);
        } catch (Exception e) {
            return new ResponseEntity<PostComment>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<PostComment>(comment, HttpStatus.OK);
    }
    
    @Override
    @RequestMapping(
            method = RequestMethod.PUT,
            value = PostCommentRestURIConstants.UPDATE_POSTCOMMENT,
            produces = "application/json")
    public @ResponseBody ResponseEntity<PostComment> updatePostComment(
            @RequestBody PostComment postComment) {
        PostComment updatedPostComment = null;
        try {
            // TODO: Add validation on the basic required field
            if (postComment == null) {
                return new ResponseEntity<PostComment>(HttpStatus.BAD_REQUEST);
            }
            updatedPostComment = postCommentService
                    .updatePostComment(updatedPostComment);
        } catch (Exception e) {
            return new ResponseEntity<PostComment>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<PostComment>(updatedPostComment,
                HttpStatus.OK);
    }
    
    @Override
    @RequestMapping(
            method = RequestMethod.POST,
            value = PostCommentRestURIConstants.CREATE_POSTCOMMENT,
            produces = "application/json")
    public @ResponseBody ResponseEntity<PostComment> addPostComment(
            @RequestBody PostComment postComment) {
        PostComment result = null;
        try {
            // TODO: Add required field validation
            if (postComment == null) {
                return new ResponseEntity<PostComment>(HttpStatus.BAD_REQUEST);
            }
            result = postCommentService.persistPostComment(postComment);
        } catch (Exception e) {
            return new ResponseEntity<PostComment>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<PostComment>(result, HttpStatus.OK);
    }
    
    @Override
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = PostCommentRestURIConstants.DELETE_POSTCOMMENT)
    public ResponseEntity<Boolean> deletePostComment(
            @RequestBody PostComment postComment) {
        try {
            postCommentService.deletePostComment(postComment);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
