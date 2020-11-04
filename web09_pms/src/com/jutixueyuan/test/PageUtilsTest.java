package com.jutixueyuan.test;

import com.jutixueyuan.service.UserService;
import com.jutixueyuan.service.impl.UserServiceImpl;
import com.jutixueyuan.utils.PageUtils;
import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-11-03 14:22
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  测试 分页的工具 导航条开始和结束的位置
 */
public class PageUtilsTest {

    @Test
    public void test01(){

//        情况1:  分页的1-6页, 导航条开始和结束位置不会变化
        PageUtils pageUtils = new PageUtils(6, 10, 760, 10);

        System.out.println("pageUtils = " + pageUtils);


    }

    @Test
    public void test02(){

//      情况2  72 - 76 导航条开始和结束位置是不变的
        PageUtils pageUtils = new PageUtils(72, 10, 760, 10);

        // 导航条开始 67  76
        System.out.println("pageUtils = " + pageUtils);
    }

    @Test
    public void test03(){

//    情况3  左边 有5个 右边有4个
        PageUtils pageUtils = new PageUtils(10, 10, 760, 10);

        // 开始为 5  结束为 14
        System.out.println("pageUtils = " + pageUtils);

    }

    @Test
    public void test04(){

        // 分页的总数 如果大于 导航条的个数  上面判断 没有问题
        // 如果分页的总数小于 导航条个数
        PageUtils pageUtils = new PageUtils(10, 10, 76, 10);

        // 开始为 5  结束为 14
        System.out.println("pageUtils = " + pageUtils);
    }

    // 测试分页 service

    @Test
    public void test05(){


        UserService userService = new UserServiceImpl();

        PageUtils pageUtils = userService.pageUser(2, 10);
        System.out.println("pageUtils = " + pageUtils);


    }
}

