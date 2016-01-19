package com.lesbonne.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author jassica
 *
 */
@Service
public class RelatedImagesServiceImpl implements RelatedImagesService {

	@Autowired
	RelatedImagesDAO relatedImagesDAO;
	
	@Override
	@Transactional
	public void persistRelatedImages(RelatedImages image) {
		relatedImagesDAO.persistRelatedImages(image);
	}

	@Override
	@Transactional
	public void deleteRelatedImages(RelatedImages image) {
		relatedImagesDAO.deleteRelatedImages(image);	
	}

	@Override
	@Transactional
	public RelatedImages getRelatedImagesById(Integer id) {
		return relatedImagesDAO.getRelatedImagesById(id);
	}

	@Override
	@Transactional
	public RelatedImages updateRelatedImages(RelatedImages image) {
		return relatedImagesDAO.updateRelatedImages(image);
	}

}
