package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import sun.rmi.runtime.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-10-26 16:59
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *    存在map , 通过反射 把map中的数据赋值给 bean对象的属性
 *
 *     用反射操作费劲 推荐一个框架给大家使用
 *       内部封装的就是反射
 *      beanUtils 的框架介绍, 简化了反射的操作
 *
 */
public class UserTest {

    @Test
    public void test01(){

        // 组装个map , map的key必须和bean对象的属性名称一致
        Map<String,Object> map = new HashMap<>();
        map.put("name","马云");
        map.put("pwd","123");
        map.put("age","53");

        // 写一个方法 把map转成一个bean对象  (把map中的数据赋值给 bean对象的属性)
        try {
            User u = mapToBean(map, User.class);
            System.out.println("u = " + u);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *  通过反射 把map转成到 bean对象中
     * @param map
     * @param clazz
     * @return
     */
    private User mapToBean(Map<String, Object> map, Class<User> clazz) throws Exception {

        User user = clazz.newInstance();
        // 01 通过反射 拿到 所有的 class的属性名称
        // 反射获取所有的属性
        Field[] fs = clazz.getDeclaredFields();
        // 02 通过 属性的名称作为key, 获取map中的value值
        for (Field f : fs) {

            // 拿到所有的属性的名称
            String name = f.getName();
            System.out.println("name = " + name);

            // 拿到map中的 value
            Object o = map.get(name);
            System.out.println("o = " + o);
        // 03 通过反射把拿到的value值赋值给对象的属性
            /**
             *  obj    f是那个对象的
             *  value  属性的值
             */
            // 跳过安全检查
            f.setAccessible(true);

            // f属性对象 的数据类型
            // 获取属性的数据类型的对象
            Class type = f.getType();
            // 反射复制 判断数据类型
            if (type ==  String.class){
                f.set(user,o.toString());
            }
            if (type ==  Integer.class){
                Integer val =Integer.parseInt(o.toString());
                f.set(user,val);
            }
            if (type ==  Long.class){
                long val = (long) o;
                f.set(user,val);
            }
        }
        // 04 返回对象
        return user;
    }

    /**
     *    参数1:  给具体的对象
     *    参数2:  给具体的对象属性名称
     *    参数3:  给具体的对象属性值
     *    BeanUtils.setProperty(u,"name","马化腾")  通过反射 给 对象赋值
     *
     *    参数1  给具体的对象
     *    参数2  给具体的对象的属性名称
     *    BeanUtils.getProperty(u, "name");  返回的是 属性的对应的值
     *
     *     参数1  给具体的对象
     *     参数2  给具体map数据
     *     BeanUtils.populate(u1,map);   把map中的数据赋值给 bean对象的属性
     */
    @Test
    public void test02() throws Exception {

        User u = new User();
        //设置属性值 
        BeanUtils.setProperty(u,"name","马化腾");
        BeanUtils.setProperty(u,"age","45");
        System.out.println("u = " + u);
        
        // 获取属性值 
        String name = BeanUtils.getProperty(u, "name");
        System.out.println("name = " + name);

        // 厉害的方法 可以直接把map转成bean对象
        Map<String,Object> map = new HashMap<>();
        map.put("name","马云");
        map.put("pwd","123");
        map.put("age","53");
        User u1= new User();

        BeanUtils.populate(u1,map);
        System.out.println("u1 = " + u1);

    }
}
