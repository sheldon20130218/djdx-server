package com.taoism.discipline.controller;

import com.taoism.discipline.entity.PreceptEntity;
import com.taoism.discipline.service.PreceptService;
import com.taoism.discipline.service.StrategyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Lsg on 13/09/22.
 */
@RestController
@RequestMapping("/api")
public class PreceptController {

    @Autowired
    PreceptService preceptService;
    
    @Autowired
    StrategyService strategyService;

    @GetMapping("/precepts/all/{token}")
    public List<PreceptEntity> getAllPreceptss(@PathVariable("token") String token) {
        return preceptService.selectAll();
    }
    
    @GetMapping("/precepts/today/{token}")
    public List<PreceptEntity> getPreceptsForToday(@PathVariable("token") String token) {
    	return preceptService.preceptsForToday();
    }

//    @GetMapping("/preceptss/{id}")
//    public Precepts getPreceptsById(@PathVariable(value = "id") Long PreceptsId) {
//        return PreceptService.findById(PreceptsId)
//                .orElseThrow(() -> new ResourceNotFoundException("Precepts", "id", PreceptsId));
//    }
   
}
