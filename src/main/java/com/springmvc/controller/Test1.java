package com.springmvc.controller;

import com.springmvc.pojo.LoanTerm;
import com.springmvc.service.GoodsPvDataService;
import com.springmvc.service.kn_adminservice;
import com.springmvc.service.kn_goodsservice;
import com.util.IPutil;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Test")
public class Test1 {
    @Autowired
    private kn_adminservice knAdminservice;
@Autowired
private kn_goodsservice knGoodsservice;
@Autowired
    GoodsPvDataService goodsPvDataService;
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

    //测试puuv
    @RequestMapping("/uv")
    public void puuv(HttpServletRequest request){
        System.out.println("ninini");
        goodsPvDataService.unCountPv();
    }

}
