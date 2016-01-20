package com.lesbonne.images;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author jassica
 *
 */
public interface RelatedImagesRestController {
	public ResponseEntity<RelatedImages> getRelatedImagesById(@PathVariable String id);
	public ResponseEntity<RelatedImages> save(
//            @ModelAttribute("document") RelatedImages document,
			@RequestParam("file") MultipartFile file);
}
