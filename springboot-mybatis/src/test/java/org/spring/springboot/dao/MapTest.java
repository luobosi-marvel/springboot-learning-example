/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.dao;

import org.junit.Test;
import org.spring.springboot.BaseTest;

import java.util.*;

/**
 * MapTest
 *
 * @author 萝卜丝
 * @since 2017-10-12
 */
public class MapTest extends BaseTest{


    @Test
    public void test() {
        Map<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("k1", "v1");
        hashMap.put("k2", "v2");

        List<String> values = new ArrayList<String>(hashMap.values());

        Iterator<String> iterator = values.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}