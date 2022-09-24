package com.taoism.discipline.controller;


import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Tao;


@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello() {
    	Tao tao = Tao.fromLunar(Lunar.fromDate(new Date()));

    	System.out.println(tao);
    	
    	String str ="道曆 " + tao.getYearInChinese() + "年 " + tao.getMonthInChinese() + "月" + tao.getDayInChinese() + "日";
    	
    	return str;
        //return "Hello and Welcome to the discipline of taoism's application.";
    }
}
