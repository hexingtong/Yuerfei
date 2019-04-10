package com.springmvc.controller;

import com.util.Https.HttpUtil;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
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
    @ApiOperation(value = "修改推广链接的地址然后删除掉原地址", httpMethod = "POST", response = StatusCode.class, notes = "根据token获取用户信息修改推广链接的地址然后删除掉原地址")
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
         * @Description //TODO 修改推广链接
         * @Date 11:53 2019/4/10
         * @Param 
         * @return 
         **/
        @RequestMapping("/UpdateFriendApi2")
        public static   void UpdateFriendApi2(HttpServletResponse response,String title, String urlx, String urlTo){
            ListObject listObject=new ListObject();
            Map createMap=new HashMap();
            String format1="revise";
            createMap.put("format",format1);
            createMap.put("userId",userId);
            createMap.put("key",key);
            createMap.put("title",title);
            createMap.put("shortUrl",urlTo);
            createMap.put("title",title);
            createMap.put("url",urlx);
            System.out.println("传入的原链接"+urlTo);
            String result=HttpUtil.doPostSSL(Url,createMap,null);
            JSONObject jsonData = JSONObject.fromObject(result);
            String success=jsonData.get("success").toString();
            if(success.equals("ok")){
                listObject.setContent(StatusCode.CODE_SUCCESS,"成功");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }else{
                listObject.setContent(StatusCode.CODE_ERROR_PARAMETER,"失败");
                listObject.setMsg("失败！");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        }
        
        
        /**
         * @Author 苏俊杰
         * @Description //TODO 增加API推广链接
         * @Date 20:15 2019/4/3
         * @Param [url, title]
         * @return java.lang.String
         **/
        @ApiOperation(value = "增加API推广链接", httpMethod = "POST", response = StatusCode.class, notes = "增加API推广链接")
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
        @ApiOperation(value = "删除API推广链接", httpMethod = "POST", response = StatusCode.class, notes = "删除API推广链接")
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
