package com.springmvc.controller;

import com.springmvc.pojo.kn_friend;
import com.springmvc.pojo.kn_goods;
import com.springmvc.service.FriendService;
import com.springmvc.service.FriendTimer;
import com.springmvc.service.kn_goodsservice;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/url")
public class UrlConnect {

    @Autowired
    private kn_goodsservice kn_goodsservice;

    @Autowired
    private FriendService friendService;

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
    public String GenerallzeUpdate(Model model, Integer id){
        kn_friend kn_friend=friendService.selectFrilend(id);
        model.addAttribute("knfriend", kn_friend);

        System.out.println(kn_friend.getClick());
        System.out.println(kn_friend.getTitle());

        return "promoteEditor";
    }
    @RequestMapping("/GenerallzeInsert")
    public String GenerallzeInsert(){
        return "promoteAdd";
    }

    //管理人员列表
    @RequestMapping("/MangerUrl")
    public String Manger(){return"Management";}
    //到超市数据展示
    @RequestMapping("/supermarkData")
    public String supermarkData(){return"supermarkData";}


//    //到超市数据展示
//    @RequestMapping("/supermarkData")
//    public String supermarkData(){return"supermarkData";}
    @RequestMapping("/FriendChat")
    public String FriendChat(){return "FriendChart";}

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广链接图表跳转页面
     * @Date 13:54 2019/3/26
     * @Param
     * @return
     **/
    @RequestMapping("/FriendImg")
    public String FriendImg(Model model,Integer id){
        System.out.println("id的值是"+id);
        if(id==0||id.equals("")) {
            kn_friend kn_friend = friendService.selectFrilend(id);
            Map map=new HashMap();
            String format = "day";
            JSONObject jsonObject=FriendTimer.DatePvUv(kn_friend.getUrl(),format);
            String jsonId=jsonObject.get("id").toString();
            String jsonDay=jsonObject.get("day").toString();
            String jsonVisitCount=jsonObject.get("visitCount").toString();
            String jsonUv=jsonObject.get("uv").toString();
            System.out.println("jsonId的值"+jsonId);
            map.put("Id",jsonDay);
            map.put("Day",jsonId);
            map.put("VisitCount",jsonVisitCount);
            map.put("Id",jsonId);
            map.put("Uv",jsonUv);
            model.addAttribute("jsonData",map);
            return "knFriendImg";
        }
        return "knFriendImg";
    }

}
