package com.jutixueyuan.utils;

import com.jutixueyuan.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-12 17:15
 * @desc 百战程序员 http://www.jutixueyuan.com
 * 创建 动态的sql类
 * <p>
 * 动态拼接的sql的方法和类:
 * SQL  类是 mybatis 提供的 sql拼接的类型  类似 StringBuilder
 * <p>
 * 方法
 * select() 查询的列
 * FROM()  查询表
 * WHERE()  拼接sql的条件
 * OR()/ and() 逻辑运算符的方法
 * update()  更新的操作
 * set()  设置 更新的条件
 * toString() 把sql 对象转成 sql字符串
 */
public class UserProvider {

    /**
     * 写动态SQL
     * 自己写动态的sql 可以 通过字符串拼接
     * StringBuilder
     * mybatis提供了 自己拼接的sql 类的api
     *
     * @param u
     * @return 返回的字符串 就是 动态的sql
     */
    public String findUserByCondition(User u) {

        // 使用mybatis提供的api
        // 构造动态sql的类型
        SQL sql = new SQL();
        // select * from user where id = 1 and age =20;
        // 查询列名的方法  可以给多个列
        sql.SELECT("*");  // select *
        sql.FROM("user");   //   // select * from user

        //先判断 再 给条件
        if (u.getName() != null) {
            sql.WHERE("name = #{name}");
        }
        // 多个条件默认是and  可以自己修改
        if (u.getAge() != null) {
            sql.OR();
            sql.WHERE("age = #{age}");
        }
        if (u.getPassword() != null) {
            sql.OR();
            sql.WHERE("password = #{password}");
        }
        // 把sql对象 转成 字符串返回
        return sql.toString();
    }

    /**
     * 条件查询的统计的SQL
     *
     * @param user
     * @return
     */
    public String findUserByConditionUserCount(User user) {

        SQL sql = new SQL();

        // select count("*") from user where id = 1 and age = 20

        sql.SELECT("count(*)");
        sql.FROM("user");

        if (user.getName() != null) {
            sql.WHERE("name = #{name}");
        }
        if (user.getAge() != null) {
            sql.OR();
            sql.WHERE("age = #{age}");
        }
        if (user.getPassword() != null) {
            sql.OR();
            sql.WHERE("password = #{password}");
        }
        return sql.toString();
    }

    /**
     * 条件更新的 动态sql的实现
     *
     * @param u
     * @return
     */
    public String updateUserByNotNUll(User u) {

        SQL sql = new SQL();
        // update user set name = #{name},age = #{age} where id = #{id}
        sql.UPDATE("user");

        if (u.getName() != null) {
            sql.SET("name = #{name}");
        }

        if (u.getAge() != null) {
            sql.SET("age = #{age}");
        }
        if (u.getPassword() != null) {
            sql.SET("password = #{password}");
        }
        // id
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    /**
     * 动态的产生删除的sql
     *
     * @param ids
     * @return
     */
    public String deleteBatchByid(@Param("ids") List<Integer> ids) {

        // delete from user where id in (1,2,3)
        SQL sql = new SQL();
        sql.DELETE_FROM("user");

        //(1,2,3)这个拼接需要手动完成  StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        //sql的字符串的拼接
//        for (Integer id : ids) {
//            sb.append(id + ",");
//        }

        // sql的ognl拼接
        // delete from user where id in (#{ids[0]},#{ids[1]},#{ids[2]})
        for (int i = 0; i < ids.size(); i++) {
            sb.append("#{ids[" + i + "]}" + ",");
        }
        // 把最后一个多余的 , 给删除
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        sql.WHERE("id in " + sb.toString());

        return sql.toString();
    }


    public String insertUsers(@Param("us") List<User> us) {

        StringBuilder sb = new StringBuilder();
        // insert into user(name,age,password) values (aa,10,bb),(aa,10,bb)

        sb.append("insert into user(name,age,password) values ");

//        for (int i = 0; i < us.size(); i++) {
//            sb.append("(");
//            sb.append("'"+ us.get(i).getName() +"'" + ",");
//            sb.append(us.get(i).getAge() + ",");
//            sb.append("'"+ us.get(i).getPassword()+"'");
//            sb.append(")"+",");
//        }
//        sb.deleteCharAt(sb.length() - 1);
        // insert into user(name,age,password), values (#{list[i].name},#{list[i].age,#{list[i].password),(aa,10,bb)
        for (int i = 0; i < us.size(); i++) {
            sb.append("(");
            sb.append("#{us["+i+"].name},");
            sb.append("#{us["+i+"].age},");
            sb.append("#{us["+i+"].password}");
            sb.append(")"+",");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
