package com.lesbonne.sharingpost;

/**
 * @author yucheng
 * @since 1
 * */
public interface SharingPostService {

	void persistSharingPost(SharingPost sharingPost);
	
	SharingPost getSharingPostById(String sharingPostId);
	
	SharingPost updateSharingPost(SharingPost sharingPost);
	
	void deleteSharingPost(SharingPost sharingPost);
}
