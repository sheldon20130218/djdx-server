package com.taoism.discipline.model;

import java.util.Date;

import com.taoism.discipline.entity.UserEntity;
import com.taoism.discipline.entity.UserExtensionEntity;

public class UserInfo {
	
	public UserInfo() {
		
	}
	
	public UserInfo(UserEntity entity,UserExtensionEntity userExtensionEntity){
		this.uid = entity.getUid();
		this.token = entity.getToken();
		this.nickname =entity.getNickname();
		this.avatarBase64 = entity.getAvatarBase64();
		this.status =entity.getStatus();
		
		this.legalName = userExtensionEntity.getLegalName();
		this.gender = userExtensionEntity.getGender();
		this.phoneNum = userExtensionEntity.getMobile();
		this.sect = userExtensionEntity.getSect();
		this.master = userExtensionEntity.getMaster();
		this.address = userExtensionEntity.getAddress();
		if(null != userExtensionEntity.getHatDate()) {
			this.hatDate = userExtensionEntity.getHatDate().getTime();
		}
		this.hatAddress = userExtensionEntity.getHatAddress();
		if(null != userExtensionEntity.getReceivePreceptsDate()) {
			this.receivePreceptsDate = userExtensionEntity.getReceivePreceptsDate().getTime();
		}
		this.receivePreceptsAddress = userExtensionEntity.getReceivePreceptsAddress();
		this.certificateCode = userExtensionEntity.getCertificateCode();
		this.specialty = userExtensionEntity.getSpeciality();
	}
	
    private Integer uid;

    private String token;

    private String nickname;

    private String avatarBase64;
    
    private Integer status;
    
    private String legalName;

    private String gender;
    
    private String phoneNum;

    private String sect;

    private String master;

    private String address;

    private Long hatDate;
    
    private String hatAddress;

    private Long receivePreceptsDate;

    private String receivePreceptsAddress;

    private String certificateCode;
    
    private String specialty;
    
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

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getSect() {
		return sect;
	}

	public void setSect(String sect) {
		this.sect = sect;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getHatDate() {
		return hatDate;
	}

	public void setHatDate(Long hatDate) {
		this.hatDate = hatDate;
	}

	public Long getReceivePreceptsDate() {
		return receivePreceptsDate;
	}

	public void setReceivePreceptsDate(Long receivePreceptsDate) {
		this.receivePreceptsDate = receivePreceptsDate;
	}

	public String getReceivePreceptsAddress() {
		return receivePreceptsAddress;
	}

	public void setReceivePreceptsAddress(String receivePreceptsAddress) {
		this.receivePreceptsAddress = receivePreceptsAddress;
	}

	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	public String getHatAddress() {
		return hatAddress;
	}

	public void setHatAddress(String hatAddress) {
		this.hatAddress = hatAddress;
	}

	public String getSpeciality() {
		return specialty;
	}

	public void setSpeciality(String speciality) {
		this.specialty = speciality;
	}
	
}