package com.lesbonne.askingpost;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface for the AskingPost Rest Service
 * @author jassica
 * @version 1
 *
 */
public interface AskingPostRestController {
	public ResponseEntity<AskingPost> getAskingPostById(@PathVariable String askingPostId);

	public ResponseEntity<AskingPost> updateAskingPost(@RequestBody final AskingPost askingPost);

	public ResponseEntity<AskingPost> addAskingPost(@RequestBody AskingPost askingPost);

	public ResponseEntity<Boolean> deleteAskingPost(@PathVariable AskingPost askingPost);
}
