package com.jutixueyuan.demo03.impl;

import com.jutixueyuan.demo03.Servlet;

/**
 * @author 黄药师
 * @date 2020-10-09 15:26
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class MyServlet implements Servlet {
    @Override
    public void service() {
        System.out.println("hello 我是服务器的方法....");
    }
}
