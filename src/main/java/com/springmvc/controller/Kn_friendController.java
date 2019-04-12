package com.springmvc.controller;


import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_friend;
import com.springmvc.service.FriendService;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Api(value="推广页面controller",tags={"推广操作接口"})
@Controller
@RequestMapping("/friend")
public class Kn_friendController {

    @Autowired
    private FriendService FriendService;

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页面展示
     * @Date 14:12 2019/4/8
     * @Param
     * @return
     **/
    @ApiOperation(value = "获取推广页面数据", httpMethod = "POST", response = StatusCode.class, notes = "获取推广页面数据")
    @RequestMapping("/friendList")
    @ResponseBody
    public void friendList(@RequestParam(
            value = "pageNo", defaultValue = "1",
            required = false)
                                   Integer pageNo,
                           @RequestParam(value = "Index",defaultValue = "0", required = false)
                                   Integer Index1,
                           @RequestParam(value = "pageSize", defaultValue = "3000", required = false)
                                   Integer pageSize,HttpServletResponse response,String title,String index) {
        ListObject listObject=new ListObject();
        try {
            PageResultInfo resultInfo = FriendService.queryListfriend(pageNo, pageSize,title,Index1);
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

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页面删除
     * @Date 14:12 2019/4/8
     * @Param
     * @return
     **/
    @ApiOperation(value = "推广页面数据删除", httpMethod = "POST", response = StatusCode.class, notes = "推广页面数据删除")
    @RequestMapping("/deleteFriend")
    @ResponseBody
    public void deletefriend(HttpServletResponse response,int id){
        ListObject listObject=new ListObject();
        List lst=new ArrayList();
        kn_friend kn_friend=FriendService.selectFrilend(id);
        int i=FriendService.deleteFriend(id);
        if(i>0){
            listObject.setMsg("删除成功!");
            lst.add(kn_friend);
            listObject.setItems(lst);
            listObject.setCode(StatusCode.CODE_SUCCESS);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else{
            listObject.setMsg("删除失败!");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页面编辑
     * @Date 14:13 2019/4/8
     * @Param
     * @return
     **/
    @ApiOperation(value = "推广页面编辑", httpMethod = "POST", response = StatusCode.class, notes = "推广页面编辑")
    @RequestMapping("/updateFriend")
    @ResponseBody
    public void updateFrilend(HttpServletResponse response,String title,Integer id,String url){
        System.out.println("进入接口");
        System.out.println("传进来的值-->id:"+id+"<--|title:"+title+"|-->||<--url:"+url+"-->");
        ListObject listObject=new ListObject();
        kn_friend kn_friend=new kn_friend();
        kn_friend.setTitle(title);
        kn_friend.setUrl(url);
        kn_friend.setId(id);
        System.out.println("传进来的值-->id:"+id+"<--|title:"+title+"|-->||<--url:"+url+"-->");
        int i=FriendService.updateFrilend(kn_friend);
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

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页面增加
     * @Date 14:13 2019/4/8
     * @Param
     * @return
     **/
    @ApiOperation(value = "推广页面增加", httpMethod = "POST", response = StatusCode.class, notes = "推广页面增加")
    @RequestMapping("/insertFriend")
    @ResponseBody
    public void insertFriend(HttpServletResponse response,kn_friend kn_friend){
        ListObject listObject=new ListObject();
        System.out.println("推广名字"+kn_friend.getTitle());
        System.out.println("推广链接"+kn_friend.getUrl());
        int i=FriendService.insertFrilend(kn_friend);
        if(i>0){
            listObject.setMsg("增加成功!");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else {
            listObject.setMsg("增加失败!");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }

    }

}
