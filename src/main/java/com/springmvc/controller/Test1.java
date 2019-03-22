package com.springmvc.controller;

import com.springmvc.pojo.LoanTerm;
import com.springmvc.service.kn_adminservice;
import com.util.IPutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin4")
public class Test1 {
    @Autowired
    private kn_adminservice knAdminservice;

    @RequestMapping("/xx")
    public String xx(HttpServletRequest request){
//        String bs = IPutil.isClient(request);
        return "index";
    }

//    @RequestMapping("/test")
//    public void test(String term,int id){
//        try {
//            LoanTerm loanTerm=new LoanTerm();
//            loanTerm.setId(id);
//            loanTerm.setTerm(term);
//            knAdminservice.instTest(loanTerm);
//        }catch (Exception e){
//            System.out.println("发生异常");
//        }
//
//    }
}
