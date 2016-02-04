package com.lesbonne.postcomment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface for the PostComment Rest Service
 * @author jassica
 * @version 1
 *
 */
public interface PostCommentRestController {
	public ResponseEntity<PostComment> getPostCommentById(@PathVariable String postCommenttId);

	public ResponseEntity<PostComment> updatePostComment(@RequestBody final PostComment postComment);

	public ResponseEntity<PostComment> addPostComment(@RequestBody PostComment postComment);

	public ResponseEntity<Boolean> deletePostComment(@PathVariable PostComment postComment);
}
