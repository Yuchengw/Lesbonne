package com.lesbonne.sharingpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yucheng
 * @since 1
 * */
@Service
public class SharingPostServiceImpl implements SharingPostService{
	
	@Autowired
	SharingPostDAO sharingPostDAO;
	
	@Override
	@Transactional
	public void persistSharingPost(SharingPost sharingPost){
		sharingPostDAO.persistSharingPost(sharingPost);
	}
	
	@Override
	@Transactional
	public SharingPost getSharingPostById(String sharingPostId){
		return sharingPostDAO.getSharingPostById(sharingPostId);
	}
	
	@Override
	@Transactional
	public SharingPost updateSharingPost(SharingPost sharingPost){
		return sharingPostDAO.updateSharingPost(sharingPost);
	}
	
	@Override
	@Transactional
	public void deleteSharingPost(SharingPost sharingPost) {
		sharingPostDAO.deleteSharingPost(sharingPost);
	}
}
