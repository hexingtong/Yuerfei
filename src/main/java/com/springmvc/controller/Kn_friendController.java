package com.springmvc.controller;


import com.springmvc.mapping.FriendAdminMapper;
import com.springmvc.pojo.FriendAdmin;
import com.springmvc.pojo.DTO.FriendDVO;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.Person;
import com.springmvc.pojo.kn_friend;
import com.springmvc.service.FriendService;
import com.springmvc.service.FriendTimer;
import com.util.*;
import com.util.Https.HttpUtil;
import com.util.shortUrl.FriendApiUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value="推广页面controller",tags={"推广操作接口"})
@Controller
    @RequestMapping("/friendx")
public class Kn_friendController {

    @Autowired
    private FriendService FriendService;
    @Autowired
    private FriendAdminMapper friendAdminMapper;

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
                           @RequestParam(value = "pageSize", defaultValue = "5", required = false)
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
    public void deletefriend(HttpServletResponse response,Integer id){
        ListObject listObject=new ListObject();
        System.out.println("id的值是："+id);
        List lst=new ArrayList();
        kn_friend kn_friend=FriendService.selectFrilend(id);

        String foalt=FriendApiUtils.DelectFriendApi(kn_friend.getUrl());
        if(foalt.equals("200")){
            int i=FriendService.deleteFriend(id);
            if(i>0){
                listObject.setMsg("删除成功!");
                listObject.setCode(StatusCode.CODE_SUCCESS);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));

            }else{
                listObject.setMsg("删除失败!");
                listObject.setCode(StatusCode.CODE_ERROR);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        }else{
            listObject.setMsg("短链接删除失败!");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页面编辑
     * @Date 14:13 2019/4/8
     **/
    @ApiOperation(value = "推广页面编辑", httpMethod = "POST", response = StatusCode.class, notes = "推广页面编辑")
    @RequestMapping("/updateFriend")
    @ResponseBody
    public JsonResult updateFrilend(HttpServletResponse response,String title,Integer id,String longUrl,String username,String pwd,  @RequestParam(value = "intradayQuantity", required = false)Integer intradayQuantity,@RequestParam(value = "defaultQuantity", required = false)Integer defaultQuantity ){
JsonResult jsonResult=new JsonResult();
        try {
            int i = FriendService.updateFrilend2( title, id, longUrl, username, pwd, intradayQuantity,defaultQuantity);
            jsonResult.setCode(StatusCode.SUCCESSFULLY);
            jsonResult.setMessage("修改成功");
        } catch (Exception e) {
            jsonResult.setCode(StatusCode.FAILED);
            jsonResult.setMessage("修改错误");
            e.printStackTrace();
        }
        return  jsonResult;
    }
    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页面增加
     * @Date 14:13 2019/4/8
     **/
    @ApiOperation(value = "推广页面增加", httpMethod = "POST", response = kn_friend.class, notes = "推广页面增加")
    @RequestMapping("/insertFriend")
    @ResponseBody
    public void insertFriend(HttpServletResponse response,FriendDVO kn_friend){
        ListObject listObject=new ListObject();
        //先生成自己的短链接
        String shortshortUrl=FriendService.getShortUrl();
        System.out.println("推广名字"+kn_friend.getTitle());
        System.out.println("传入的网址"+kn_friend.getLongUrl());
        System.out.println("生成的6位短链接"+shortshortUrl);
        StringBuilder sb=new StringBuilder(shortshortUrl);
        sb.insert(0, "http://yef.miaojiedao.cn/friendx/");
        System.out.println("转换后的网址"+sb.toString());
        String folat=FriendApiUtils.AddFriendApi(sb.toString(),kn_friend.getTitle());
        if(!folat.equals("error")&&!shortshortUrl.equals("禁止生成IP地址作为域名的网址")) {
            kn_friend.setShortUrl(shortshortUrl);
            kn_friend.setUrl(folat);
            int i = FriendService.insertFrilend(kn_friend);
            if (i > 0) {
                listObject.setMsg("增加成功!");
                listObject.setCode(StatusCode.CODE_SUCCESS);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            } else {
                listObject.setMsg("增加失败!");
                listObject.setCode(StatusCode.CODE_ERROR);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        }else{
            listObject.setMsg("生成API短链接失败!");
            listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }






    /**
     * @Author 苏俊杰
     * @Description //TODO 根据短链接转发到真实路径
     * @Date 18:13 2019/4/12
     * @Param [request, mav, shortUrl]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @ApiIgnore()
    @RequestMapping("/{shortUrl}")
    public ModelAndView jumpLongLink(HttpServletRequest request, ModelAndView mav, @PathVariable("shortUrl")String shortUrl) {
        kn_friend kn_friend=new kn_friend();
        String longUrl = "";
        kn_friend.setShortUrl(shortUrl);
        System.out.println("short的值是*"+shortUrl);
        String longurl = FriendService.restoreUrl(kn_friend);
        if (longUrl!=null) {
            longUrl = longurl;
        }else{
            //返回错误页面404
            mav.setViewName("redirect:" + 404);
            return mav;
        }
        mav.setViewName("redirect:" + longUrl+"?short="+shortUrl+"");
        return mav;
    }



    /**
     * @Author 苏俊杰
     * @Description //TODO 推广链接图表跳转页面
     * @Date 13:54 2019/3/26
     * @Param
     * @return
     **/
    @ApiOperation(value = "获取推广链接图表数据接口", httpMethod = "POST", response = StatusCode.class, notes = "获取推广链接图表数据接口")
    @RequestMapping("/FriendImgx")
    public void FriendImg2(HttpServletResponse response,Integer id){
        System.out.println("id的值是"+id);
        ListObject listObject=new ListObject();
        if(id!=0||!id.equals("")) {
            kn_friend kn_friend = FriendService.selectFrilend(id);
            Map map=new HashMap();
            String format = "day";
            Person[] person= FriendTimer.DatePvUv(kn_friend.getUrl(),format);
            List<Person> lst=new ArrayList<>();
            for(int i=0;i<person.length;i++){
                lst.add(person[i]);
            }
            listObject.setItems(lst);
            listObject.setMsg("查询成功");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else {
            listObject.setMsg("查询失败");
            listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 检查推广账号有没有重复
     * @Date 9:27 2019/5/15
     * @Param
     * @return
     **/
    @ApiOperation(value = "检查推广账号有没有重复",httpMethod = "POST",response = StatusCode.class,notes = "参数 account（账号）")
    @RequestMapping("/checkFriendRegister")
    @ResponseBody
    public JsonResult checkFriendRegister(FriendAdmin friendAdmin){
        JsonResult result=new JsonResult();
        int i=FriendService.selectRegister(friendAdmin);
        if(i==1){
            result.setCode(StatusCode.FAILED);
            result.setMessage("有相同账号!");
            return result;
        }else {
            result.setCode(StatusCode.SUCCESSFULLY);
            result.setMessage("检验成功!没有相同账号!");
            return  result;
        }
    }

}
