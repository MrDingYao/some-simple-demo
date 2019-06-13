package com.santu.stream;

import cn.hutool.json.JSONUtil;
import com.santu.common.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一些比较常用的stream流的方法介绍
 */
public class StreamTest {

    private List<String> list;

    @Before
    public void init() {
        list = Arrays.asList("xietingfeng","zhangbaizhi","chenguanxi","linzhiling");
    }

    /**
     * stream流的filter方法用法
     * filter：过滤出满足条件的元素,方法内的lambda表达式返回值是Boolean
     */
    @Test
    public void filter(){
        List<String> collect = list.stream().filter(s -> s.startsWith("c")).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * stream流的map方法
     * 将元素进行转换
     */
    @Test
    public void map() {
        // 将字符串元素转换成字节数组
        List<char[]> collect = list.stream().map(String::toCharArray).collect(Collectors.toList());
        System.out.println(JSONUtil.toJsonStr(collect));
    }

    /**
     * stream流的distinct方法：去重
     */
    @Test
    public void distinct() {
        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * stream流的reduce方法：累积计算
     */
    @Test
    public void reduce() {
        Integer result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce((a, b) -> a + b).get();
        System.out.println(result);
    }

    /**
     * 遍历
     */
    @Test
    public void foreach() {
        list.stream().forEach(System.out::println);
    }

    /**
     * anyMatch：是否有元素满足判断条件
     */
    @Test
    public void anyMatch() {
        boolean result = list.stream().anyMatch(s -> s.startsWith("c"));
    }

    @Test
    public void peek() {
        List<User> users = list.stream().map(s -> new User(s, null, null, null)).peek(u -> u.setAddress("中国")).collect(Collectors.toList());
        System.out.println(users);
    }

    @Test
    public void sorted() {
        List<String> collect = list.stream().sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
