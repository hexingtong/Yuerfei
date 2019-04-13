package com.util.shortUrl;

import com.util.Https.HttpUtil;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class FriendApiUtils {


    final static String format="txt";
    final static String Url="https://12i.cn/api.ashx";
    //?
    final static String userId="3100";
    final static String key="3E457CECE7CD995CD2672DC76D876EC0";

        
        /**
         * @Author 苏俊杰
         * @Description //TODO 修改推广链接
         * @Date 11:53 2019/4/10
         * @Param 
         * @return 
         **/
        public static  String UpdateFriendApi(String title, String url, String shortUrl){
            ListObject listObject=new ListObject();
            Map createMap=new HashMap();
            String format1="revise";
            createMap.put("format",format1);
            createMap.put("userId",userId);
            createMap.put("key",key);
            createMap.put("title",title);
            String shourtUrl=shortUrl.substring(shortUrl.length()- 6);
            createMap.put("shortUrl",shourtUrl);
            createMap.put("url",url);
            System.out.println("传入的短链接"+shortUrl);
            String result=HttpUtil.doPostSSL(Url,createMap,null);
            JSONObject jsonData = JSONObject.fromObject(result);
            String success=jsonData.get("success").toString();
            if(success.equals("ok")){
               return "ok";
            }else{
                return "error";
            }
        }
        
        
        /**
         * @Author 苏俊杰
         * @Description //TODO 增加API推广链接
         * @Date 20:15 2019/4/3
         * @Param [url, title]
         * @return java.lang.String
         **/
        public static String AddFriendApi(String url,String title){
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

        public static String DelectFriendApi(String url){
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
