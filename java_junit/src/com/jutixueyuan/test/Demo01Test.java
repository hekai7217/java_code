package com.jutixueyuan.test;

import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-09 10:24
 * @desc 百战程序员 http://www.itbaizhan.com
 *   junit的使用:使用注解 @Test 用在方法上面, 可以直接运行这个方法
 *
 *   使用junit的步骤:
 *     01 引入 junit的环境
 *         junit 在很多编译器中集成了 junit 可以很快速的导入@junit 环境
 *     02 只在方法上面使用@Test注解
 *       @Test  报红色警告, alt + enter  编译器会自动导入junit环境
 *
 *     03 运行 junit
 *             01 选中方法的名称,鼠标右键run 可以直接运行
 *             02 点击行号上的绿色三角形按钮 run Test
 */
public class Demo01Test {

    @Test
    public void demo01(){
        System.out.println(" hello");
    }


}
