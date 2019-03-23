package com.springmvc.controller;

import com.springmvc.pojo.KnFriend;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_friend;
import com.springmvc.service.MemberService;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/friend")
public class Kn_friendController {

    @Autowired
    private MemberService memberService;

    //推广页面展示
    @RequestMapping("/friendList")
    @ResponseBody
    public void friendList(@RequestParam(value = "pageNo", defaultValue = "1",
            required = false)
                                   Integer pageNo,
                           @RequestParam(value = "Index",defaultValue = "0", required = false)
                                   Integer Index1,
                           @RequestParam(value = "pageSize", defaultValue = "4", required = false)
                                   Integer pageSize,HttpServletResponse response,String title,String index) {
        ListObject listObject=new ListObject();
        try {
            PageResultInfo resultInfo = memberService.queryListfriend(pageNo, pageSize,title,Index1);
            listObject.setMsg("查询成功");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            List lst=new ArrayList();
            lst.add(resultInfo);
            listObject.setItems(lst);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }catch (NullPointerException n){
            listObject.setMsg("查询失败");
            listObject.setCode(StatusCode.CODE_ERROR);
        }

    }

    //推广页面删除
    @RequestMapping("/deleteFriend")
    @ResponseBody
    public void deletefriend(HttpServletResponse response,int id){
        ListObject listObject=new ListObject();
        int i=memberService.deleteFriend(id);
        if(i>0){
            listObject.setMsg("删除成功!");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else{
            listObject.setMsg("删除失败!");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

    //推广页面编辑
    @RequestMapping("/updateFriend")
    @ResponseBody
    public void updateFrilend(HttpServletResponse response,String title,String url){
        ListObject listObject=new ListObject();
        kn_friend kn_friend=new kn_friend();
        kn_friend.setTitle(title);
        kn_friend.setUrl(url);
        int i=memberService.updateFrilend(kn_friend);
        if(i>0){
            listObject.setMsg("编辑成功!");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else{
            listObject.setMsg("编辑失败!");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

}