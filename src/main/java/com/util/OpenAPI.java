package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.client.exception.OceanException;
import com.springmvc.controller.MemberController;
import com.springmvc.pojo.Goodspvdata;
import com.springmvc.pojo.VO.paramInfos;
import com.umeng.uapp.param.*;
import org.jsoup.helper.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.*;

public class OpenAPI {
    //应用id
    final static String apiKey="9480704";
    //密钥
    final static String apiSecurity="VhHnZ2nvBqX";
    //服务器主机
    final static String  ServerHost="gateway.open.umeng.com";

    final Logger logger = LoggerFactory.getLogger(MemberController.class);

    //渠道名称
    final static String Channel="";

    //应用版本号
    final static String version="";

    //鱼儿飞iosAPPkey
    final static String YuerfeiIosAppkey= "5c8329740cafb2c0e00011bd";
    //鱼儿飞安卓APPkey
    final static String YuerfeiAndroid="5c8320d80cafb29e02000f2b";


        //成功的
        //安卓总的点击量pv
        public static void umengAndroidEventGetData() {
            ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
            apiExecutor.setServerHost(ServerHost);
            UmengUappEventGetDataParam param = new UmengUappEventGetDataParam();
            // 测试环境只支持http
            // param.getOceanRequestPolicy().setUseHttps(false);
            param.setAppkey(YuerfeiAndroid);
            param.setStartDate(DateUtils2.currDay());
            param.setEndDate(DateUtils2.currDay());
            param.setEventName("id_goodspv");

            try {
                UmengUappEventGetDataResult result = apiExecutor.execute(param);
                System.out.println(JSONObject.toJSONString(result));
            } catch (OceanException e) {
                System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
            }
        }

    //成功的
    //安卓总的点击量uv
    public static void umengAndroidUvEventGetData() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappEventGetDataParam param = new UmengUappEventGetDataParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate(DateUtils2.currDay());
        param.setEndDate(DateUtils2.currDay());
        param.setEventName("id_goodsuv");

        try {
            UmengUappEventGetDataResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
    }

    //成功的
    //苹果总的点击量pv
     public static void umengIosEventGetData() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappEventGetDataParam param = new UmengUappEventGetDataParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate(DateUtils2.currDay());
        param.setEndDate(DateUtils2.currDay());
        param.setEventName("id_goodspv");
        List lst=new ArrayList();
        try {
            UmengUappEventGetDataResult result = apiExecutor.execute(param);
            lst.add(result);
            lst.add(DateUtils2.currDay());
            System.out.println(JSONObject.toJSONString(lst));
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
    }

    //获取安卓今日pv参数值事件列表
    public static   List umengAndroidPvEventParamGetValueList() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        List lst=new ArrayList();
        UmengUappEventParamGetValueListParam param = new UmengUappEventParamGetValueListParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate(DateUtils2.currDay());
        param.setEndDate(DateUtils2.currDay());
        param.setEventName("id_goodspv");
        param.setEventParamName("goods_id");
        try {
            UmengUappEventParamGetValueListResult result = apiExecutor.execute(param);
            lst.add(result);
            lst.add(DateUtils2.currDay());
            System.out.println(JSONObject.toJSONString(lst));
            return lst;
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
            lst.add(e.getErrorCode());
            lst.add(e.getErrorMessage());
            return lst;
        }
    }

    //获取苹果今日pv参数值事件列表
    public static List umengIosPvEventParamGetValueList() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        List lst=new ArrayList();
        UmengUappEventParamGetValueListParam param = new UmengUappEventParamGetValueListParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate(DateUtils2.currDay());
        param.setEndDate(DateUtils2.currDay());
        param.setEventName("id_goodspv");
        param.setEventParamName("goods_id");
        try {
            UmengUappEventParamGetValueListResult result = apiExecutor.execute(param);
            lst.add(result);
            lst.add(DateUtils2.currDay());
            System.out.println(JSONObject.toJSONString(lst));
            return lst;
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
            lst.add(e.getErrorCode());
            lst.add(e.getErrorMessage());
            return lst;
        }
    }

    //获取苹果今日uv参数值事件列表
    public static List umengIosEventParamGetValueList() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        List lst=new ArrayList();
        UmengUappEventParamGetValueListParam param = new UmengUappEventParamGetValueListParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate(DateUtils2.currDay());
        param.setEndDate(DateUtils2.currDay());
        param.setEventName("id_goodsuv");
        param.setEventParamName("goods_id");
        try {
            UmengUappEventParamGetValueListResult result = apiExecutor.execute(param);
            lst.add(result);
            lst.add(DateUtils2.currDay());
            System.out.println(JSONObject.toJSONString(lst));
            return lst;
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
            lst.add(e.getErrorCode());
            lst.add(e.getErrorMessage());
            return lst;
        }
    }

    //获取安卓今日uv参数值事件列表
    public static List umengAndroidEventParamGetValueList() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        List lst=new ArrayList();
        UmengUappEventParamGetValueListParam param = new UmengUappEventParamGetValueListParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate(DateUtils2.currDay());
        param.setEndDate(DateUtils2.currDay());
        param.setEventName("id_goodsuv");
        param.setEventParamName("goods_id");
        try {
            UmengUappEventParamGetValueListResult result = apiExecutor.execute(param);
            lst.add(result);
            lst.add(DateUtils2.currDay());
            System.out.println(JSONObject.toJSONString(lst));
            return lst;
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
            lst.add(e.getErrorCode());
            lst.add(e.getErrorMessage());
            return lst;
        }
    }


    /**
     * @Author 苏俊杰
     * @Description //TODO 安卓周活跃度
     * @Date 16:43 2019/3/26
     * @Param [apiExecutor]
     * @return void
     **/
    public static String  umengAndrienUappGetActiveUsers() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetActiveUsersParam param = new UmengUappGetActiveUsersParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate(DateUtils2.getSevenDay());
        param.setEndDate(DateUtils2.befoDay());
        param.setPeriodType("daily");

        try {
            UmengUappGetActiveUsersResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSON(result).toString());
            return JSONObject.toJSON(result).toString();
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
        return "";
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO IOS周活跃度
     * @Date 16:43 2019/3/26
     * @Param [apiExecutor]
     * @return void
     **/
    public static String  umengIosUappGetActiveUsers() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetActiveUsersParam param = new UmengUappGetActiveUsersParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate(DateUtils2.getSevenDay());
        param.setEndDate(DateUtils2.befoDay());
        param.setPeriodType("daily");
        try {
            UmengUappGetActiveUsersResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
        return "";
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 安卓月活跃度
     * @Date 16:43 2019/3/26
     * @Param [apiExecutor]
     * @return void
     **/
    public static String umengAndrienDDUappGetActiveUsers() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetActiveUsersParam param = new UmengUappGetActiveUsersParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate(DateUtils2.getBeGinDaYoFMoth());
        param.setEndDate(DateUtils2.befoDay());
        param.setPeriodType("daily");
        try {
            UmengUappGetActiveUsersResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
        return "";
    }
    /**
     * @Author 苏俊杰
     * @Description //TODO IOS月活跃度
     * @Date 16:43 2019/3/26
     * @Param [apiExecutor]
     * @return void
     **/
    public static String umengIOSDDUappGetActiveUsers() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetActiveUsersParam param = new UmengUappGetActiveUsersParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate(DateUtils2.getBeGinDaYoFMoth());
        param.setEndDate(DateUtils2.befoDay());
        param.setPeriodType("daily");
        try {
            UmengUappGetActiveUsersResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
        return "";
    }
    /**
     * @Author 苏俊杰
     * @Description //TODO 安卓今日新增用户
     * @Date 19:14 2019/3/26
     * @Param [args]
     * @return void
     **/
    public static String umengAndrienUappGetNewUsers() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetNewUsersParam param = new UmengUappGetNewUsersParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate(DateUtils2.currDay());
        param.setEndDate(DateUtils2.currDay());
        param.setPeriodType("daily");
        try {
            UmengUappGetNewUsersResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
        return "";
    }
    /**
     * @Author 苏俊杰
     * @Description //TODO 苹果今日新增用户
     * @Date 19:14 2019/3/26
     * @Param [args]
     * @return void
     **/
    public static String umengIosUappGetNewUsers() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetNewUsersParam param = new UmengUappGetNewUsersParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate(DateUtils2.currDay());
        param.setEndDate(DateUtils2.currDay());
        param.setPeriodType("daily");
        try {
            UmengUappGetNewUsersResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
        return "";
    }
    /**
     * @Author 苏俊杰
     * @Description //TODO 安卓七日新增用户
     * @Date 19:14 2019/3/26
     * @Param [args]
     * @return void
     **/
    public static String umengSevenDayAndrienUappGetNewUsers() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetNewUsersParam param = new UmengUappGetNewUsersParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate(DateUtils2.getSevenDay());
        param.setEndDate(DateUtils2.befoDay());
        param.setPeriodType("daily");
        try {
            UmengUappGetNewUsersResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
        return "";
    }
    /**
     * @Author 苏俊杰
     * @Description //TODO Ios七日新增用户
     * @Date 19:14 2019/3/26
     * @Param [args]
     * @return void
     **/
    public static String umengSevenDayIOSUappGetNewUsers() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetNewUsersParam param = new UmengUappGetNewUsersParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate(DateUtils2.getSevenDay());
        param.setEndDate(DateUtils2.befoDay());
        param.setPeriodType("daily");
        try {
            UmengUappGetNewUsersResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
        return "";
    }
    /**
     * @Author 苏俊杰
     * @Description //TODO 安卓3日留存
     * @Date 19:26 2019/3/26
     * @Param [args]
     * @return void
     **/
    public static String umengAndrienUappGetRetentions() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetRetentionsParam param = new UmengUappGetRetentionsParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate(DateUtils2.ThreeDay());
        param.setEndDate(DateUtils2.befoDay());
        param.setPeriodType("daily");
        try {
            UmengUappGetRetentionsResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }return "";
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 苹果3日留存
     * @Date 19:26 2019/3/26
     * @Param [args]
     * @return void
     **/
    public static String umengIosUappGetRetentions() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetRetentionsParam param = new UmengUappGetRetentionsParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate(DateUtils2.ThreeDay());
        param.setEndDate(DateUtils2.befoDay());
        param.setPeriodType("daily");


        try {
            UmengUappGetRetentionsResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }return "";
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 安卓7日留存
     * @Date 19:26 2019/3/26
     * @Param [args]
     * @return void
     **/
    public static String umengSevenDayAndrienUappGetRetentions() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetRetentionsParam param = new UmengUappGetRetentionsParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate(DateUtils2.getSevenDay());
        param.setEndDate(DateUtils2.befoDay());
        param.setPeriodType("daily");
        try {
            UmengUappGetRetentionsResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }return "";
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO Ios7日留存
     * @Date 19:26 2019/3/26
     * @Param [args]
     * @return void
     **/
    public static String umengSevenDayIosUappGetRetentions() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        UmengUappGetRetentionsParam param = new UmengUappGetRetentionsParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate(DateUtils2.getSevenDay());
        param.setEndDate(DateUtils2.befoDay());
        param.setPeriodType("daily");
        try {
            UmengUappGetRetentionsResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
            return JSONObject.toJSONString(result);
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }return "";
    }

    //获取安卓总pv参数值事件列表 从运营时间开始
    public static   List umengAndroidPvEventParamGetValueList2() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        List lst=new ArrayList();
        UmengUappEventParamGetValueListParam param = new UmengUappEventParamGetValueListParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate("2019-04-09");
        param.setEndDate(DateUtils2.currDay());
        param.setEventName("id_goodspv");
        param.setEventParamName("goods_id");
        try {
            UmengUappEventParamGetValueListResult result = apiExecutor.execute(param);
            lst.add(result);
            lst.add(DateUtils2.currDay());
            System.out.println(JSONObject.toJSONString(lst));
            return lst;
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
            lst.add(e.getErrorCode());
            lst.add(e.getErrorMessage());
            return lst;
        }
    }

    //获取安卓总uv参数值事件列表 从运营时间开始
    public static List umengAndroidEventParamGetValueList2() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        List lst=new ArrayList();
        UmengUappEventParamGetValueListParam param = new UmengUappEventParamGetValueListParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate("2019-04-09");
        param.setEndDate(DateUtils2.currDay());
        param.setEventName("id_goodsuv");
        param.setEventParamName("goods_id");
        try {
            UmengUappEventParamGetValueListResult result = apiExecutor.execute(param);
            lst.add(result);
            lst.add(DateUtils2.currDay());
            System.out.println(JSONObject.toJSONString(lst));
            return lst;
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
            lst.add(e.getErrorCode());
            lst.add(e.getErrorMessage());
            return lst;
        }
    }

    //获取苹果总pv参数值事件列表 从运营时间开始
    public static List umengIosPvEventParamGetValueList2() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        List lst=new ArrayList();
        UmengUappEventParamGetValueListParam param = new UmengUappEventParamGetValueListParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate("2019-04-09");
        param.setEndDate(DateUtils2.currDay());
        param.setEventName("id_goodspv");
        param.setEventParamName("goods_id");
        try {
            UmengUappEventParamGetValueListResult result = apiExecutor.execute(param);
            lst.add(result);
            lst.add(DateUtils2.currDay());
            System.out.println(JSONObject.toJSONString(lst));
            return lst;
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
            lst.add(e.getErrorCode());
            lst.add(e.getErrorMessage());
            return lst;
        }
    }

    //获取苹果总uv参数值事件列表 从运营时间开始
    public static List umengIosEventParamGetValueList2() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        List lst=new ArrayList();
        UmengUappEventParamGetValueListParam param = new UmengUappEventParamGetValueListParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiIosAppkey);
        param.setStartDate("2019-04-09");
        param.setEndDate(DateUtils2.currDay());
        param.setEventName("id_goodsuv");
        param.setEventParamName("goods_id");
        try {
            UmengUappEventParamGetValueListResult result = apiExecutor.execute(param);
            lst.add(result);
            lst.add(DateUtils2.currDay());
            System.out.println(JSONObject.toJSONString(lst));
            return lst;
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
            lst.add(e.getErrorCode());
            lst.add(e.getErrorMessage());
            return lst;
        }
    }

    public static void main(String[] args) {
//        String Andrien=OpenAPI.umengAndrienUappGetActiveUsers();//安卓周活跃
//         String ios=OpenAPI.umengIosUappGetActiveUsers();//苹果周活跃
//                OpenAPI.umengAndrienDDUappGetActiveUsers();//安卓月活跃
//            OpenAPI.umengIOSDDUappGetActiveUsers(); //苹果月活跃
//            OpenAPI.umengSevenDayAndrienUappGetNewUsers();//安卓周新增
//            OpenAPI.umengSevenDayIOSUappGetNewUsers();//苹果周新增
//            OpenAPI.umengAndrienUappGetNewUsers();//安卓今日新增;
//            OpenAPI.umengIosUappGetNewUsers();//苹果今日新增;
//            OpenAPI.umengAndrienUappGetRetentions();//安卓3日留存
//            OpenAPI.umengIosUappGetRetentions();//苹果3日留存
//            OpenAPI.umengSevenDayAndrienUappGetRetentions();//安卓7日留存
//            OpenAPI.umengSevenDayIosUappGetRetentions();//苹果7日留存
       umengAndroidEventParamGetValueList2();
        //苹果胡uv
        umengIosEventParamGetValueList2();

    }

}
