package com.springmvc.controller;

import org.apache.http.HttpResponse;

/**
 * @ClassName UrlTongJi
 * @Description:
 * @Author by
 * @Date: 2019/3/23 19:08
 **/
public class UrlTongJi {
    final static String userId="3100";

    final static String key="3E457CECE7CD995CD2672DC76D876EC0";

    final static String urlc="https://12i.cn/api.ashx?format=txt";

    public static String UrlTongji(HttpResponse response, String url){
        String urlx=urlc+"&userId="+userId+"&key="+key+"&"+url;

        return urlx;
    }


}
