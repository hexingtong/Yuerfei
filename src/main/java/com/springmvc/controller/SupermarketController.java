package com.springmvc.controller;

import com.springmvc.pojo.*;
import com.springmvc.pojo.VO.GoodsSupermarketDvo;
import com.springmvc.service.FriendService;
import com.springmvc.service.FriendTimer;
import com.springmvc.service.kn_goodsservice;
import com.util.Https.HttpUtil;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import com.util.shortUrl.FriendApiUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value="产品展示controller",tags={"产品展示操作接口"})
@Controller
@RequestMapping("/Supermarke")
public class SupermarketController {

    final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private kn_goodsservice kn_goodsservice;

    @Autowired
    private FriendService friendService;


    final static String format="txt";
    final static String Url="https://12i.cn/api.ashx";
    final static String userId="3100";
    final static String key="3E457CECE7CD995CD2672DC76D876EC0";

    /**
     * @Author 苏俊杰
     * @Description //TODO 得到超市列表
     * @Date 14:15 2019/4/8
     * @Param [model, response, pageNo, pageSize, title, Index1, propertyId, status]
     * @return com.springmvc.pojo.PageResultInfo
     **/
    @ApiOperation(value = "得到产品列表", httpMethod = "POST", response = StatusCode.class, notes = "得到产品列表")
    @RequestMapping("/getSupermarket")
    @ResponseBody
    public PageResultInfo getDataList(Model model, HttpServletResponse response,
                                      @RequestParam(value = "pageNo", defaultValue = "1",
                                              required = false)
                                              Integer pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "3000", required = false)
                                              Integer pageSize,
                                      @RequestParam(value = "title", required = false)
                                              String title,
                                      @RequestParam(value = "Index1",defaultValue = "0", required = false)
                                              Integer Index1,
                                      @RequestParam(value = "propertyId",defaultValue = "0", required = false)
                                              Integer propertyId,
                                      @RequestParam(value = "status",defaultValue = "0", required = false)
                                              Integer status) {
        logger.info("传入的pageno,pagesize,title,Index1,propertyId,statusId"+pageNo+":"+pageSize+":"+title+":"+Index1+":"+propertyId+":"+status);
        PageResultInfo resultInfo = kn_goodsservice.queryGoods(pageNo,pageSize,title,Index1,propertyId,status);
        return resultInfo;
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 超市列表增加
     * @Date 14:15 2019/4/8
     * @Param [model, response, pageNo, pageSize, title, Index1, propertyId, status]
     * @return com.springmvc.pojo.PageResultInfo
     **/
    @ApiOperation(value = "产品页面增加", httpMethod = "POST", response = StatusCode.class, notes = "产品页面增加")
    @RequestMapping("/insertSupermarket")
    public void insertSupermarket(HttpServletResponse response,GoodsSupermarketDvo goodsSupermarketDvo){
        ListObject listObject=new ListObject();
        try {
            //生成6位短链接
            String frendSourcet=kn_goodsservice.getfrendSourcet();
            StringBuilder sb=new StringBuilder(frendSourcet);
            System.out.println("转换后的网址"+sb.toString());

            logger.info("控制层期限有没有值传进来"+goodsSupermarketDvo.getDeadline());
            logger.info("控制层期限区域有没有值传进来"+goodsSupermarketDvo.getPaceLending());
            logger.info("title"+goodsSupermarketDvo.getTitle());
            String shortshortUrl=FriendApiUtils.AddFriendApi(goodsSupermarketDvo.getUrl(),goodsSupermarketDvo.getTitle());
            System.out.println("传入的链接"+goodsSupermarketDvo.getUrl());
            if(!shortshortUrl.equals("error")&&!shortshortUrl.equals("禁止生成IP地址作为域名的网址")) {
                goodsSupermarketDvo.setShortUrl(shortshortUrl);
                goodsSupermarketDvo.setGoodsSource(frendSourcet);
                int i = kn_goodsservice.insertSupermarket(goodsSupermarketDvo);
                if (i > 0) {
                    listObject.setMsg("增加操作成功");
                    listObject.setCode(StatusCode.CODE_SUCCESS);
                    ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                } else {
                    listObject.setMsg("增加操作失败");
                    listObject.setCode(StatusCode.CODE_ERROR);
                    ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                }
            }else{
                listObject.setMsg("生成短链接失败");
                listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        }catch (Exception  e){
            listObject.setMsg("发生异常,事务回滚！");
            listObject.setCode("603");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            logger.info("增加超市接口事务发生异常,数据已回滚");
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 超市列表编辑
     * @Date 14:15 2019/4/8
     * @Param [model, response, pageNo, pageSize, title, Index1, propertyId, status]
     * @return com.springmvc.pojo.PageResultInfo
     **/
    @ApiOperation(value = "产品页面编辑", httpMethod = "POST", response = StatusCode.class, notes = "根据接收的参数编辑产品和产品详情")
    @RequestMapping("updateSupermarket")
    @ResponseBody
    public void updateSupermarket(HttpServletResponse response,GoodsSupermarketDvo goodsSupermarketDvo){
        logger.info("进入控制器"+goodsSupermarketDvo.getTitle());
        ListObject listObject=new ListObject();
        try {
            String shourtUrl=goodsSupermarketDvo.getShortUrl().substring(goodsSupermarketDvo.getShortUrl().length()- 6);
            logger.info("传入的原短链接"+goodsSupermarketDvo.getShortUrl());
            logger.info("截取的短链接"+shourtUrl);
            logger.info("传入的原链接"+goodsSupermarketDvo.getUrl());
            String folat=FriendApiUtils.UpdateFriendApi(goodsSupermarketDvo.getTitle(),goodsSupermarketDvo.getUrl(),shourtUrl);
            if(folat.equals("200")) {
                int i = kn_goodsservice.updateSupermarket(goodsSupermarketDvo);
                if (i > 0) {
                    listObject.setMsg("编辑操作成功!");
                    listObject.setCode(StatusCode.CODE_SUCCESS);
                    ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                } else {
                    listObject.setMsg("编辑操作失败");
                    listObject.setCode(StatusCode.CODE_ERROR);
                    ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                }
            }else{
                listObject.setMsg("编辑短链接失败");
                listObject.setCode(StatusCode.CODE_ERROR);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        }catch (Exception e){
            logger.info("发生异常");
            listObject.setMsg("编辑操作失败,发生异常");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 超市列表删除
     * @Date 14:15 2019/4/8
     * @Param [model, response, pageNo, pageSize, title, Index1, propertyId, status]
     * @return com.springmvc.pojo.PageResultInfo
     **/
    @ApiOperation(value = "产品页面删除", httpMethod = "POST", response = GoodsSupermarketDvo.class, notes = "根据封装类的数据删除详情表或者产品表")
    @RequestMapping("/delectSupermarket")
    public void deleteSuprmarket(HttpServletResponse response,GoodsSupermarketDvo goodsSupermarketDvo){
//        kn_goods kn_goods=kn_goodsservice.selectGoodsSK(goodsSupermarketDvo.getId());
        ListObject listObject=new ListObject();
        try {
            logger.info("进入删除短链接");
            String folat=FriendApiUtils.DelectFriendApi(goodsSupermarketDvo.getShortUrl());
            if(folat.equals("200")){
                System.out.println("最后结果成功");
                int i = kn_goodsservice.deleteSupermarket(goodsSupermarketDvo);
                if (i > 0) {
                    listObject.setMsg("删除操作成功!");
                    listObject.setCode(StatusCode.CODE_SUCCESS);
                    ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                } else {
                    listObject.setMsg("删除操作失败");
                    listObject.setCode(StatusCode.CODE_ERROR);
                    ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                }
            }
        }catch (Exception e){
            logger.info("发生异常");
            listObject.setMsg("删除操作失败,发生异常");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 超市链接图表跳转页面
     * @Date 13:54 2019/3/26
     * @Param
     * @return
     **/
    @ApiOperation(value = "获取超市链接图表数据接口", httpMethod = "POST", response = StatusCode.class, notes = "获取超市链接图表数据接口")
    @RequestMapping("/goodsImgx")
    public void FriendImg2(HttpServletResponse response,Integer id){
        System.out.println("id的值是"+id);
        ListObject listObject=new ListObject();
        if(id!=0||!id.equals("")) {
            kn_goods knGoods = kn_goodsservice.selectGoodsSK(id);
            Map map=new HashMap();
            String format = "day";
            Person[] person= FriendTimer.DatePvUv(knGoods.getShortUrl(),format);
            List<Person> lst=new ArrayList<>();
            for(int i=0;i<person.length;i++){
                lst.add(person[i]);
            }
            listObject.setItems(lst);
            listObject.setMsg("查询成功");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else {
            listObject.setMsg("查询失败");
            listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 根据短链接转发到真实路径
     * @Date 18:13 2019/4/12
     * @Param [request, mav, shortUrl]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @ApiIgnore()
    @RequestMapping("/{goodsSource}")
    public ModelAndView jumpLongLink(HttpServletRequest request, ModelAndView mav, @PathVariable("goodsSource")String goodsSource, kn_admin kn_admin){
        kn_goods kn_goods=new kn_goods();
        kn_goods.setGoodsSource(goodsSource);
        System.out.println("frendSource的值是*"+goodsSource);
        String longurl = kn_goodsservice.GoodsRestoreUrl(kn_goods);
        String  longUrl =longurl;
        Jedis jedis=new Jedis();
        //存入redis 如果没值就存入 然后加点击,有值就不加,
        String redisFolat=jedis.get(""+ kn_admin.getId()+goodsSource+"");
        if(StringUtils.isEmpty(redisFolat)){
            //添加推广链接的产品点击
            friendService.updateFriendPv(kn_admin.getFrendSource());
            //存入redis
            jedis.setex(""+kn_admin.getId()+goodsSource+"",86400,"1");
            mav.setViewName("redirect:" + longUrl);
            return mav;
        }else{
            mav.setViewName("redirect:" + longUrl);
            return mav;
        }
    }


}