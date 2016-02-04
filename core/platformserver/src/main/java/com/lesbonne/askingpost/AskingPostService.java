package com.lesbonne.askingpost;

/**
 * The interfact for the AskingPostService
 * @author Jassica
 * @since 1
 * */
public interface AskingPostService {
	
	AskingPost persistAskingPost(AskingPost askingPost);
	
	AskingPost getAskingPostById(String askingPostId);
	
	AskingPost updateAskingPost(AskingPost askingPost);
	
	void deleteAskingPost(AskingPost askingPost);
}
