/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * RedisSessionDAO
 *
 * @author 萝卜丝
 * @since 2017-10-24
 */
@Repository
public class RedisSessionDAO extends AbstractSessionDAO{


    // Session超时时间，单位为毫秒
    private long expireTime = 2000;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override // 更新session
    public void update(Session session) throws UnknownSessionException {
        System.out.println("===============update================");
        if (session == null || session.getId() == null) {
            return;
        }
        session.setTimeout(expireTime);
        redisTemplate.opsForValue().set(session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
    }

    @Override // 删除session
    public void delete(Session session) {
        System.out.println("===============delete================");
        if (null == session) {
            return;
        }
        redisTemplate.opsForValue().getOperations().delete(session.getId());
    }

    @Override// 获取活跃的session，可以用来统计在线人数，如果要实现这个功能，可以在将session加入redis时指定一个session前缀，统计的时候则使用keys("session-prefix*")的方式来模糊查找redis中所有的session集合
    public Collection<Session> getActiveSessions() {
        System.out.println("==============getActiveSessions=================");
        return redisTemplate.keys("*");
    }

    @Override// 加入session
    public Serializable doCreate(Session session) {
        Serializable token = this.generateSessionId(session);
        System.out.println("===============doCreate================");
        this.assignSessionId(session, token);

        redisTemplate.opsForValue().set(session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
        return token;
    }

    @Override// 读取session
    public Session doReadSession(Serializable sessionId) {
        System.out.println("==============doReadSession=================");
        if (sessionId == null) {
            return null;
        }
        return (Session) redisTemplate.opsForValue().get(sessionId);
    }
}