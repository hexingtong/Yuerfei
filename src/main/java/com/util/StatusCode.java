package com.util;

public class StatusCode {
    public static String CODE_SUCCESS = "200";          //访问成功

    public static String CODE_ERROR = "404";          //访问错误

    public static String CODE_ERROR_PARAMETER = "400";//参数错误

    public static String CODE_ERROR_PROGRAM = "500";  //程序异常

    public static String CODE_ERROR_NO_LOGIN_OR_TIMEOUT = "0004";  //未登录或登录超时,请重新登录

    public static String CODE_ERROR_EXIST_OPERATION = "0005";      //已操作

}
