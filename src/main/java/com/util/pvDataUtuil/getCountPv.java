package com.util.pvDataUtuil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springmvc.pojo.GoodsMonthLiucun;
import com.springmvc.pojo.Goodspvdata;
import com.springmvc.pojo.Person;
import com.util.DateUtil;
import com.util.OpenAPI;
import net.sf.json.JsonConfig;

import java.util.*;

/**
 * @ClassName getCountPv
 * @Description:
 * @Author by
 * @Date: 2019/3/26 14:39
 **/
public class getCountPv {


    public static List getPv(){

        //得到Android pv
        JSONObject obj = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengAndroidPvEventParamGetValueList().get(0)));
        obj.get("paramInfos");
        JSONArray.parseArray( JSON.toJSONString(obj.get("paramInfos")));
        System.out.println( ( JSON.toJSONString(obj.get("paramInfos"))));
        List<Goodspvdata> android =new ArrayList<>() ;
        int weeked= DateUtil.getWeeked();
        //得到Android pv 的集合
        for (Object i: JSONArray.parseArray( JSON.toJSONString(obj.get("paramInfos")))){
            JSONObject  j=  JSONObject.parseObject(JSON.toJSONString(i));
            Goodspvdata goodspvdata=new Goodspvdata();


            goodspvdata.setGoodid(Integer.parseInt(j.get("name").toString()));
            if (weeked==2){
                goodspvdata.setPone((Integer) j.get("count"));
            }else if(weeked==3){
                goodspvdata.setPtwo((Integer) j.get("count"));
            }
            else if(weeked==4){
                goodspvdata.setPthree((Integer) j.get("count"));
            }
            else if(weeked==5){
                goodspvdata.setPfour((Integer) j.get("count"));
            }
            else if(weeked==6){
                goodspvdata.setPfive((Integer) j.get("count"));
            }
            else if(weeked==7){
                goodspvdata.setPsat((Integer) j.get("count"));
            }else if(weeked==1){
                goodspvdata.setPsunday((Integer) j.get("count"));
            }
            System.out.println(goodspvdata.toString());
            android.add(goodspvdata);
        }



        //Ios pv
        JSONObject iosPv = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengAndroidPvEventParamGetValueList().get(0)));
        iosPv.get("paramInfos");
        JSONArray.parseArray( JSON.toJSONString(iosPv.get("paramInfos")));
        System.out.println( ( JSON.toJSONString(iosPv.get("paramInfos"))));
        List<Goodspvdata> ios =new ArrayList<>() ;

        for (Object io: JSONArray.parseArray( JSON.toJSONString(iosPv.get("paramInfos")))){

            JSONObject  j=  JSONObject.parseObject(JSON.toJSONString(io));
            Goodspvdata goodspvdata=new Goodspvdata();
            goodspvdata.setGoodid(Integer.parseInt(j.get("name").toString()));
            if (weeked==2){
                goodspvdata.setPone((Integer) j.get("count"));
            }else if(weeked==3){
                goodspvdata.setPtwo((Integer) j.get("count"));
            }
            else if(weeked==4){
                goodspvdata.setPthree((Integer) j.get("count"));
            }
            else if(weeked==5){
                goodspvdata.setPfour((Integer) j.get("count"));
            }
            else if(weeked==6){
                goodspvdata.setPfive((Integer) j.get("count"));
            }
            else if(weeked==7){
                goodspvdata.setPsat((Integer) j.get("count"));
            }else if(weeked==1){
                goodspvdata.setPsunday((Integer) j.get("count"));
            }
            System.out.println("ios---"+goodspvdata.toString());
            ios.add(goodspvdata);

        }


//合并去重
        //得到总的
        List<Goodspvdata> uvpv;
        android.addAll(ios);
        Set<Goodspvdata> s = new TreeSet<Goodspvdata>(new Comparator<Goodspvdata>() {

            @Override
            public int compare(Goodspvdata o1, Goodspvdata o2) {
                return o1.getGoodid().compareTo(o2.getGoodid());
            }
        });
        s.addAll(ios);
        uvpv= new ArrayList<Goodspvdata>(s);



        //两个list对象当id相等的时候进行属性值相加,两边没有相同id的时候保存这个对象

        android.addAll(ios);
        for (Goodspvdata  Android:uvpv){

            Android.getGoodid();
            for (Goodspvdata Ios: ios){
                if(Android.getGoodid()==Ios.getGoodid()){
                    if (weeked==2){
                        Android.setPone(( Ios.getPone()+Android.getPone()));
                    }else if(weeked==3){
                        System.out.println( Ios.getPtwo()+"--"+Android.getPtwo());
                        Android.setPtwo(( Ios.getPtwo()+Android.getPtwo()));
                    }
                    else if(weeked==4){
                        Android.setPthree(( Ios.getPthree()+Android.getPthree()));
                    }
                    else if(weeked==5){
                        Android.setPfour(( Ios.getPfour()+Android.getPfour()));
                    }
                    else if(weeked==6){
                        Android.setPfive(( Ios.getPfive()+Android.getPfive()));
                    }
                    else if(weeked==7){
                        Android.setPsat(( Ios.getPsat()+Android.getPsat()));

                    }else if(weeked==1){
                        Android.setPsunday(( Ios.getPsunday()+Android.getPsunday()));

                    }



                }else {
                    //如果他的id第一个不匹配，后面的匹配怎么进行判断

                }
            }



        }
        System.out.println("去重-----------------"+uvpv.toString());




        return uvpv;
    }
/**
 * Description： 得到每天的pvuv
 * @author boyang
 * @date 2019/3/26 16:22
 * @param
 * @return
 */

public static List getDatePvUv(){

    return null;
}

/**
 * Description：得到所有的月活，周活
 * @author su
 * @date 2019/3/26 16:23
 * @param
 * @return
 */
    public static List getMonthActive(){
        JSONObject obj = JSONObject.parseObject(OpenAPI.umengAndrienDDUappGetActiveUsers());
        obj.get("activeUserInfo");
        JSONObject obj1 = JSONObject.parseObject(OpenAPI.umengIOSDDUappGetActiveUsers());
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(JSONArray.parseArray( JSON.toJSONString(obj1.get("activeUserInfo"))));
        net.sf.json.JSONArray jsonArray1 = net.sf.json.JSONArray.fromObject(JSONArray.parseArray(  JSON.toJSONString(obj.get("activeUserInfo"))));
        List<?> list = net.sf.json.JSONArray.toList(jsonArray, new GoodsMonthLiucun(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
        List<?> list2 = net.sf.json.JSONArray.toList(jsonArray1, new GoodsMonthLiucun(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
        GoodsMonthLiucun[] goodsMonthLiucuns1=new GoodsMonthLiucun[list2.size()];
        GoodsMonthLiucun[] goodsMonthLiucuns2=new GoodsMonthLiucun[list2.size()];
        List<GoodsMonthLiucun> yuehuo =new ArrayList<>() ;
        for (int i=0;i<list.size();i++){
            goodsMonthLiucuns1[i]=(GoodsMonthLiucun)list.get(i);
            goodsMonthLiucuns2[i]=(GoodsMonthLiucun)list2.get(i);
            if(goodsMonthLiucuns1[i].getDate().equals(goodsMonthLiucuns2[i].getDate())){
                goodsMonthLiucuns1[i].setValue(goodsMonthLiucuns1[i].getValue()+goodsMonthLiucuns2[i].getValue());
            }
            System.out.println("总数据"+goodsMonthLiucuns1[i].getDate()+"--"+goodsMonthLiucuns1[i].getValue());
            yuehuo.add(goodsMonthLiucuns1[i]);
        }
        return yuehuo;
    }



/**
 * Description：得到新增用户
 * @author boyang
 * @date 2019/3/26 16:24
 * @param
 * @return
 */

/**
 * Description：用户总的3日留存
 * @author su
 * @date 2019/3/26 16:25
 * @param
 * @return
 */
    public static List getThreeGetRetentions(){
        JSONObject obj = JSONObject.parseObject(OpenAPI.umengAndrienUappGetRetentions());
        obj.get("retentionInfo");
        JSONObject obj1 = JSONObject.parseObject(OpenAPI.umengIosUappGetRetentions());
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(JSONArray.parseArray( JSON.toJSONString(obj1.get("retentionInfo"))));
        net.sf.json.JSONArray jsonArray1 = net.sf.json.JSONArray.fromObject(JSONArray.parseArray(  JSON.toJSONString(obj.get("retentionInfo"))));
        List<?> list = net.sf.json.JSONArray.toList(jsonArray, new GoodsMonthLiucun(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
        List<?> list2 = net.sf.json.JSONArray.toList(jsonArray1, new GoodsMonthLiucun(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
        GoodsMonthLiucun[] goodsMonthLiucuns1=new GoodsMonthLiucun[list.size()];
        GoodsMonthLiucun[] goodsMonthLiucuns2=new GoodsMonthLiucun[list2.size()];
        List<GoodsMonthLiucun> Threeliucun =new ArrayList<>() ;
        for (int i=0;i<list.size();i++){
            goodsMonthLiucuns1[i]=(GoodsMonthLiucun)list.get(i);
            goodsMonthLiucuns2[i]=(GoodsMonthLiucun)list2.get(i);
            if(goodsMonthLiucuns1[i].getDate().equals(goodsMonthLiucuns2[i].getDate())){
                goodsMonthLiucuns1[i].setTotalInstallUser(goodsMonthLiucuns1[i].getTotalInstallUser()+goodsMonthLiucuns2[i].getTotalInstallUser());
            }
            System.out.println("Ios的数据是"+goodsMonthLiucuns2[i].getDate()+"---"+goodsMonthLiucuns2[i].getTotalInstallUser());
            System.out.println("总数据"+goodsMonthLiucuns1[i].getDate()+"--"+goodsMonthLiucuns1[i].getTotalInstallUser());
            Threeliucun.add(goodsMonthLiucuns1[i]);
        }
        return Threeliucun;
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 用户的7日留存
     * @Date 10:00 2019/3/28
     * @Param
     * @return
     **/
    public static List getSevenGetRetentions(){
        JSONObject obj = JSONObject.parseObject(OpenAPI.umengSevenDayAndrienUappGetRetentions());
        obj.get("retentionInfo");
        JSONObject obj1 = JSONObject.parseObject(OpenAPI.umengSevenDayIosUappGetRetentions());
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(JSONArray.parseArray( JSON.toJSONString(obj1.get("retentionInfo"))));
        net.sf.json.JSONArray jsonArray1 = net.sf.json.JSONArray.fromObject(JSONArray.parseArray(  JSON.toJSONString(obj.get("retentionInfo"))));
        List<?> list = net.sf.json.JSONArray.toList(jsonArray, new GoodsMonthLiucun(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
        List<?> list2 = net.sf.json.JSONArray.toList(jsonArray1, new GoodsMonthLiucun(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
        GoodsMonthLiucun[] goodsMonthLiucuns1=new GoodsMonthLiucun[list.size()];
        GoodsMonthLiucun[] goodsMonthLiucuns2=new GoodsMonthLiucun[list2.size()];
        List<GoodsMonthLiucun> Sevenliucun =new ArrayList<>() ;
        for (int i=0;i<list.size();i++){
            goodsMonthLiucuns1[i]=(GoodsMonthLiucun)list.get(i);
            goodsMonthLiucuns2[i]=(GoodsMonthLiucun)list2.get(i);
            if(goodsMonthLiucuns1[i].getDate().equals(goodsMonthLiucuns2[i].getDate())){
                goodsMonthLiucuns1[i].setTotalInstallUser(goodsMonthLiucuns1[i].getTotalInstallUser()+goodsMonthLiucuns2[i].getTotalInstallUser());
            }
            System.out.println("Ios的数据是"+goodsMonthLiucuns2[i].getDate()+"---"+goodsMonthLiucuns2[i].getTotalInstallUser());
            System.out.println("总数据"+goodsMonthLiucuns1[i].getDate()+"--"+goodsMonthLiucuns1[i].getTotalInstallUser());
            Sevenliucun.add(goodsMonthLiucuns1[i]);
        }
        return  Sevenliucun;
    }


}
