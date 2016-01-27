package com.lesbonne.sharingpost;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface for the SharingPost Rest Service
 * @author jassica
 * @version 1
 *
 */
public interface SharingPostRestController {
	public ResponseEntity<SharingPost> getSharingPostById(@PathVariable String sharingPostId);

	public ResponseEntity<SharingPost> updateSharingPost(@RequestBody final SharingPost sharingPost);

	public ResponseEntity<SharingPost> addSharingPost(@RequestBody SharingPost sharingPost);

	public ResponseEntity<Boolean> deleteSharingPost(@PathVariable SharingPost sharingPost);
}
