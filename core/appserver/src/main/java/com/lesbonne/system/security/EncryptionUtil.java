package com.lesbonne.system.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author yucheng
 * @since 1
 * */
public class EncryptionUtil {
	
	public static String encryptionAlgo = "SHA-256";
	
	public String getEncryptionAlgo() {
		return encryptionAlgo;
	}
	
	public void setEncryptionAlgo(String encryptionAlgo) {
		this.encryptionAlgo = encryptionAlgo;
	}
	/**
	 * @throws NoSuchAlgorithmException 
	 * 
	 * */
	public static String encryptPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(encryptionAlgo);
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
	}
}
