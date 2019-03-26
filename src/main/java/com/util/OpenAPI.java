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
    //安卓总的点击量ov
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
    public static List umengAndroidPvEventParamGetValueList() {
        ApiExecutor apiExecutor=new ApiExecutor(apiKey,apiSecurity);
        apiExecutor.setServerHost(ServerHost);
        List lst=new ArrayList();
        UmengUappEventParamGetValueListParam param = new UmengUappEventParamGetValueListParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey(YuerfeiAndroid);
        param.setStartDate(DateUtils2.befoDay());
        param.setEndDate(DateUtils2.befoDay());
        param.setEventName("id_goodspv");
        param.setEventParamName("goods_id");
        try {
            UmengUappEventParamGetValueListResult result = apiExecutor.execute(param);
            lst.add(result);
            lst.add(DateUtils2.befoDay());
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




    public static void main(String[] args) {
//
//        //得到Android pv
//        JSONObject obj = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengAndroidPvEventParamGetValueList().get(0)));
//        obj.get("paramInfos");
//        JSONArray.parseArray( JSON.toJSONString(obj.get("paramInfos")));
//        System.out.println( ( JSON.toJSONString(obj.get("paramInfos"))));
//        List<Goodspvdata> android =new ArrayList<>() ;
//        int weeked=DateUtil.getWeeked();
//        //得到Android pv 的集合
//        for (Object i: JSONArray.parseArray( JSON.toJSONString(obj.get("paramInfos")))){
//            JSONObject  j=  JSONObject.parseObject(JSON.toJSONString(i));
//            Goodspvdata goodspvdata=new Goodspvdata();
//
//
//            goodspvdata.setGoodid(Integer.parseInt(j.get("name").toString()));
//if (weeked==2){
//    goodspvdata.setPone((Integer) j.get("count"));
//}else if(weeked==3){
//    goodspvdata.setPtwo((Integer) j.get("count"));
//}
//else if(weeked==4){
//    goodspvdata.setPthree((Integer) j.get("count"));
//}
//else if(weeked==5){
//    goodspvdata.setPfour((Integer) j.get("count"));
//}
//else if(weeked==6){
//    goodspvdata.setPfive((Integer) j.get("count"));
//}
//else if(weeked==7){
//    goodspvdata.setPsat((Integer) j.get("count"));
//}else if(weeked==1){
//    goodspvdata.setPsunday((Integer) j.get("count"));
//}
//            System.out.println(goodspvdata.toString());
//            android.add(goodspvdata);
//        }
//
//
//
//        //Ios pv
//        JSONObject iosPv = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengAndroidPvEventParamGetValueList().get(0)));
//        iosPv.get("paramInfos");
//        JSONArray.parseArray( JSON.toJSONString(iosPv.get("paramInfos")));
//        System.out.println( ( JSON.toJSONString(iosPv.get("paramInfos"))));
//        List<Goodspvdata> ios =new ArrayList<>() ;
//
//        for (Object io: JSONArray.parseArray( JSON.toJSONString(iosPv.get("paramInfos")))){
//
//            JSONObject  j=  JSONObject.parseObject(JSON.toJSONString(io));
//            Goodspvdata goodspvdata=new Goodspvdata();
//            goodspvdata.setGoodid(Integer.parseInt(j.get("name").toString()));
//            if (weeked==2){
//                goodspvdata.setPone((Integer) j.get("count"));
//            }else if(weeked==3){
//                goodspvdata.setPtwo((Integer) j.get("count"));
//            }
//            else if(weeked==4){
//                goodspvdata.setPthree((Integer) j.get("count"));
//            }
//            else if(weeked==5){
//                goodspvdata.setPfour((Integer) j.get("count"));
//            }
//            else if(weeked==6){
//                goodspvdata.setPfive((Integer) j.get("count"));
//            }
//            else if(weeked==7){
//                goodspvdata.setPsat((Integer) j.get("count"));
//            }else if(weeked==1){
//                goodspvdata.setPsunday((Integer) j.get("count"));
//            }
//            System.out.println("ios---"+goodspvdata.toString());
//            ios.add(goodspvdata);
//
//        }
//
//
////合并去重
//        //得到总的
//        List<Goodspvdata> uvpv;
//        android.addAll(ios);
//        Set<Goodspvdata> s = new TreeSet<Goodspvdata>(new Comparator<Goodspvdata>() {
//
//            @Override
//            public int compare(Goodspvdata o1, Goodspvdata o2) {
//                return o1.getGoodid().compareTo(o2.getGoodid());
//            }
//        });
//        s.addAll(ios);
//        uvpv= new ArrayList<Goodspvdata>(s);
//
//
//
//        //两个list对象当id相等的时候进行属性值相加,两边没有相同id的时候保存这个对象
//
//        android.addAll(ios);
//        for (Goodspvdata  Android:uvpv){
//
//            Android.getGoodid();
//            for (Goodspvdata Ios: ios){
//                if(Android.getGoodid()==Ios.getGoodid()){
//                    if (weeked==2){
//                        Android.setPone(( Ios.getPone()+Android.getPone()));
//                    }else if(weeked==3){
//                        System.out.println( Ios.getPtwo()+"--"+Android.getPtwo());
//                        Android.setPtwo(( Ios.getPtwo()+Android.getPtwo()));
//                    }
//                    else if(weeked==4){
//                        Android.setPthree(( Ios.getPthree()+Android.getPthree()));
//                    }
//                    else if(weeked==5){
//                        Android.setPfour(( Ios.getPfour()+Android.getPfour()));
//                    }
//                    else if(weeked==6){
//                        Android.setPfive(( Ios.getPfive()+Android.getPfive()));
//                    }
//                    else if(weeked==7){
//                        Android.setPsat(( Ios.getPsat()+Android.getPsat()));
//
//                    }else if(weeked==1){
//                        Android.setPsunday(( Ios.getPsunday()+Android.getPsunday()));
//
//                    }
//
//
//
//                }else {
//                    //如果他的id第一个不匹配，后面的匹配怎么进行判断
//
//                }
//            }
//
//
//
//        }
//        System.out.println("去重-----------------"+uvpv.toString());
//
//
//   OpenAPI.umengAndroidEventGetData();
//
//        OpenAPI.umengAndroidUvEventGetData();
OpenAPI.umengAndroidPvEventParamGetValueList();



    }

}
