package com.taoism.discipline.model;

public class VxapiVerificationInfo {
	
	//wxqqapi源属性
	private String openid;
	
	//wxqqapi源属性
	private String session_key;
	
	//wxqqapi源属性
	private String access_token;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
}
