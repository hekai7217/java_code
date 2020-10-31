package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-10-30 17:06
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   给前端返回的结果对象
 */
public class Result {

    private boolean flag;
    private String msg;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result() {
    }

    public Result(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag=" + flag +
                ", msg='" + msg + '\'' +
                '}';
    }
}
