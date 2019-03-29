package com.springmvc.service;

import com.sun.deploy.net.URLEncoder;
import com.util.Https.HttpUtils;
import net.sf.json.JSONObject;
import us.codecraft.webmagic.selector.Json;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendTimer {
    final static String Url="https://12i.cn/api.ashx";
    //?
    final static String userId="3100";
    final static String key="3E457CECE7CD995CD2672DC76D876EC0";
    //final static String format="visitor";

    private static String charset = "utf-8";

    public static Map Totalpvuv(String ListUrl,String format){
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("format",format);
        createMap.put("userId",userId);
        createMap.put("key",key);
        createMap.put("url",ListUrl);
        String i=HttpUtils.doPost(Url,createMap,charset);
        Map map=new HashMap();
        try {
            JSONObject jsonData = JSONObject.fromObject(i);
            String success=jsonData.get("success").toString();
            if(success=="ok"||success.equals("ok")){
                String uv = jsonData.get("uv").toString();
                String pv =  jsonData.get("pv").toString();
                map.put("success",success);
                map.put("uv",uv);
                map.put("pv",pv);
                System.out.println("运行成功");
                return map;
            }else {
                System.out.println("拿取参数异常");
            }
        }catch (NullPointerException e){
            System.out.println("出现异常");
        }
        System.out.println("运行异常！");
        map.put("error","运行异常");
        return map;
    }


    public static JSONObject DatePvUv(String ListUrl, String format){
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("format",format);
        createMap.put("userId",userId);
        createMap.put("key",key);
        createMap.put("url",ListUrl);
        String i=HttpUtils.doPost(Url,createMap,charset);
        Map map=new HashMap();
        JSONObject jsonData = JSONObject.fromObject(i);
        return jsonData;
    }

    public static void main(String[] args) {
//        String ListUrl="https://12i.cn/00rjTy";
//        Map<String,String> createMap = new HashMap<String,String>();
//        createMap.put("format",format);
//        createMap.put("userId",userId);
//        createMap.put("key",key);
//        createMap.put("url",ListUrl);
//        String i=HttpUtils.doPost(Url,createMap,charset);
//        Map map=new HashMap();
//        try {
//            JSONObject jsonData = JSONObject.fromObject(i);
//            String success=(String) jsonData.get("success");
//            if(success=="ok"||success.equals("ok")){
//                String uv = jsonData.get("uv").toString();
//                String pv = jsonData.get("pv").toString();
//                System.out.println("uv的值"+uv);
//                System.out.println("pv的值"+pv);
//                int ux=Integer.parseInt(uv);
//                System.out.println("Intege的uv值是："+ux);
//                map.put("success",success);
//                map.put("uv",uv);
//                map.put("pv",pv);
//
//            }else {
//                System.out.println("拿取参数异常");
//            }
//        }catch (NullPointerException e){
//            System.out.println("出现异常");
//        }
//        System.out.println("运行异常！");
//        map.put("error","运行异常");

    }

}
