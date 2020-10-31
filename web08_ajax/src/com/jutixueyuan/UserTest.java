package com.jutixueyuan;

import com.alibaba.fastjson.JSON;
import com.jutixueyuan.bean.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-30 15:31
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *    把java对象转成json 字符串
 *
 *    去下载第三方的框架 json的工具:
 *    01 fastjson
 *       下载地址 : https://mvnrepository.com/ maven 仓库
 *
 *    用 fastJson 把 java对象转成json 字符串
 *
 */
public class UserTest {

    @Test
    public void javaToJsonStr(){

        // 可以通过java的字符串 拼接 实现把对象转成 json字符串
        // {"name":"黄蓉","age":30}
        // 拼接很麻烦 使用第三方的框架
        User u = new User("黄蓉", 30);

        // 使用fastJson 把java对象转成字符串

        // toJSONString 这个方法可以直接把对象转成 json字符串
        String s = JSON.toJSONString(u);
        System.out.println("s = " + s);

        // 可以把 数组转成 json字符串
        List<User> users = Arrays.asList(new User("黄蓉", 30), new User("郭靖", 32), new User("杨康", 30));
        String strJson = JSON.toJSONString(users);
        System.out.println("strJson = " + strJson);

    }

}
