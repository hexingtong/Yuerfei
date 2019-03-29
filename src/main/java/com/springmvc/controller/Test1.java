package com.springmvc.controller;

import com.springmvc.pojo.Fund;
import com.springmvc.pojo.LoanTerm;
import com.springmvc.pojo.kn_goods;
import com.springmvc.service.FundService;
import com.springmvc.service.kn_adminservice;
import com.springmvc.service.kn_goodsservice;
import com.util.IPutil;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Test")
public class Test1 {
    @Autowired
    private kn_adminservice knAdminservice;
@Autowired
private kn_goodsservice knGoodsservice;

    @Autowired
    private FundService fundService;

    @Autowired
    private kn_goodsservice kngoodsservice;
    @RequestMapping("/xx")
    public String xx(HttpServletRequest request){
        List<Fund> lst=new ArrayList<>();
        Fund fund=new Fund();
        for(int i=0;i<1000;i++){
            fund.setTitle(i+"你好");
            lst.add(fund);
            System.out.println(""+i);
        }
        int i=fundService.insertCollectList(lst);
        System.out.println("总共插入--------->"+i+"<---------条数据");
        return ""+i+"";
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

    @RequestMapping("/supermarkData")
    public String toEdit(Model model, Integer id){
        System.out.println("进入supermarkda+"+id);
//        List list=new ArrayList();
//        list=  kngoodsservice.queryAll();
//        kn_goods kn_goods= (kn_goods) list.get(0);
        kn_goods kn_goods=   kngoodsservice.queryById(id);
        model.addAttribute("kn_goods", kn_goods);
        return "supermarkData";
    }

}
