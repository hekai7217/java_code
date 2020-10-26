package com.jutixueyuan.test;

import com.jutixueyuan.Math;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.management.MXBean;

/**
 * @author 黄药师
 * @date 2020-10-09 10:48
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class Demo04Test {

    private Math math = null;

    @Before  // 运行在@test 标签的方法之前运行  可以初始化 demo01方法中的资源
    public void init(){
        System.out.println("Demo04Test.init");
        math = new Math();
    }

    @After  // 运行在@test 标签的方法之后运行  可以初关闭 demo01方法中的资源
    public void after(){
        System.out.println("Demo04Test.after");
    }

    @Test
    public void demo01(){
        System.out.println("测试方法....");
        int add = math.add(1, 2);
        System.out.println("add = " + add);
    }

    @Test
    public void demo02(){
        System.out.println("测试方法....");
        int div = math.div(4, 2);
        System.out.println("div = " + div);
    }
}
