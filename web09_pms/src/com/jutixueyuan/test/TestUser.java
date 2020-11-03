package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.service.UserService;
import com.jutixueyuan.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.Date;

/**
 * @author 黄药师
 * @date 2020-11-02 10:57
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class TestUser {

    @Test
    public void testCheckName(){


        UserService userService = new UserServiceImpl();

        boolean admin = userService.checkName("lisi");

        System.out.println("admin = " + admin);
        System.out.println(admin?"用户名已存在":"用户名可以使用");

    }

    @Test
    public void testAddUser(){

        User u = new User();
        u.setUsername("aaa");
        u.setPassword("123");
        u.setRealname("zhangsan");
        u.setEmail("11@qq.com");
        u.setQq("1111");
        u.setPhone("1111");
        u.setImg("/ab/a.jpg");
        u.setRegtime(new Date());

        UserService userService = new UserServiceImpl();

        boolean addUser = userService.addUser(u);

        System.out.println("addUser = " + addUser);
        System.out.println(addUser?"添加成功":"添加失败");

    }

    @Test
    public void testUpdateUser(){

        User u = new User();
        u.setId(10);
        u.setUsername("周芷若");
        u.setPassword("111");
        u.setRealname("周芷若");
        u.setEmail("222@qq.com");
        u.setQq("222");
        u.setPhone("222");
        u.setImg("/ab/a.jpg");
        u.setRegtime(new Date());

        UserService userService = new UserServiceImpl();

        boolean update = userService.updateUser(u);

        System.out.println("update = " + update);
        System.out.println(update?"修改成功":"修改失败");

    }

}
