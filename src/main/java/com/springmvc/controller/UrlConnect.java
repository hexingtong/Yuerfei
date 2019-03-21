package com.springmvc.controller;

import com.springmvc.mapping.kn_goodsMapper;
import com.springmvc.pojo.kn_goods;
import com.springmvc.service.kn_adminservice;
import com.springmvc.service.kn_goodsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/url")
public class UrlConnect {

    @Autowired
    private kn_goodsservice kn_goodsservice;

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

    //标签编辑页面
    @RequestMapping("/TagEditor")
    public String labelEditor(@ModelAttribute("id")String param){
        param="labelEditor";
        return param;}
        //标签增加页面
    @RequestMapping("/TagAdd")
    public String addEditor(){
        return "labelAdd";
    }
    //商户展示列表
    @RequestMapping("/MerchantUrl")
    public String Merchant(){return"Merchant";}

    //超市展示列表
    @RequestMapping("/SupermarketUrl")
    public String Supermarket(){return"Supermarket";}

    //超市编辑列表
    @RequestMapping("/SupermarketUpdate")
    public String SupermarketUpdate(Model model, Integer id){
        kn_goods goods=kn_goodsservice.selectGoodsSK(id);
        model.addAttribute("goods", goods);
        System.out.println(goods.getImg());
        System.out.println(goods.getTitle());
        return "supermarketEditor";}
    @RequestMapping("/SupermarketAdd")
    public String SupermarketAdd(){
        return "supermarketAdd";}

    //超市删除列表
    @RequestMapping("/SupermarketDelete")
    public String SupermarketDelete(){return "supermarketAdd";}


    //推广链接列表
    @RequestMapping("/GenerallzeUrl")
    public String Generallze(){return"Generallze";}
    //推广链接编辑
    @RequestMapping("/GenerallzeUpdate")
    public String GenerallzeUpdate(@ModelAttribute("id")String param){
        param="promoteEditor";
        return param;
    }

    //管理人员列表
    @RequestMapping("/MangerUrl")
    public String Manger(){return"Manger";}


}
