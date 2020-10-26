package com.jutixueyuan.demo01;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 黄药师
 * @date 2020-10-19 15:37
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *      java中的正则的使用
 *        01 reg 正则配置引擎的使用
 *
 *        
 *        02 string中的正则的使用
 */
public class Demo01 {
    
    @Test
    public void test01(){

//        String str = "hello123java123mysql6789hello";

        String str = "123456";
        // 使用正则判断  字符串是否 符合我的要求
        // \d 数组  + 至少1次的意思
        // p正则的配置  规则至少一个数字的字符串
        Pattern p = Pattern.compile("\\d+"); // 建立表达式
        // 通过正则引擎  mather 类型
        Matcher m = p.matcher(str);
        // matches 匹配
        // 返回一个boolean

		boolean matches = m.matches();  // str 是否配置   \\d+
		System.out.println(matches);

		String tel = "12345698723";
        boolean b = matchTel(tel);
        System.out.println("b = " + b);

    }

    @Test
    public void testEmail(){

        String email = "123jflajdflajl@qq.sxt";
        boolean b = matchEmail(email);
        System.out.println("b = " + b);

    }

    // 写的一个方法配置规定的电话
    // 0\d{2,3}-\d{7,8}

    public static boolean matchTel(String tel){
        Pattern p = Pattern.compile("0\\d{2,3}-\\d{7,8}"); // 建立表达式
        // 通过正则引擎  mather 类型
        Matcher m = p.matcher(tel);
        return m.matches(); // 配置规则 结果
    }

    public static boolean matchEmail(String email){
        Pattern p = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"); // 建立表达式
        // 通过正则引擎  mather 类型
        Matcher m = p.matcher(email);
        return m.matches(); // 配置规则 结果
    }
}
