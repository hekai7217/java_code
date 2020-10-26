package com.jutixueyuan.test;

import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-09 10:32
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    junit 的测试结果查看
 *      01  运行的时候 是 绿色 进度条  方法的运行没有问题 (测试通过)
 *      02  运行异常  红棕色
 *
 *   junit测试对方法的要求
 *     01 方法不能是private 修饰
 *     02 方法不能是static 修饰
 *
 *     03 测试的方法是否可以有返回值
 *           Method demo03() should be void 不能有返回值
 *
 */
public class Demo02Test {

    @Test
    public void demo01(){
//        System.out.println("true = " + true);
        System.out.println(1 / 0 );
    }

    @Test
    public void demo02(){
//        System.out.println("true = " + true);
        System.out.println( "helll " );
    }

    @Test
    public String demo03(){
        System.out.println( "hello" );
        return "hello";
    }

}
