package com.springmvc.controller;

import com.qiniu.util.StringMap;
import com.util.qiniuUtil.AccountMgr;
import com.util.qiniuUtil.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UploadToken
 * @Description:
 * @Author by
 * @Date: 2019/4/13 15:05
 **/
@RequestMapping("/upload")
@Controller
public class UploadToken {

    @RequestMapping("/gettoken")
    @ResponseBody
    public String TimerFriend(String bucket ){
       return Auth.create(AccountMgr.ACCESS_KEY,AccountMgr.SECRET_KEY).uploadToken(bucket);

    }

    /**
     * Description：返回token默认过期时间
     * @author boyang
     * @date 2019/4/26 11:07
     * @param
     * @return
     */
    @RequestMapping("/getTimeToken")
    @ResponseBody
    public String getTimeToken(String bucket ){
        return Auth.create(AccountMgr.ACCESS_KEY,AccountMgr.SECRET_KEY).uploadToken(bucket,null,3600,null,true);

    }

}
