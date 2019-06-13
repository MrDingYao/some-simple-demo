package com.santu.test;

import cn.hutool.core.collection.CollectionUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CollectionUtilTest {

    private List<String> list = Arrays.asList("dingyao", "yangke", "jinyong", "yangxinping");

    @Test
    public void isEmpty() {
        boolean empty = CollectionUtil.isEmpty(list);
        System.out.println(empty);
    }

    @Test
    public void contains() {
        boolean contains = CollectionUtil.contains(list, "dingyao");
        System.out.println(contains);
    }

    /**
     * 去重
     */
    @Test
    public void distinct() {
        CollectionUtil.distinct(list);
    }

}
