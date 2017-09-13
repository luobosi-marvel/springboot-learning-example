/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * DynamicScheduingConfig
 * 在不停应用的情况下更改任务执行周期
 * 动态修改 cron 规则（可以不用重启服务器）
 * @author 萝卜丝
 * @since 2017-09-13
 *
 * TODO: 疑问1：如何动态关闭这个定时器？
 * TODO: 疑问2：nextExecutionTime()方法返回的Date意义是什么？
 * TODO：疑问3：cron 修改不能及时生效问题。
 */
@Component
@Configuration
@EnableScheduling
public class DynamicScheduingConfig implements SchedulingConfigurer{

    private static final Logger logger = LoggerFactory.getLogger(DynamicScheduingConfig.class);

    private static String cron;

    public DynamicScheduingConfig() {
        cron = "0/5 * * * * ?";

        // 开启新线程模拟外部更改了任务执行周期
        new Thread(()->{
            try {
                Thread.sleep(15 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cron = "0/10 * * * * ?";
            System.out.println("cron change to" + cron);
        }).start();
    }

    /**
     * 这个方法可以动态修改 cron ，并运行我们的任务
     * @param taskRegistrar 任务注册器，系统会自动帮我们传入这个参数
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
            // 任务逻辑
            logger.debug("DynamicScheduingConfig is running ...");
        }, triggerContext -> {
                // 任务触发，可修改任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
        });
    }
}