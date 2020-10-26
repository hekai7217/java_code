package com.jutixueyuan.test;

import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-09 10:59
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  junit 的使用技巧:
 *    01 选中需要测试的方法
 *        add  + ctrl + shift + T 可以快速创建一个 测试类型
 *
 *   02 配置测试模板
 *        setting ---> live TempXXX
 *
 *         @Test
           public void $name$(){   // 自己定义方法的名称
              $END$   // 鼠标悬停的位置
           }
 */
public class Demo05Test {

    @Test
    public void demo02(){

    }

     @Test
     public void demo01(){
         System.out.println("Demo05Test.demo01");
     }

}
