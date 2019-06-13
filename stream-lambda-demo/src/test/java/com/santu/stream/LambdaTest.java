package com.santu.stream;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.santu.common.domain.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    /**
     * 传统的Runnable写法
     */
    @Test
    public void tradition() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(DateUtil.now());
            }
        };
        new Thread(runnable).start();
    }

    /**
     * 使用lambda表达式
     * lambda表达式由3部分组成：参数列表，箭头，方法体
     * (参数列表，多个参数用逗号隔开) -> { 代码语句 }
     */
    @Test
    public void lambda() {
        new Thread(() -> {
            System.out.println(DateUtil.now());
        }).start();
    }

    /**
     * 排序
     */
    @Test
    public void comparatorByAge() {
        List<User> users = Arrays.asList(new User("dingyao", "dsj", 18, "jiangsu"),
                new User("yangke", "dsj", 17, "hunan"),
                new User("jinyong", "dsj", 19, "hunam"),
                new User("yangxinping", "dsj", 20, "hunan"));
        CollectionUtil.sort(users, (a, b) -> a.getAge() - b.getAge());
        System.out.println(users);
    }
}
