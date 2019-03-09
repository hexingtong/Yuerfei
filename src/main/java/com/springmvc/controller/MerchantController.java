package com.springmvc.controller;

import com.jayway.jsonpath.spi.Mode;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.pojo.kn_tag;
import com.springmvc.service.MemberService;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.util.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MemberService memberService;

    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);

    //查询商户所有信息
    @RequestMapping("/MerchantList")
    @ResponseBody
    public void MerchantlistModel(Mode model, HttpServletResponse response, @RequestParam(value = "pageNo",
            defaultValue = "1", required = false) Integer pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = "5", required = false)
                                          Integer pageSize, String phone) {
        ListObject listObject = new ListObject();
        List lst = new ArrayList();
        kn_admin kn_admin = new kn_admin();
//      lst=knAdminservice.queryBylevel();
        try {
            PageResultInfo resultInfo = memberService.queryListAdmin(pageNo, pageSize, phone);
            lst.add(resultInfo);
            listObject.setMsg("查询成功");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setItems(lst);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        } catch (NullPointerException nus) {
            logger.info("lst的值" + lst);
            listObject.setMsg("没有查询到值");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));

        }

    }

    //商户编辑页面
    @RequestMapping("/Merchantedit")
    @ResponseBody
    public void MerchanteditEdit(Integer id, HttpServletResponse response) {
        //根据id获得对应的值
        List<kn_admin> lst = new ArrayList();
        ListObject listObject = new ListObject();
        kn_admin knAdmin = new kn_admin();
        knAdmin.setId(id);
        knAdmin = memberService.queryById(knAdmin);
        if (knAdmin != null) {
            logger.info("测试值" + knAdmin);
            listObject.setMsg("查询成功");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setItems(lst);
            ResponseUtils.renderJson(response, JsonUtils.toJson(knAdmin));
        } else {
            listObject.setMsg("没有找到数据,查询失败");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }

    }

    //商户页面删除
    @RequestMapping("/MerchantExamine")
    @ResponseBody
    public void MerchantExamine(Integer id, HttpServletResponse response) {
        //根据id删除
        kn_admin knAdmim = new kn_admin();
        ListObject listObject = new ListObject();
        if (memberService.deletebyIdMerchant(id) > 0) {
            //查询商家有没有产品
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("删除成功!");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        } else {
            listObject.setMsg("删除失败!)");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }

    }

    //标签展示页面and查询
    @RequestMapping("/MercjatTagList")
    @ResponseBody
    public void MercjatTag(Mode model, HttpServletResponse response, @RequestParam(value = "pageNo",
            defaultValue = "1", required = false) Integer pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "5", required = false)
                                   Integer pageSize, String title) {
        ListObject listObject = new ListObject();
        List lst = new ArrayList();
        kn_tag knTag = new kn_tag();

        PageResultInfo resultInfo = memberService.queryListTag(pageNo, pageSize, title);
        if (resultInfo != null) {
            lst.add(resultInfo);
            listObject.setMsg("查询成功");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setItems(lst);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        } else {
            listObject.setMsg("查询失败");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }

    }

    //标签增加页面
    @RequestMapping("/MercjatTagListIncrease")
    @ResponseBody()
    public void MercjatTagListIncrease(HttpServletResponse response, String title) {
        kn_tag knTag = new kn_tag();
        ListObject listObject = new ListObject();
        if (!"".equals(title) && title != null) {
            knTag.setTitle(title);
            String dateUtil = DateUtil.getNowDate();
            Date utilDate = DateUtil.stringToDate(dateUtil);
            knTag.setAddTime(utilDate);

            int i = memberService.MercjatTagIncrease(knTag);
            if (i > 0) {
                listObject.setCode(StatusCode.CODE_SUCCESS);
                listObject.setMsg("增加成功");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            } else {
                listObject.setCode(StatusCode.CODE_SUCCESS);
                listObject.setMsg("增加失败");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        } else {
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("title不能为空");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }

    }


    //编辑标签页面
    @RequestMapping("/MercjatTagListUpadete")
    @ResponseBody
    public void MercjatTagListIncrease(HttpServletResponse response, Integer id, String title) {
        kn_tag knTag = new kn_tag();
        ListObject listObject = new ListObject();
        if(id!=null&&!"".equals(id)&&title!=null&&!"".equals(title)){
            knTag.setTitle(title);
            knTag.setId(id);
            int i=memberService.MercjatTagUpadete(knTag);
            if(i>0){
                listObject.setCode(StatusCode.CODE_SUCCESS);
                listObject.setMsg("更新成功");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }else{
                listObject.setMsg("更新失败");
                listObject.setCode(StatusCode.CODE_ERROR);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        }else{
            listObject.setMsg("id或title为空");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }



    /**
     * 用户信息头像上传功能
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping("/addUserInfo")
    public void addUserInfo(HttpServletResponse response,HttpServletRequest request) throws IOException {
        try {
            List<FileItem> lst=ImageUtil.getRequeat(request);
            String i=ImageUtil.upload(request,lst);
            logger.info("返回的String值是--"+i);
            Object msg=request.getAttribute("message");
            logger.info(msg+"");
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }






}
