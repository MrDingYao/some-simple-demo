package com.santu.test;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * 字符串工具StrUtil中部分常用方法demo
 */
public class StrUtilTest {

    /**
     * 判断字符串非空，包括null和空白符
     */
    @Test
    public void blank() {
        boolean blank1 = StrUtil.isBlank("     ");
        boolean blank2 = StrUtil.isBlank(null);
    }

    @Test
    public void equals() {
        boolean equals = StrUtil.equals("abc", "abc");
    }

    @Test
    public void uuid() {
        String uuid = StrUtil.uuid();
        System.out.println("uuid = " + uuid);
    }

    /**
     * 从最后一个指定字符截取前段
     */
    @Test
    public void subBefore() {
        String s = StrUtil.subBefore("/usr/local/java/bin", "/", true);
        System.out.println(s);
    }
}
