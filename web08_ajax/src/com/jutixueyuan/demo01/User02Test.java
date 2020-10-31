package com.jutixueyuan.demo01;

import com.alibaba.fastjson.JSON;
import com.jutixueyuan.bean.User;
import org.junit.Test;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-30 15:40
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *    java  json 字符串转成 java对象
 */
public class User02Test {

    @Test
    public void strToJava(){

        // javajson字符串
        String str1 = "{\"age\":30,\"name\":\"黄蓉\"}";

        // parseObject 把 字符串转成java对象
        // 参数1  给字符串  参数2 对象的字节码
        User user = JSON.parseObject(str1, User.class);
        System.out.println("user = " + user);

        String strArr = "[{\"age\":30,\"name\":\"黄蓉\"},{\"age\":32,\"name\":\"郭靖\"},{\"age\":30,\"name\":\"杨康\"}]";
        List<User> users = JSON.parseArray(strArr, User.class);
        System.out.println("users = " + users);

    }
}
