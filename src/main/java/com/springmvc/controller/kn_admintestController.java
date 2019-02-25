package com.springmvc.controller;

import com.springmvc.pojo.kn_admin;
import com.springmvc.service.kn_adminservice;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class kn_admintestController {
    @Autowired
    private kn_adminservice knAdminservice;

    @RequestMapping("/admi")
    @ResponseBody
    public void getList(Integer id, HttpServletResponse response){

        List<kn_admin> lst =new ArrayList<kn_admin>();
        kn_admin admin=  knAdminservice.queryList(id);
        lst.add(admin);
        ListObject listObject =new ListObject();
        listObject.setItems(lst);
        listObject.setCode(StatusCode.CODE_SUCCESS);
        listObject.setMsg("访问成功");
        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));


    }



}
