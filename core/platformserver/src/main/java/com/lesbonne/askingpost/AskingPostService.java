package com.lesbonne.askingpost;

/**
 * @author yucheng
 * @since 1
 * */
public interface AskingPostService {
	
	void persistAskingPost(AskingPost askingPost);
	
	AskingPost getAskingPostById(String askingPostId);
	
	AskingPost updateAskingPost(AskingPost askingPost);
	
	void deleteAskingPost(AskingPost askingPost);
}
