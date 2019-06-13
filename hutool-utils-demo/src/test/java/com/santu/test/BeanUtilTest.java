package com.santu.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapBuilder;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import com.santu.common.domain.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeanUtilTest {

    @Test
    public void beanToMap() {
        User user = new User("dingding", "dsj", 18, "shanghai");
        Map<String, Object> map = BeanUtil.beanToMap(user, true, true);
        map.entrySet().forEach(System.out::println);
    }

    @Test
    public void copyProperties() {
        User user = new User("dingding", "dsj", 18, "shanghai");
        User newUser = new User();
        BeanUtil.copyProperties(user, newUser);
        System.out.println(newUser);
    }

    @Test
    public void fillBeanWithMap() {
        Map<String, String> map = MapUtil.builder("name", "dingyao")
                .put("group", "dsj")
                .put("age", "18")
                .put("address", "shanghai").build();
        User user = new User();
        BeanUtil.fillBeanWithMap(map, user, true);
        System.out.println(user);
    }
}
