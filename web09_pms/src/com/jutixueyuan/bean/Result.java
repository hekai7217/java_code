package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-10-31 17:08
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   返回结果对象
 */
public class Result {

    private Integer code; // 成功或者失败的编码

    private String msg; // 成功或者失败的信息

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
