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
            List lstt=new ArrayList();
            ListObject listObject = new ListObject();
            List<FileItem> lst=ImageUtil.getRequeat(request);
            String i=ImageUtil.upload(request,lst);
            logger.info("返回的String值是--"+i);
            Object msg=request.getAttribute("message");
            logger.info(msg+"");
            if(i=="error"){
                logger.info("上传失败");
                listObject.setCode(StatusCode.CODE_ERROR);
                listObject.setMsg("上传失败");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }else{
                logger.info("上传成功");
                listObject.setCode(StatusCode.CODE_SUCCESS);
                listObject.setMsg("上传成功");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }






}
