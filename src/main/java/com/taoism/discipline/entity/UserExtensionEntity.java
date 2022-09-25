package com.taoism.discipline.entity;

import java.io.Serializable;
import java.util.Date;

public class UserExtensionEntity implements Serializable {
    /**
     * 主键ID
     */
    private Long infoId;

    /**
     * 用户ID
     */
    private String openid;

    /**
     * 用户法名
     */
    private String legalName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 用户宗派
     */
    private String sect;

    /**
     * 师父法名
     */
    private String master;

    /**
     * 现居宫观庙
     */
    private String address;

    /**
     * 冠巾时间
     */
    private Date hatDate;

    /**
     * 受戒时间
     */
    private Date receivePreceptsDate;

    /**
     * 受戒地点
     */
    private String receivePreceptsAddress;

    /**
     * 教职证编码
     */
    private String certificateCode;

    /**
     * 创建人ID(操作人)
     */
    private String createBy;

    /**
     * 创建时间(操作时间)
     */
    private Date createDate;

    /**
     * 最后更新人
     */
    private String lastUpdatedBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 特长
     */
    private String speciality;

    private static final long serialVersionUID = 1L;

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Date getHatDate() {
        return hatDate;
    }

    public void setHatDate(Date hatDate) {
        this.hatDate = hatDate;
    }

    public Date getReceivePreceptsDate() {
        return receivePreceptsDate;
    }

    public void setReceivePreceptsDate(Date receivePreceptsDate) {
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}