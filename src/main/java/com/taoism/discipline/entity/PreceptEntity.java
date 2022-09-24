package com.taoism.discipline.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import jdk.jfr.Description;

@Table(name = "t_precept")
public class PreceptEntity {
	@Id
	@Column(name = "precept_id")
    private Long preceptId;
	
	@Column(name = "data_type")
    private String dataType;
	
	@Description(value = "戒文子类型，暂时只有天仙有,1:远身行法;2:离口过法;3:除恶想法;4:拔逮根法;5:绝声色法;6:俭爱欲法;7:放翫习法;8:洗垢秽法;9:无昏惑法;10:不淫想法;11:不疑空法;12:平好丑法;13:不邪还法;14:常住无法;15:绝心想法;16:习悉意法;17:善防言法;18:不乱转法;19:不悟念法;20:不彼念法;21:不悠想法;22:无常定法;23:无常的法;24:无常顾法;25:不追怀法;26:无犹豫法;27:忍不可忍法;")
	@Column(name = "sub_type")
	private String subType;
	
	@Description(value = "戒文内容")
    private String content;
	
	@Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_update_date")
    private Date lastUpdateDate;
    
    @Description(value = "创建人ID")
    @Column(name = "created_by")
    private Long createdBy;
    
    @Description(value = "数据有效标识")
    private byte status;
    
    @Description(value = "最后更新人ID")
    @Column(name = "last_update_by")
    private Long lastUpdatedBy;

	public Long getPreceptId() {
		return preceptId;
	}

	public void setPreceptId(Long preceptId) {
		this.preceptId = preceptId;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
    
}
