package com.springmvc.controller;

import com.springmvc.pojo.kn_admin;
import com.springmvc.service.kn_adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public List<kn_admin> getList(HttpSession httpSession){

        List<kn_admin> lst =new ArrayList<kn_admin>();
        lst= knAdminservice.queryAll();
        httpSession.setAttribute("key",lst);

        return lst;
    }






}
