/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * SchedulingConfig
 * 这个 cron 规则是静态的，如果要修改定时任务，只能停止服务器 -----》修改 cron -----》重启服务器
 * @author 萝卜丝
 * @since 2017-09-13
 */
@Configuration
@EnableScheduling
public class StaticSchedulingConfig {

    /**
     * 每月1号，每隔5s 钟执行一次
     */
    public static final String CRON = "0/5 * * 1 * ?";
    /**
     * @Scheduled 定义某个定时任务。
     * @Scheduled(fixedRate = 5000) 每 5s 执行一次
     * @Scheduled(fixedDelay = 1)
     */
    @Scheduled(cron = CRON) //  CRON 只能是常量
    public void scheduler() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>luobosi");
    }

}