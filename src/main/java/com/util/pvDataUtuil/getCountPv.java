package com.util.pvDataUtuil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springmvc.pojo.*;
import com.util.DateUtil;
import com.util.OpenAPI;
import org.springframework.scheduling.annotation.Scheduled;
import net.sf.json.JsonConfig;

import java.util.*;

/**
 * @ClassName getCountPv
 * @Description:
 * @Author by
 * @Date: 2019/3/26 14:39
 **/
public class getCountPv {
/**
 * Description：当天得到产品总的pv
 * @author boyang
 * @date 2019/3/27 16:35
 * @param
 * @return java.util.List
 */
    public static List<Goodspvdata> getPv(){

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
            System.out.println("Android--"+goodspvdata.toString());
            android.add(goodspvdata);
        }



        //Ios pv
        JSONObject iosPv = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengIosPvEventParamGetValueList().get(0)));
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

        //循环id相同的增加，到新的集合
List<Goodspvdata> news=new ArrayList<>();
        Iterator iterList=android.iterator();
                 while( iterList.hasNext()){
            Goodspvdata Android= (Goodspvdata) iterList.next();
                     Iterator iterList2=ios.iterator();
                while( iterList2.hasNext()){
                    Goodspvdata Ios= (Goodspvdata) iterList2.next();

     if( Android.getGoodid()==Ios.getGoodid()){
         Goodspvdata NEWS=new Goodspvdata();
         if (weeked==2){

             NEWS.setGoodid(Ios.getGoodid());
             NEWS.setPone(( Ios.getPone()+Android.getPone()));
             news.add(NEWS);
         }else if(weeked==3){
             NEWS.setGoodid(Ios.getGoodid());
             NEWS.setPtwo(( Ios.getPtwo()+Android.getPtwo()));
             news.add(NEWS);
         }
         else if(weeked==4){

             NEWS.setGoodid(Ios.getGoodid());
             NEWS.setPthree(( Ios.getPthree()+Android.getPthree()));
             news.add(NEWS);
         }
         else if(weeked==5){

             NEWS.setGoodid(Ios.getGoodid());
             NEWS.setPfour(( Ios.getPfour()+Android.getPfour()));
             news.add(NEWS);
         }
         else if(weeked==6){
             NEWS.setGoodid(Ios.getGoodid());
             NEWS.setPfive(( Ios.getPfive()+Android.getPfive()));
             news.add(NEWS);
         }
         else if(weeked==7){
             NEWS.setGoodid(Ios.getGoodid());
             NEWS.setPsat(( Ios.getPsat()+Android.getPsat()));
             news.add(NEWS);

         }else if(weeked==1){
             NEWS.setGoodid(Ios.getGoodid());
             NEWS.setPsunday(( Ios.getPsunday()+Android.getPsunday()));
             news.add(NEWS);
         }
         iterList.remove();
         iterList2.remove();

      }
            }

        }

        android.addAll(news);
        android.addAll(ios);

        System.out.println("总的-----------------"+android.toString());



        return android;
    }

    /**
     * Description：得到产品总的pv ，从运行时间开始
     * @author boyang
     * @date 2019/4/10 11:22
     * @param
     * @return
     */

    public static List<kn_goods> getPv2(){

        //得到Android pv
        JSONObject obj = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengAndroidPvEventParamGetValueList2().get(0)));
        obj.get("paramInfos");
        JSONArray.parseArray( JSON.toJSONString(obj.get("paramInfos")));
        System.out.println( ( JSON.toJSONString(obj.get("paramInfos"))));
        // List<Goodsuvdata> android =new ArrayList<>() ;
        List<kn_goods> android =new ArrayList<>() ;

        int weeked= DateUtil.getWeeked();
        //得到Android pv 的集合
        for (Object i: JSONArray.parseArray( JSON.toJSONString(obj.get("paramInfos")))){
            JSONObject  j=  JSONObject.parseObject(JSON.toJSONString(i));
            //  Goodsuvdata goodsuvdata=new Goodsuvdata();
            kn_goods knGoods=new kn_goods();
            knGoods.setId(Integer.parseInt(j.get("name").toString()));
            knGoods.setPv((Integer) j.get("count"));
            System.out.println("AndroidknGoodsPV--"+knGoods.toString());
            android.add(knGoods);

        }



        //Ios pv
        JSONObject iosPv = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengIosPvEventParamGetValueList2().get(0)));
        iosPv.get("paramInfos");
        JSONArray.parseArray( JSON.toJSONString(iosPv.get("paramInfos")));
        System.out.println( ( JSON.toJSONString(iosPv.get("paramInfos"))));
        //  List<Goodsuvdata> ios =new ArrayList<>() ;
        List<kn_goods> ios =new ArrayList<>() ;
        for (Object io: JSONArray.parseArray( JSON.toJSONString(iosPv.get("paramInfos")))){

            JSONObject  j=  JSONObject.parseObject(JSON.toJSONString(io));
            kn_goods knGoods=new kn_goods();

            knGoods.setId(Integer.parseInt(j.get("name").toString()));
            knGoods.setPv((Integer) j.get("count"));
            System.out.println("iosknGoodsPV---"+knGoods.toString());
            ios.add(knGoods);
        }

        //循环id相同的增加，到新的集合
        //   List<Goodsuvdata> news=new ArrayList<>();
        List<kn_goods> news=new ArrayList<>();
        Iterator iterList=android.iterator();
        while( iterList.hasNext()){
            kn_goods Android= (kn_goods) iterList.next();

            Iterator iterList2=ios.iterator();
            while( iterList2.hasNext()){
                kn_goods Ios= (kn_goods) iterList2.next();

                if( Android.getId()==Ios.getId()){
                    kn_goods NEWS=new kn_goods();

                    NEWS.setId(Ios.getId());
                    NEWS.setPv(( Ios.getPv()+Android.getPv()));
                    news.add(NEWS);

                    iterList.remove();
                    iterList2.remove();

                }
            }

        }
        System.out.println("news-----------------"+news.toString());
        System.out.println("ios-----------------"+ios.toString());
        System.out.println("android-----------------"+android.toString());

        android.addAll(news);
        android.addAll(ios);

        System.out.println("总的-----------------"+android.toString());



        return android;
    }


    /**
     * Description：当天得到产品总的uv
     * @author boyang
     * @date 2019/3/27 16:35
     * @param
     * @return java.util.List
     */
    public static List<Goodsuvdata> getUv(){

        //得到Android pv
        JSONObject obj = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengAndroidEventParamGetValueList().get(0)));
        obj.get("paramInfos");
        JSONArray.parseArray( JSON.toJSONString(obj.get("paramInfos")));
        System.out.println( ( JSON.toJSONString(obj.get("paramInfos"))));
        List<Goodsuvdata> android =new ArrayList<>() ;
        int weeked= DateUtil.getWeeked();
        //得到Android pv 的集合
        for (Object i: JSONArray.parseArray( JSON.toJSONString(obj.get("paramInfos")))){
            JSONObject  j=  JSONObject.parseObject(JSON.toJSONString(i));
            Goodsuvdata goodsuvdata=new Goodsuvdata();


            goodsuvdata.setGoodsid(Integer.parseInt(j.get("name").toString()));
            if (weeked==2){
                goodsuvdata.setUone((Integer) j.get("count"));
            }else if(weeked==3){
                goodsuvdata.setUtwo((Integer) j.get("count"));
            }
            else if(weeked==4){
                goodsuvdata.setUthree((Integer) j.get("count"));
            }
            else if(weeked==5){
                goodsuvdata.setUfour((Integer) j.get("count"));
            }
            else if(weeked==6){
                goodsuvdata.setUfive((Integer) j.get("count"));
            }
            else if(weeked==7){
                goodsuvdata.setUsat((Integer) j.get("count"));
            }else if(weeked==1){
                goodsuvdata.setUsunday((Integer) j.get("count"));
            }
            System.out.println("Android--"+goodsuvdata.toString());
            android.add(goodsuvdata);
        }


        //Ios pv
        JSONObject iosPv = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengIosEventParamGetValueList().get(0)));
        iosPv.get("paramInfos");
        JSONArray.parseArray( JSON.toJSONString(iosPv.get("paramInfos")));
        System.out.println( ( JSON.toJSONString(iosPv.get("paramInfos"))));
        List<Goodsuvdata> ios =new ArrayList<>() ;

        for (Object io: JSONArray.parseArray( JSON.toJSONString(iosPv.get("paramInfos")))){

            JSONObject  j=  JSONObject.parseObject(JSON.toJSONString(io));
            Goodsuvdata goodsuvdata=new Goodsuvdata();
            goodsuvdata.setGoodsid(Integer.parseInt(j.get("name").toString()));
            if (weeked==2){
                goodsuvdata.setUone((Integer) j.get("count"));
            }else if(weeked==3){
                goodsuvdata.setUtwo((Integer) j.get("count"));
            }
            else if(weeked==4){
                goodsuvdata.setUthree((Integer) j.get("count"));
            }
            else if(weeked==5){
                goodsuvdata.setUfour((Integer) j.get("count"));
            }
            else if(weeked==6){
                goodsuvdata.setUfive((Integer) j.get("count"));
            }
            else if(weeked==7){
                goodsuvdata.setUsat((Integer) j.get("count"));
            }else if(weeked==1){
                goodsuvdata.setUsunday((Integer) j.get("count"));
            }
            System.out.println("ios---"+goodsuvdata.toString());
            ios.add(goodsuvdata);

        }

        //循环id相同的增加，到新的集合
        List<Goodsuvdata> news=new ArrayList<>();
        Iterator iterList=android.iterator();
        while( iterList.hasNext()){
            Goodsuvdata Android= (Goodsuvdata) iterList.next();
            Iterator iterList2=ios.iterator();
            while( iterList2.hasNext()){
                Goodsuvdata Ios= (Goodsuvdata) iterList2.next();

                if( Android.getGoodsid()==Ios.getGoodsid()){
                    Goodsuvdata NEWS=new Goodsuvdata();
                    if (weeked==2){

                        NEWS.setGoodsid(Ios.getGoodsid());
                        NEWS.setUone(( Ios.getUone()+Android.getUone()));
                        news.add(NEWS);
                    }else if(weeked==3){
                        NEWS.setGoodsid(Ios.getGoodsid());
                        NEWS.setUtwo(( Ios.getUtwo()+Android.getUtwo()));
                        news.add(NEWS);
                    }
                    else if(weeked==4){

                        NEWS.setGoodsid(Ios.getGoodsid());
                        NEWS.setUthree(( Ios.getUthree()+Android.getUthree()));
                        news.add(NEWS);
                    }
                    else if(weeked==5){

                        NEWS.setGoodsid(Ios.getGoodsid());
                        NEWS.setUfour(( Ios.getUfour()+Android.getUfour()));
                        news.add(NEWS);
                    }
                    else if(weeked==6){
                        NEWS.setGoodsid(Ios.getGoodsid());
                        NEWS.setUfive(( Ios.getUfive()+Android.getUfive()));
                        news.add(NEWS);
                    }
                    else if(weeked==7){
                        NEWS.setGoodsid(Ios.getGoodsid());
                        NEWS.setUsat(( Ios.getUsat()+Android.getUsat()));
                        news.add(NEWS);

                    }else if(weeked==1){
                        NEWS.setGoodsid(Ios.getGoodsid());
                        NEWS.setUsunday(( Ios.getUsunday()+Android.getUsunday()));
                        news.add(NEWS);
                    }
                    iterList.remove();
                    iterList2.remove();

                }
            }

        }

        android.addAll(news);
        android.addAll(ios);

        System.out.println("总的-----------------"+android.toString());



        return android;
    }



    /**
     * Description：得到产品总的uv，从运行时间开始计算
     * @author boyang
     * @date 2019/3/27 16:35
     * @param
     * @return java.util.List
     */
    public static List<kn_goods> getUv2(){

        //得到Android Uv
        JSONObject obj = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengAndroidEventParamGetValueList2().get(0)));
        obj.get("paramInfos");
        JSONArray.parseArray( JSON.toJSONString(obj.get("paramInfos")));
        System.out.println( ( JSON.toJSONString(obj.get("paramInfos"))));
       // List<Goodsuvdata> android =new ArrayList<>() ;
        List<kn_goods> android =new ArrayList<>() ;

        int weeked= DateUtil.getWeeked();
        //得到Android Uv 的集合
        for (Object i: JSONArray.parseArray( JSON.toJSONString(obj.get("paramInfos")))){
            JSONObject  j=  JSONObject.parseObject(JSON.toJSONString(i));
          //  Goodsuvdata goodsuvdata=new Goodsuvdata();
            kn_goods knGoods=new kn_goods();
            knGoods.setId(Integer.parseInt(j.get("name").toString()));
            knGoods.setUv((Integer) j.get("count"));
            System.out.println("AndroidknGoods--"+knGoods.toString());
            android.add(knGoods);

        }


        //Ios Uv
        JSONObject iosUv = JSONObject.parseObject( JSON.toJSONString(OpenAPI.umengIosEventParamGetValueList2().get(0)));
        iosUv.get("paramInfos");
        JSONArray.parseArray( JSON.toJSONString(iosUv.get("paramInfos")));
        System.out.println( ( JSON.toJSONString(iosUv.get("paramInfos"))));
      //  List<Goodsuvdata> ios =new ArrayList<>() ;
        List<kn_goods> ios =new ArrayList<>() ;
        for (Object io: JSONArray.parseArray( JSON.toJSONString(iosUv.get("paramInfos")))){

            JSONObject  j=  JSONObject.parseObject(JSON.toJSONString(io));
            kn_goods knGoods=new kn_goods();

            knGoods.setId(Integer.parseInt(j.get("name").toString()));
            knGoods.setUv((Integer) j.get("count"));
            System.out.println("iosknGoods---"+knGoods.toString());
            ios.add(knGoods);
        }

        //循环id相同的增加，到新的集合
     //   List<Goodsuvdata> news=new ArrayList<>();
        List<kn_goods> news=new ArrayList<>();
        Iterator iterList=android.iterator();
        while( iterList.hasNext()){
            kn_goods Android= (kn_goods) iterList.next();

            Iterator iterList2=ios.iterator();
            while( iterList2.hasNext()){
                kn_goods Ios= (kn_goods) iterList2.next();

                if( Android.getId()==Ios.getId()){
                    kn_goods NEWS=new kn_goods();

                        NEWS.setId(Ios.getId());
                        NEWS.setUv(( Ios.getUv()+Android.getUv()));
                        news.add(NEWS);

                    iterList.remove();
                    iterList2.remove();

                }
            }

        }

        System.out.println("news-----------------"+news.toString());
        System.out.println("android-----------------"+ios.toString());
        System.out.println("android-----------------"+android.toString());

        android.addAll(news);
        android.addAll(ios);

        System.out.println("总的-----------------"+android.toString());



        return android;
    }


/**
 * Description：得到所有的月活
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
 * Description：用户总的近三十天留存
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
    /**
     * Description： 得到三十天总的 Uv
     * @author boyang
     * @date 2019/4/13 11:33
     * @param
     * @return void
     */
    public static List getCountUv(){
        JSONObject obj = JSONObject.parseObject(OpenAPI.umengUappEventGetData());
        obj.get("eventData");
        JSONObject obj1 = JSONObject.parseObject(OpenAPI.umengUIosEventGetDataUv());
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(JSONArray.parseArray( JSON.toJSONString(obj1.get("eventData"))));
        net.sf.json.JSONArray jsonArray1 = net.sf.json.JSONArray.fromObject(JSONArray.parseArray(  JSON.toJSONString(obj.get("eventData"))));
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


    /**
     * @Author 苏俊杰
     * @Description //TODO 获得所有30日新增用户
     * @Date 17:35 2019/4/13
     * @Param []
     * @return java.util.List
     **/
    public static List getMonthnewUser(){
        JSONObject obj = JSONObject.parseObject(OpenAPI.umengAndrienMothUappGetNewUsers());
        obj.get("newUserInfo");
        JSONObject obj1 = JSONObject.parseObject(OpenAPI.umengIosMothUappGetNewUsers());
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(JSONArray.parseArray( JSON.toJSONString(obj1.get("newUserInfo"))));
        net.sf.json.JSONArray jsonArray1 = net.sf.json.JSONArray.fromObject(JSONArray.parseArray(  JSON.toJSONString(obj.get("newUserInfo"))));
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


    public static void main(String[] args) {
     //  getPv2();
        //getUv2();
    }

}
