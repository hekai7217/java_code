package com.sxt.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-10 10:50
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   总结:
 *     01 log4j 的日志的配置
 *         1. 日志级别             4个 等级  error /warn/info/debug
 *         2  可以 日志的输出位置     console 控制台/ file 输出到文件中
 *         3  配置 日志的输出格式     控制台输出格式   10:54:30,800ERROR LogTest:23- error 
 *                                文件输入格式 2020-10-10 10:54:30 [main:4]-[ERROR]  error 
 *
 *    02 log4j日志输出的控制
 *          优先级从高到低依次为：OFF、FATAL、ERROR、WARN、INFO、DEBUG、TRACE、 ALL。
 *          如果配置了 高级日志 不会输入 低级别日志
 *            OFF   关闭了日志
 *            ERROR   低于error 不会输出
 *            debug   高于debug 都会输出
 */
public class LogTest {

    @Test
    public void testlog() {

        // 读取 log4j的配置文件
        PropertyConfigurator.configure("C:\\java_lesson\\java_10_9\\java_code\\java_log4j\\src\\log4j.properties");
        // 获取日志的 类
        Logger logger = Logger.getLogger(LogTest.class);
        // 输出日志
        logger.debug(" debug ");
        logger.error(" error ");

    }
}
