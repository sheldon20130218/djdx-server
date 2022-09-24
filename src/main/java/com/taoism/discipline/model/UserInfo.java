package com.taoism.discipline.model;

import com.taoism.discipline.entity.UserEntity;

public class UserInfo {
	
	public UserInfo(UserEntity entity){
		this.uid = entity.getUid();
		this.token = entity.getToken();
		this.nickname =entity.getNickname();
		this.gender = entity.getGender();
		this.city = entity.getCity();
		this.avatarBase64 = entity.getAvatarBase64();
		this.phoneNum = entity.getPhoneNum();
		this.status =entity.getStatus();
	}
	
    private Integer uid;

    private String token;

    private String nickname;

    private String gender;

    private String city;

    private String avatarBase64;

    private String phoneNum;

    private Integer status;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }


    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return avatar_base64
     */
    public String getAvatarBase64() {
        return avatarBase64;
    }

    /**
     * @param avatarBase64
     */
    public void setAvatarBase64(String avatarBase64) {
        this.avatarBase64 = avatarBase64;
    }

    /**
     * @return phone_num
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }



    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}