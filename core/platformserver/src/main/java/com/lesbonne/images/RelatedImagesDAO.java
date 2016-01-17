package com.lesbonne.images;

import java.util.List;

/**
 * 
 * @author jassica
 *
 */
public interface RelatedImagesDAO {
	void persistRelatedImages(RelatedImages image);

	void deleteRelatedImages(RelatedImages image);

	RelatedImages getRelatedImagesById(Integer id);
	
	RelatedImages updateRelatedImages(RelatedImages image);
	
	List<RelatedImages> list();
}
