package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.utils.UserProvider;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-12 17:30
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class SqlTest {

    @Test
    public void testconditionSelect(){

        UserProvider userProvider = new UserProvider();

        User user = new User();
        user.setName("一灯");
//        user.setPassword("abc");
        user.setAge(44);

        String sql = userProvider.findUserByCondition(user);
        System.out.println("sql = " + sql);

    }

    @Test
    public void testcount(){

        UserProvider userProvider = new UserProvider();

        User user = new User();
        user.setName("一灯");
//        user.setPassword("abc");
        user.setAge(44);

        String sql = userProvider.findUserByConditionUserCount(user);
        System.out.println("sql = " + sql);

    }

    @Test
    public void testUpdate(){

        UserProvider userProvider = new UserProvider();

        User user = new User();
        user.setName("一灯");
//        user.setPassword("abc");
//        user.setAge(44);
        user.setId(7);

        String sql = userProvider.updateUserByNotNUll(user);
        System.out.println("sql = " + sql);

    }

    @Test
    public void testDeleteBatchs(){

        UserProvider userProvider = new UserProvider();
        List<Integer> list = Arrays.asList(1, 2, 3);
        String sql = userProvider.deleteBatchByid(list);
        System.out.println("sql = " + sql);

    }

    @Test
    public void testinserSave(){

        User u1 = new User();
        u1.setName("段正淳");
        u1.setPassword("111");
        u1.setAge(45);

        User u2 = new User();
        u2.setName("白刀凤");
        u2.setPassword("111");
        u2.setAge(44);

        UserProvider userProvider = new UserProvider();
        List<User> list = Arrays.asList(u1, u2);
        String sql = userProvider.insertUsers(list);
        System.out.println("sql = " + sql);

    }
}
