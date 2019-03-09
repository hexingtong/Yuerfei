package com.springmvc.controller;

import com.springmvc.service.kn_adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Test1 {
    @Autowired
    private kn_adminservice knAdminservice;

}
