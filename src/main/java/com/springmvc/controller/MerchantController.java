package com.springmvc.controller;

import com.jayway.jsonpath.spi.Mode;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.pojo.kn_tag;
import com.springmvc.service.MemberService;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.util.*;
import io.swagger.annotations.ApiOperation;
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
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@ApiIgnore()
@Controller
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MemberService memberService;

    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询商户所有信息
     * @Date 14:30 2019/4/28
     * @Param
     * @return
     **/
    @ApiOperation(value = "查询所有商户信息", httpMethod = "POST", response = StatusCode.class, notes = "根据手机号发送验证码")
    @RequestMapping("/MerchantList")
    @ResponseBody
    public void MerchantlistModel(Mode model, HttpServletResponse response, @RequestParam(value = "pageNo",
            defaultValue = "1", required = false) Integer pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = "5", required = false)
                                          Integer pageSize, String phone,
                                  @RequestParam(value = "level", defaultValue = "1", required = false)
                                              Integer level
                                  ) {
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

    /**
     * @Author 苏俊杰
     * @Description //TODO 商户编辑页面
     * @Date 14:30 2019/4/28
     * @Param
     * @return
     **/
    @ApiOperation(value = "商户页面编辑", httpMethod = "POST", response = StatusCode.class, notes = "商户页面编辑")
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

    /**
     * @Author 苏俊杰
     * @Description //TODO 商户页面删除
     * @Date 14:30 2019/4/28
     * @Param
     * @return
     **/
    @ApiOperation(value = "商户页面删除", httpMethod = "POST", response = StatusCode.class, notes = "商户页面删除")
    @RequestMapping("/MerchantExamine")
    @ResponseBody
    public void MerchantExamine(Integer id, HttpServletResponse response) {
        //根据id删除
        kn_admin knAdmim = new kn_admin();
        ListObject listObject = new ListObject();
        int i=memberService.deletebyIdMerchant(id);
        if (i> 0) {
            //查询商家有没有产品
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("删除成功!");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        } else {
            listObject.setMsg("删除失败!)");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }if(i==404){
            listObject.setMsg("商家有产品不能删除!)");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }

    }




    /**
     * 用户信息头像上传功能
     *
     * @param
     * @param
     * @return enctype="multipart/form-data"
     */
    @ApiOperation(value = "图片上传", httpMethod = "POST", response = StatusCode.class, notes = "图片上传")
    @RequestMapping("/addUserInfo")
    public void addUserInfo(HttpSession session,HttpServletResponse response,HttpServletRequest request) throws IOException {
        ListObject listObject = new ListObject();
        try {
            if(session.getAttribute("user")!=null){
                logger.info("进入上传");
            List lstt=new ArrayList();
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
                lstt.add(i);
                listObject.setItems(lstt);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
            }else{
                response.setHeader("refresh","1;URL=index.jsp");
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }






}
