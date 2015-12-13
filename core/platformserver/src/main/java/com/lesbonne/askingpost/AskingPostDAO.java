package com.lesbonne.askingpost;

/**
 * @author yucheng
 * @since 1
 * */
public interface AskingPostDAO {

	void persistAskingPost(AskingPost askingPost);
	
	void deleteAskingPost(AskingPost askingPost);
	
	AskingPost getAskingPostById(String askingPostId);
	
	AskingPost updateAskingPost(AskingPost askingPost);
}
