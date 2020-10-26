package com.jutixueyuan.demo01;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 黄药师
 * @date 2020-10-19 15:49
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   java中正则的 在字符串中的使用
 *     01  替换
 *     02  切割
 *
 */
public class Demo02 {

    @Test
    public void test01(){

        // 字符串中替换的使用
        String str = "abc,127093,abc,456";
        // 把数字替换成#
        // 参数1  替换的规则 可以写正则
        // 参数2  替换后的内容
        // \d+     至少一次数字
        // \d{1,}  至少一次数字
        String s = str.replaceAll("\\d{1,}", "#");
        System.out.println("s = " + s);
    }

    @Test
    public void test02(){

        // 字符串的切割
        String str = "abc,127093,abc,456";

        // split()字符串的切割   返回的是字符串数组
//        String[] arr = str.split("\\d+");
        String[] arr = str.split(",");
        String s = Arrays.toString(arr);
        System.out.println("s = " + s);
    }
}
