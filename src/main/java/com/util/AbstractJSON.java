package com.util;

import java.util.Date;
/*
 * 建立AbstractJSON(JSON数据的响应基类 )
 */
public class AbstractJSON {
    private String code;                            //响应状态码
    private String msg;                             //响应状态描述
    private Long time = new Date().getTime();       //时间戳


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public void setContent(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

//   public void setStatusObject(StatusObject statusObject) {
//       this.code = statusObject.getCode();
//        this.msg = statusObject.getMsg();
//    }

}
