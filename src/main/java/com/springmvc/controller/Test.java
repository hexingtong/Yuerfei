package com.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springmvc.pojo.Fund;
import com.springmvc.pojo.GoodsMonthLiucun;
import com.springmvc.pojo.Goodspvdata;
import com.springmvc.pojo.Person;
import com.springmvc.service.FundService;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.util.DateUtil;
import com.util.MysqlUtils;
import com.util.OpenAPI;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


public class Test {
    final static String Url="https://12i.cn/api.ashx";
    //?
    final static String userId="3100";
    final static String key="3E457CECE7CD995CD2672DC76D876EC0";
    //final static String format="visitor";

    private static String charset = "utf-8";




    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);
//        String utilDates=DateUtil.getNowDate();
//        Date date=DateUtil.stringToDate(utilDates);
//        System.out.println("获取的Date时间"+DateUtil.getNowDate());
//        System.out.println("yyyyMMddHHmmss");
//        System.out.println("Date转换后的时间"+date);

//        Jedis jedis =new Jedis("47.92.53.177",6379);
//         String id="12";
//        String token = TokenTest.TokenTest(id);

////        TokenTest.ValidToken(token);
//
//        jedis.set("token"+id+"",token);
//
//        jedis.get("token"+id+"");
//        jedis.pexpire("token",30000);
        //String ken=jedis.get("token"+id,);
//        System.out.println("ken的值是:"+ken);
//        if(ken==null||ken.equals("")){
//            System.out.printf(ken);
//        }
//        System.out.printf("null");
//
//

//                String id="13";
//                String token = TokenTest.TokenTest(id);
//                TokenTest.ValidToken(token);
//        Map map=new HashMap();
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI0MyIsInN0YSI6MTU1MjM3NDQzODU0NSwiZXhwIjoxNTUzNjcwNDM4NTQ1fQ.DtwhMMxsGaMshwiQ8IyrUTPKPJJHtI0P9KCwAT1FHD8";
//        TokenTest.ValidToken(token);
//        Jedis jedis = new Jedis("47.92.53.177", 6379);
//        SmsPhone.setNewcode();
//        String code=Integer.toString(SmsPhone.getNewcode());
//        System.out.println("验证码:"+code);
//        String Phone="13022061303";
//        jedis.set("SmsCode" + Phone + "", code);
////        //设置时间为毫秒
//        jedis.pexpire("SmsCode" + Phone + "", 60000);
//        String z="SmsCode"+Phone;
//        String x=jedis.get(z);
//        logger.info("z里面的值:"+z);
//        logger.info("redis里的验证码为："+x);

//        String i= DateUtils2.dateToString(DateUtils3.getBeginDayOfLastWeek(),"yyyy-MM-dd");
//        System.out.println("转换后的上周开始时间是："+i);
//        String t=DateUtils2.dateToString(DateUtils3.getEndDayOfLastWeek(),"yyyy-MM-dd");
//        System.out.println("转换后的上周结束时间是："+t);

//        String i=DateUtils2.dateToString(DateUtils3.getBeginDayOfLastMonth(),"yyyy-MM-dd");
//        System.out.println("转换后的上月开始时间是："+i);
//        String z=DateUtils2.dateToString(DateUtils3.getEndDayOfLastMonth(),"yyyy-MM-dd");
//        System.out.println("转换后的上月结束时间是："+z);
//         Map<String,String> createMap = new HashMap<String,String>();
//        String format = "day";
//        String ListUrl="https://12i.cn/00jShZ";
//        createMap.put("format",format);
//        createMap.put("userId",userId);
//        createMap.put("key",key);
//        createMap.put("url",ListUrl);
//        System.out.println("进入这里");
//        String Dates= HttpUtils.doPost(Url,createMap,charset);
//        Map map=new HashMap();
//        //将jsonArray字符串转化为JSONArray
//        JSONArray jsonArray = JSONArray.fromObject(Dates);
//        List<?> list2 = JSONArray.toList(jsonArray, new Person(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
//        System.out.println("list2的大小"+list2.size());
//        Person[] person=new Person[list2.size()];
//        for (int i=0;i<list2.size();i++) {
//            person[i] = (Person) list2.get(i);
//            System.out.println(person[i].getDay());
//            System.out.println(person[i].getId());
//            System.out.println(person[i].getUv());
////            System.out.println(person[i].getVisitCount());
//        JSONObject obj = JSONObject.parseObject(OpenAPI.umengAndrienDDUappGetActiveUsers());
//        obj.get("activeUserInfo");
//        JSONObject obj1 = JSONObject.parseObject(OpenAPI.umengIOSDDUappGetActiveUsers());
//        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(JSONArray.parseArray( JSON.toJSONString(obj1.get("activeUserInfo"))));
//        net.sf.json.JSONArray jsonArray1 = net.sf.json.JSONArray.fromObject(JSONArray.parseArray(  JSON.toJSONString(obj.get("activeUserInfo"))));
//        List<?> list = net.sf.json.JSONArray.toList(jsonArray, new GoodsMonthLiucun(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
//        List<?> list2 = net.sf.json.JSONArray.toList(jsonArray1, new GoodsMonthLiucun(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
//        GoodsMonthLiucun[] goodsMonthLiucuns1=new GoodsMonthLiucun[list2.size()];
//        GoodsMonthLiucun[] goodsMonthLiucuns2=new GoodsMonthLiucun[list2.size()];
//        List<GoodsMonthLiucun> yuehuo =new ArrayList<>() ;
//        for (int i=0;i<list.size();i++){
//            goodsMonthLiucuns1[i]=(GoodsMonthLiucun)list.get(i);
//            goodsMonthLiucuns2[i]=(GoodsMonthLiucun)list2.get(i);
//            if(goodsMonthLiucuns1[i].getDate().equals(goodsMonthLiucuns2[i].getDate())){
//                goodsMonthLiucuns1[i].setValue(goodsMonthLiucuns1[i].getValue()+goodsMonthLiucuns2[i].getValue());
//            }
//            System.out.println("总数据"+goodsMonthLiucuns1[i].getDate()+"--"+goodsMonthLiucuns1[i].getValue());
//            yuehuo.add(goodsMonthLiucuns1[i]);
//        }

//        JSONObject obj = JSONObject.parseObject(OpenAPI.umengSevenDayAndrienUappGetRetentions());
//        obj.get("retentionInfo");
//        JSONObject obj1 = JSONObject.parseObject(OpenAPI.umengSevenDayIosUappGetRetentions());
//        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(JSONArray.parseArray( JSON.toJSONString(obj1.get("retentionInfo"))));
//        net.sf.json.JSONArray jsonArray1 = net.sf.json.JSONArray.fromObject(JSONArray.parseArray(  JSON.toJSONString(obj.get("retentionInfo"))));
//        List<?> list = net.sf.json.JSONArray.toList(jsonArray, new GoodsMonthLiucun(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
//        List<?> list2 = net.sf.json.JSONArray.toList(jsonArray1, new GoodsMonthLiucun(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
//        GoodsMonthLiucun[] goodsMonthLiucuns1=new GoodsMonthLiucun[list.size()];
//        GoodsMonthLiucun[] goodsMonthLiucuns2=new GoodsMonthLiucun[list2.size()];
//        List<GoodsMonthLiucun> Threeliucun =new ArrayList<>() ;
//        for (int i=0;i<list.size();i++){
//            goodsMonthLiucuns1[i]=(GoodsMonthLiucun)list.get(i);
//            goodsMonthLiucuns2[i]=(GoodsMonthLiucun)list2.get(i);
//            if(goodsMonthLiucuns1[i].getDate().equals(goodsMonthLiucuns2[i].getDate())){
//                goodsMonthLiucuns1[i].setTotalInstallUser(goodsMonthLiucuns1[i].getTotalInstallUser()+goodsMonthLiucuns2[i].getTotalInstallUser());
//            }
//            System.out.println("Ios的数据是"+goodsMonthLiucuns2[i].getDate()+"---"+goodsMonthLiucuns2[i].getTotalInstallUser());
//            System.out.println("总数据"+goodsMonthLiucuns1[i].getDate()+"--"+goodsMonthLiucuns1[i].getTotalInstallUser());
//            Threeliucun.add(goodsMonthLiucuns1[i]);
//        }

    }



}
