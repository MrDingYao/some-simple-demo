package com.santu.test;

import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.io.File;

public class FileUtilTest {

    @Test
    public void file() {
        File file = FileUtil.file("usr", "local", "java", "bin");
        System.out.println(file.getPath());
    }

    @Test
    public void write() {
        String file = "D:\\temp\\temp.bat";
        byte[] bytes = FileUtil.readBytes(file);
        String dest = "D:\\temp\\temp_copy.bat";
        FileUtil.writeBytes(bytes, dest);
    }
}
