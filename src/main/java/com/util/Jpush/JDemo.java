package com.util.Jpush;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JDemo
 * @Description:
 * @Author by
 * @Date: 2019/5/15 16:15
 **/
public class JDemo {
    public static void main(String[] args) {
        //设置推送参数
        //这里同学们就可以自定义推送参数了
        Map<String, String> parm = new HashMap<String, String>();
        //这里的id是,移动端集成极光并登陆后,极光用户的rid
        //   parm.put("id", "7b57eee9adaecb1e73089b48");
        //设置提示信息,内容是文章标题
        parm.put("msg", "测试测试,收到请联系发送人5");
           JPush.jpushIOS(parm);
        parm.put("title", "来钱推送消息");
        JPush.jpushAndroid(parm);
    }


}
