package com.springmvc.controller;

import com.util.Https.HttpUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/FriendAPI")
public class FriendApiController {


    final static String format="txt";
    final static String Url="https://12i.cn/api.ashx";
    //?
    final static String userId="3100";
    final static String key="3E457CECE7CD995CD2672DC76D876EC0";
    /**
     * @Author 苏俊杰
     * @Description //TODO 修改推广链接的地址然后删除掉原地址
     * @Date 16:55 2019/4/3
     * @Param 
     * @return 
     **/
    @RequestMapping("/UpdateFriendApi")
    @ResponseBody
    public String UpdateFriendApi(String title,String url,String urlTo){
        Map createMap=new HashMap();
        createMap.put("format",format);
        createMap.put("userId",userId);
        createMap.put("key",key);
        createMap.put("url",urlTo);
        createMap.put("title",title);
        System.out.println("传入的原链接"+urlTo);
        String urlx=HttpUtil.doPostSSL(Url,createMap,null);
        System.out.println("获得的值"+urlx);
        if(!urlx.equals("网址格式错误,必须以http或者https开头的完整网址")){
            System.out.println("进入正确!");
            String format2="del";
            //       https://12i.cn/api.ashx?format=del&userId=?&key=?&url=https://12i.cn/xxxxxx
            Map createMap1=new HashMap();
            createMap1.put("format",format2);
            createMap1.put("userId",userId);
            createMap1.put("key",key);
            createMap1.put("url",url);
//        String json=HttpUtil.doPostSSL("https://12i.cn/api.ashx?format=del",createMap,null);

            String result=HttpUtil.doPostSSL(Url,createMap1,null);
            JSONObject jsonData = JSONObject.fromObject(result);
            String success=jsonData.get("success").toString();
            if(success.equals("ok")){
                System.out.println("最后结果成功");
                return urlx;
            }
            return "error";
        }return "error";
        }
        /**
         * @Author 苏俊杰
         * @Description //TODO 增加API推广链接
         * @Date 20:15 2019/4/3
         * @Param [url, title]
         * @return java.lang.String
         **/
        @RequestMapping("/AddFriendApi")
        @ResponseBody
        public String AddFriendApi(String url,String title){
            Map createMap=new HashMap();

            createMap.put("format",format);
            createMap.put("userId",userId);
            createMap.put("key",key);
            createMap.put("url",url);
            createMap.put("title",title);
            System.out.println("传入的链接"+url);
            String urlx=HttpUtil.doPostSSL(Url,createMap,null);
            if(!urlx.equals("网址格式错误,必须以http或者https开头的完整网址")) {
            return urlx;
            }
            return "error";
        }
        /**
         * @Author 苏俊杰
         * @Description //TODO 删除API推广链接
         * @Date 20:16 2019/4/3
         * @Param 
         * @return 
         **/
        @RequestMapping("/DelectFriendApi")
        @ResponseBody
        public String DelectFriendApi(String url){
            Map createMap=new HashMap();
            String format2="del";
            createMap.put("format",format2);
            createMap.put("userId",userId);
            createMap.put("key",key);
            createMap.put("url",url);
            String result=HttpUtil.doPostSSL(Url,createMap,null);
            JSONObject jsonData = JSONObject.fromObject(result);
            String success=jsonData.get("success").toString();
            if(success.equals("ok")){
                System.out.println("最后结果成功");
                return "200";
            }
            return "error";


        }
}
