package com.springmvc.controller;

import com.springmvc.pojo.Fund;

import com.springmvc.pojo.kn_tag;
import com.springmvc.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ApiIgnore()
@Controller
@RequestMapping("/Test")
public class Test1 {
    @Autowired
    private kn_adminservice knAdminservice;
    @Autowired
    private kn_goodsservice knGoodsservice;
    @Autowired
    GoodsPvDataService goodsPvDataService;

    @Autowired
    private FundService fundService;

    @Autowired
    private KnTagService kntagService;

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

    @RequestMapping("/x")
    public void xxx(String i){
//        Map map=new HashMap();
//        System.out.println("id的值是"+id);
//        kn_tag kntag=kntagService.selectByidTag(id);
//        System.out.println("xxx"+kntag.getTitle());
        System.out.println("i的值是-->"+i);
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

//    @RequestMapping("/supermarkData")
//    public String toEdit(Model model, Integer id) {
//        System.out.println("进入supermarkda+" + id);
////        List list=new ArrayList();
////        list=  kngoodsservice.queryAll();
////        kn_goods kn_goods= (kn_goods) list.get(0);
//        kn_goods kn_goods = kngoodsservice.queryById(id);
//        model.addAttribute("kn_goods", kn_goods);
//        return "supermarkData";
//    }


    @RequestMapping("/{shortUrl}")
    public ModelAndView jumpLongLink(HttpServletRequest request, ModelAndView mav, @PathVariable("shortUrl")String shortUrl) {
//
//        String longUrl = "";
//        String longurl = shorturlService.restoreUrl(shortUrl);
//
//        if (longUrl!=null) {
//
//            longUrl = longurl;
//        }
//        mav.setViewName("redirect:" + longUrl);
        return mav;
    }


}
