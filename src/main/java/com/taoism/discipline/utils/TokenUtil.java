package com.taoism.discipline.utils;

public class TokenUtil {
	
	//定义盐
	private final static String SLAT = AesUtil.customSaltContent();
	
	//根据openId获取Token
	public static String getToken(String openid) {
		String token = null;
		try {
			token = AesUtil.encrypt(openid, SLAT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return token;
	}
	
	public static String getOpenid(String token) {
		String openid = null;
		try {
			openid = AesUtil.decrypt(token, SLAT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return openid;
	}
}

