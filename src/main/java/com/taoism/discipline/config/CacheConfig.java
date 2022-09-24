package com.taoism.discipline.config;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.taoism.discipline.entity.PreceptEntity;
import com.taoism.discipline.model.VxapiVerificationInfo;

@Configuration
@EnableCaching
public class CacheConfig {
	
    @Bean(name = "preceptCache")
    public Cache<String, List<PreceptEntity>> preceptCache() {
        return Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(60, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(100)
                .build();
    }
    
    @Bean(name = "loginCache")
    public Cache<String,String> loginCache() {
        return Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(60, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(500)
                .build();
    }
    
    @Bean(name = "vxapiVerificationCache")
    public Cache<String,VxapiVerificationInfo> vxapiVerificationCache() {
        return Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(60, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(500)
                .build();
    }
    
}
