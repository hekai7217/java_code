package com.jutixueyuan.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-13 9:50
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class StringTest {

    @Test
    public void test(){


        List<Integer> list = Arrays.asList(1, 2, 3);

        //(1,2,3)这个拼接需要手动完成  StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for (Integer id : list) {
            sb.append(id + ",");
        }
        // (1,2,3,  拿到长度   sb.length() - 1 拿到,下标
//        // 把最后一个多余的 , 给删除
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        System.out.println("sb.toString() = " + sb.toString());

    }

}
