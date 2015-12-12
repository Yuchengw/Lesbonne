package com.lesbonne.sharingpost;

/**
 * @author yucheng
 * @since 1
 * */
public interface SharingPostDAO {
	
	void persistSharingPost(SharingPost sharingPost);
	
	void deleteSharingPost(SharingPost sharingPost);
		
	SharingPost getSharingPostById(String sharingPostId);
	
	SharingPost updateSharingPost(SharingPost sharingPost);
}
