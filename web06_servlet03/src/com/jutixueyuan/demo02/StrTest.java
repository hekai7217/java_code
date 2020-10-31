package com.jutixueyuan.demo02;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author 黄药师
 * @date 2020-10-27 10:52
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   测试 字符串的乱码问题?
 *
 *     字符串的乱码问题:
 *        01 字符串的编码和解码不统一
 *        02 数据丢失
 *
 */
public class StrTest {

    @Test
    public void test01() throws UnsupportedEncodingException {

        String msg = "31晚上6点s10总决赛";

        // msg 转成 byte
        byte[] bytes = msg.getBytes();  // 编码  默认的编码

        // bytes  转成字符串
//        String gbk = new String(bytes, 0, bytes.length, "gbk");
        // 解决 编码和解码 保持一致
        String gbk = new String(bytes, 0, bytes.length, "utf-8");
        System.out.println("gbk = " + gbk);

    }

    @Test
    public void test02() throws UnsupportedEncodingException {

        String msg = "31晚上6点s10总决赛";
        // msg 转成 byte
        byte[] bytes = msg.getBytes();  // 编码  默认的编码
        // 数据丢失的乱码
        String gbk = new String(bytes, 0, bytes.length, "utf-8");
        System.out.println("gbk = " + gbk);

    }

    @Test
    public void testUrl() throws Exception {

        //编码  把汉字转成url编码
        String str = "天气不错";
        String encode = URLEncoder.encode(str, "utf-8");
        System.out.println(encode);

        // 解码   把url编码 解析成字符串
        String decode = URLDecoder.decode(encode, "utf-8");
        System.out.println(decode);

    }
}
