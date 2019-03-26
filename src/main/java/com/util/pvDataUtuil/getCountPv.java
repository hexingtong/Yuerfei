package com.util.pvDataUtuil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springmvc.pojo.Goodspvdata;
import com.util.DateUtil;
import com.util.OpenAPI;

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
 * @author boyang
 * @date 2019/3/26 16:23
 * @param
 * @return
 */


/**
 * Description：得到新增用户
 * @author boyang
 * @date 2019/3/26 16:24
 * @param
 * @return
 */

/**
 * Description：用户的留存
 * @author boyang
 * @date 2019/3/26 16:25
 * @param
 * @return
 */

}
