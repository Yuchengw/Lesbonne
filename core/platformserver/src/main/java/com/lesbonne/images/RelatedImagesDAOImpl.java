package com.lesbonne.images;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author jassica
 *
 */
@Repository("relatedImagesDAO")
public class RelatedImagesDAOImpl implements RelatedImagesDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistRelatedImages(RelatedImages image) {
		sessionFactory.getCurrentSession().persist(image);
	}

	@Override
	public void deleteRelatedImages(RelatedImages image) {
		Session session = sessionFactory.getCurrentSession();
		RelatedImages imageFound = (RelatedImages) session.get(
				RelatedImages.class, image.getId());
		session.delete(imageFound);
	}

	@Override
	public RelatedImages getRelatedImagesById(String id) {
		Session session = sessionFactory.getCurrentSession();
		RelatedImages imageFound = (RelatedImages) session.get(
				RelatedImages.class, id);
		return imageFound;
	}

	@Override
	public RelatedImages updateRelatedImages(RelatedImages image) {
		sessionFactory.getCurrentSession().update(image);
		return image;
	}

	@Override
	public List<RelatedImages> list() {
		Session session = sessionFactory.getCurrentSession();
		List<RelatedImages> documents = null;
		try {
			documents = (List<RelatedImages>) session.createQuery(
					"from RelatedImages").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return documents;
	}

}
