package com.springmvc.service;

import com.springmvc.pojo.Person;
import com.util.Https.HttpUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendTimer {
    final static String format="txt";
    final static String Url="https://12i.cn/api.ashx";
    //?
    final static String userId="3100";
    final static String key="C11169DBDADC37FC19260F150F2287C3";

    private static String charset = "utf-8";

    public static Map Totalpvuv(String ListUrl,String format){
        Map createMap = new HashMap<String,String>();
        createMap.put("format",format);
        createMap.put("userId",userId);
        createMap.put("key",key);
        createMap.put("url",ListUrl);
        String i= HttpUtil.doPostSSL(Url,createMap,null);
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


    public static Person[] DatePvUv(String ListUrl, String format){
        Map createMap = new HashMap<String,String>();
        createMap.put("format",format);
        createMap.put("userId",userId);
        createMap.put("key",key);
        createMap.put("url",ListUrl);
        String Dates=HttpUtil.doPostSSL(Url,createMap,null);
        Map map=new HashMap();
        //将jsonArray字符串转化为JSONArray
        JSONArray jsonArray = JSONArray.fromObject(Dates);
        List<?> list2 = JSONArray.toList(jsonArray, new Person(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
        Person[] person=new Person[list2.size()];
        for (int i=0;i<list2.size();i++) {
            person[i] = (Person) list2.get(i);
            System.out.println(person[i].getDay());
            System.out.println(person[i].getId());
            System.out.println(person[i].getUv());
            System.out.println(person[i].getVisitCount());
        }
        return person;
    }

    public static void main(String[] args) {

    }

}
