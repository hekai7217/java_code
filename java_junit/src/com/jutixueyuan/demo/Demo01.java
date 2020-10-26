package com.jutixueyuan.demo;

import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-15 10:35
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class Demo01 {

    // java函数中 可以传入一个 对象
    @Test
    public void test(){

        Math math = new Math();
        MyMathImpl myMath = new MyMathImpl();
        int math1 = math.math(myMath, 1, 2);
        System.out.println("math1 = " + math1);
    }

    // java函数中传入一个匿名对象
    @Test
    public void test02(){

        Math math = new Math();
        int result = math.math(new MyMath() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        },3,4);

        System.out.println("result = " + result);
        
    }
    
}
