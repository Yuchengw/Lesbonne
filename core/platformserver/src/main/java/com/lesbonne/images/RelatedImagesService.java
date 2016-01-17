package com.lesbonne.images;

/**
 * 
 * @author jassica
 *
 */
public interface RelatedImagesService {
	void persistRelatedImages(RelatedImages image);

	void deleteRelatedImages(RelatedImages image);

	RelatedImages getRelatedImagesById(Integer id);
	
	RelatedImages updateRelatedImages(RelatedImages image);
}
