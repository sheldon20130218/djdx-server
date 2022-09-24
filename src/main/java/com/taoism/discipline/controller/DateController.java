package com.taoism.discipline.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Tao;

@RestController
@RequestMapping("/api")
public class DateController {
	
	@GetMapping("date/taoDate")
    public String taoDate(@RequestHeader(value = "token") String token) {
    	Tao tao = Tao.fromLunar(Lunar.fromDate(new Date()));
    	
    	String str ="道曆 " + tao.getYearInChinese() + "年 " + tao.getMonthInChinese() + "月" + tao.getDayInChinese() + "日";
    	
    	return str;
    }
}
