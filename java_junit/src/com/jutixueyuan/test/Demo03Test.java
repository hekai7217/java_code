package com.jutixueyuan.test;

import com.jutixueyuan.Math;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-09 10:39
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   junit的 断言测试
 *
 *     01 使用junit的  Assert.assertEquals(3,add); 断言方法
 *        如果期望值和 实际结果值 一致  断言测试通过
 *        如果不一致 断言测试失败
 */
public class Demo03Test {
    
    @Test
    public void demo01(){

        Math m = new Math();
        int add = m.add(1, 2);
        // 可以看 测试是否为绿色 + add的结果可以 判断测试是否成功
        System.out.println("add = " + add);
        //断言测试
        // expected  期望值    add   Actual 实际值
        // 期望值和 结果值相等  测试通过
        Assert.assertEquals(8,add);
    }

    @Test
    public void demo02(){

        Math m = new Math();
        int div = m.div(10, 2);
        System.out.println("div = " + div);

    }

}
