package com.taoism.discipline.serviceimpl;

import java.sql.Date;
import java.util.List;

import com.taoism.discipline.model.ClockinInfo;
import com.taoism.discipline.model.PreceptClockin;

public interface ClockinImpl {

	List<PreceptClockin> Clockin(String openid,Date date, String preceptIds,String preceptDataType);
	
	ClockinInfo getHistoryClockinInfo(String openid, Date date);
	
}
