package com.lesbonne.askingpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yucheng
 * @since 1
 * */
@Service("AskingPostService")
public class AskingPostServiceImpl implements AskingPostService {

	@Autowired
	AskingPostDAO askingPostDAO;
	
	@Override
	@Transactional
	public void persistAskingPost(AskingPost askingPost) {
		askingPostDAO.persistAskingPost(askingPost);
	}
	
	@Override
	@Transactional
	public AskingPost getAskingPostById(String askingPostId) {
		return askingPostDAO.getAskingPostById(askingPostId);
	}
	
	@Override
	@Transactional
	public AskingPost updateAskingPost(AskingPost askingPost) {
		return askingPostDAO.updateAskingPost(askingPost);
	}
	
	@Override
	@Transactional
	public void deleteAskingPost(AskingPost askingPost) {
		askingPostDAO.deleteAskingPost(askingPost);
	}
}
