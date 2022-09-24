package com.taoism.discipline.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_strategy")
public class StrategyEntity {
	@Id
    private Integer id;
	
	private Date date;
	
	@Column(name = "precept_ids")
	private String preceptIds;
	
	@Column(name = "create_date")
	private Timestamp createDate;
	
	@Column(name = "create_by")
	private String createBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPreceptIds() {
		return preceptIds;
	}

	public void setPreceptIds(String preceptIds) {
		this.preceptIds = preceptIds;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
}
