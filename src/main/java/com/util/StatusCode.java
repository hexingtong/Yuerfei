package com.util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api(value="App状态码类",tags={"App状态码类"})
public class StatusCode {

    public static String CODE_SUCCESS = "200";          //访问成功

    public static String CODE_ERROR = "404";          //访问错误

    public static String CODE_ERROR_PARAMETER = "400";//参数错误

    public static String CODE_ERROR_PROGRAM = "500";  //程序异常

    public static String CODE_ERROR_NO_LOGIN_OR_TIMEOUT = "0004";  //未登录或登录超时,请重新登录

    public static String CODE_ERROR_EXIST_OPERATION = "0005";      //已操作

    @ApiParam("返回成功")
    public static String SUCCESSFULLY = "1";//返回成功
    @ApiParam("返回失败")
    public static String FAILED = "0";//返回失败
    @ApiParam("查询到空数据")
    public static String CODE_NULL="3";//返回成功 但是查询到空数据

    public static String CODE_ERROR_503="503"; //拒绝某些客户端的连接





}
