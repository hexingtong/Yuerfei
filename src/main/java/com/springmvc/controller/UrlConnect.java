package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/url")
public class UrlConnect {

    //首页
    @RequestMapping("/indexUrl")
    public String index(){return "index";}
    //商户管理列表
    @RequestMapping("/GoodsUrl")
    public String Goods(){return"Goods";}
    //会员管理列表
    @RequestMapping("/MeberUrl")
    public String MeberUrl(){return "Meber";}
    //产品属性列表
    @RequestMapping("/goodsAuthbuteUrl")
    public String goodsAuthbute(){return"goodsAuthbute";}

    //标签展示列表
    @RequestMapping("/TagUrl")
    public String Tag(){return"Tag";}

    //商户展示列表
    @RequestMapping("/MerchantUrl")
    public String Merchant(){return"Merchant";}

    //超市展示列表
    @RequestMapping("/SupermarketUrl")
    public String Supermarket(){return"Supermarket";}

    //推广链接列表
    @RequestMapping("/GenerallzeUrl")
    public String Generallze(){return"Generallze";}

    //管理人员列表
    @RequestMapping("/MangerUrl")
    public String Manger(){return "Management";}


}
