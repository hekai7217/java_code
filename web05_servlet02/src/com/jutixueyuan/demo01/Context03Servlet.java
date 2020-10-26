package com.jutixueyuan.demo01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author 黄药师
 * @date 2020-10-26 10:26
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *    ServletContext  获取资源,读取文件
 *
 *      01  web项目发布到tomcat后,目录结构发生了变化
 *         web下面的a.txt文件 在项目的根目录中
 *         src下面的文本 通过编译后,c.txt文件目录是 web/WEB-INF/classes下面的目录中
 *
 *      02 如果读取资源文件
 *         servletContext 可以读取真实路径(是读取到web这个跟目录)
 *          public String getRealPath(String path)
 *          返回 虚拟路径(web根目录)的实际路径(C:\java_lesson\java_10_9\java_code\out\artifacts\web05_servlet02_war_exploded)
 *         getResourceAsStream(String path) 返回 文件中的io流
 *
 *
 *   如果是读取src下面的文件或者是classes下面的文件,路径很长 如何解决?
 *      可用Class或者Classloader 提供getResourceAsStream来获取类路径(src下面的文件/classes下面的文件)下面的资源文件
 *             // /c.txt  读取的是 src下面的c.txt文件
 *             // d.txt   读取的是 src下面的当前的类 Context03Servlet 包下面的d.txt
 *
 *     总结:
 *       01 idea中web项目的目录结构,如果 项目发布后,目录结构发生了变化
 *
 *       02 文件读取:
 *           如果是web下面的文件/WEB-INF/下面的文件通过 servletContext读取
 *             方法选择:  getResourceAsStream(String path)
 *           如果是src下面的文件/src包下面的文件 通过Class 来读取
 *              Class.getResourceAsStream()来 文件
 *              如果是src下面的文件 路径的写法: "/c.txt"
 *              如果是src下面的文件的包下面的文件的读取,路径的写法: "d.txt"
 *
 *         抽取方法的代码块的快捷键:
 *            ctrl + alt + M
 *
 *      具体的运用:
 *          后面有配置文件,配置文件的读取就是通过 servletContext读取/通过Class 来读取
 *
 */
@WebServlet(urlPatterns = "/context03")
public class Context03Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        demo01();
//        demo02();
        demo03();
    }

    /**
     *   通过Class 读取 类路径下面的资源文件
     */
    private void demo03() {
        //通过Class 提供的方法获取 类路径((src下面的文件/classes下面的文件))下面的资源文件
        //c.txt / d.txt
        // /c.txt  读取的是 src下面的c.txt文件
        // d.txt   读取的是 src下面的当前的类 Context03Servlet 包下面的d.txt

        // /c.txt  读取的是 src下面的c.txt文件
        InputStream isC = Context03Servlet.class.getResourceAsStream("/c.txt");
        String strC = readFile(isC);
        System.out.println("strC = " + strC);

        //    // d.txt   读取的是 src下面的当前的类 Context03Servlet 包下面的d.txt
        InputStream isD = Context03Servlet.class.getResourceAsStream("d.txt");
        String strD = readFile(isD);
        System.out.println("strD = " + strD);
    }

    /**
     * 通过  servletContext 获取文件的io读取文件
     *
     */
    private void demo02() {
        // 可以通过  getResourceAsStream(String path) 返回 文件中的io流
        ServletContext servletContext = getServletContext();

        // 返回文件 流
        InputStream isB = servletContext.getResourceAsStream("/WEB-INF/b.txt");
        String strB = readFile(isB);
        System.out.println("strB = " + strB);

        // 返回文件 流
        InputStream isC = servletContext.getResourceAsStream("/WEB-INF/classes/c.txt");
        String strC = readFile(isC);
        System.out.println("strC = " + strC);

        // 返回文件 流
        InputStream isD = servletContext.getResourceAsStream("/WEB-INF/classes/com/jutixueyuan/demo01/d.txt");
        String strD = readFile(isD);
        System.out.println("strD = " + strD);
    }

    /**
     * 通过真实路径读取 文件的内容
     * @throws FileNotFoundException
     */
    private void demo01() throws FileNotFoundException {
        // 获取真实路径
        ServletContext context = getServletContext();

        String realPath = context.getRealPath("/");
        System.out.println("realPath = " + realPath);
        // 通过实际路径读取 文件

        //读取a文件  a文件的真实路径  C:\java_lesson\java_10_9\java_code\out\artifacts\web05_servlet02_war_exploded\a.txt
        String realPathA = context.getRealPath("/a.txt");
        System.out.println("realPathA = " + realPathA);
        //读取文件的操作
        String msgA = readFile(realPathA);
        System.out.println("msgA = " + msgA);

        String realPathb = context.getRealPath("/WEB-INF/b.txt");
        System.out.println("realPathb = " + realPathb);
        //读取文件的操作
        String msgb = readFile(realPathb);
        System.out.println("msgb = " + msgb);

        String realPathc = context.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println("realPathc = " + realPathc);
        //读取文件的操作
        String msgC = readFile(realPathc);
        System.out.println("msgC = " + msgC);

        String realPathD = context.getRealPath("/WEB-INF/classes/com/jutixueyuan/demo01/d.txt");
        System.out.println("realPathD = " + realPathD);
        //读取文件的操作
        String msgD = readFile(realPathD);
        System.out.println("msgD = " + msgD);
    }

    /**
     * 读取文件的方法
     * @param realPathA  通过 字符串读取文件
     * @return
     */
    private String readFile(String realPathA) throws FileNotFoundException {
        File file = new File(realPathA);
       return readFile(new FileInputStream(file));

    }

    /**
     * 取文件的方法
     * @param fis  通过输入流读取文件
     * @return
     */
    private String readFile(InputStream fis) {

        //读取流中的数据
        // 选择流   字符串缓冲流

        // 需要转换流 把 字节流转成字符串流
        InputStreamReader reader = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(reader);

        // BufferedReader 操作
        // 读 char 数组
//        br.read()
        // 新增方法  读取一行
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            try {
            fis.close();
            reader.close();
            br.close();

            }catch (Exception e){

            }
        }
        return s;
    }
}
