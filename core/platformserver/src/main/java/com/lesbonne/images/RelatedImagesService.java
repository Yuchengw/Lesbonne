package com.lesbonne.images;

/**
 * 
 * @author jassica
 *
 */
public interface RelatedImagesService {
	void persistRelatedImages(RelatedImages image);

	void deleteRelatedImages(RelatedImages image);

	RelatedImages getRelatedImagesById(String id);
	
	RelatedImages updateRelatedImages(RelatedImages image);
}
