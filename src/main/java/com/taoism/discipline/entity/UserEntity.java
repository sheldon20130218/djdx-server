package com.taoism.discipline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_user")
public class UserEntity {
    @Id
    private Integer uid;

    private String openid;

    private String token;

    private String nickname;

    private String gender;

    private String city;

    @Column(name = "avatar_base64")
    private String avatarBase64;

    @Column(name = "phone_num")
    private String phoneNum;

    /**
     * 注册时间
     */
    @Column(name = "reg_date")
    private Date regDate;

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
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
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
     * 获取注册时间
     *
     * @return reg_date - 注册时间
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * 设置注册时间
     *
     * @param regDate 注册时间
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
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