/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;

/**
 * RedisSessionDAO
 *
 * @author 萝卜丝
 * @since 2017-10-30
 */
public class RedisSessionDAO extends AbstractSessionDAO {

    @Override
    protected Serializable doCreate(Session session) {
        return null;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return null;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {

    }

    @Override
    public void delete(Session session) {

    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }
}