package com.springmvc.controller;

import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.VO.GoodsSupermarketDvo;
import com.springmvc.pojo.kn_goods;
import com.springmvc.service.kn_goodsservice;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/Supermarke")
public class SupermarketController {

    final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private kn_goodsservice kn_goodsservice;

   
    /**
     * @Author 苏俊杰
     * @Description //TODO 得到超市列表
     * @Date 14:15 2019/4/8
     * @Param [model, response, pageNo, pageSize, title, Index1, propertyId, status]
     * @return com.springmvc.pojo.PageResultInfo
     **/
    @ApiOperation(value = "得到超市列表", httpMethod = "POST", response = StatusCode.class, notes = "得到超市列表")
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
    @ApiOperation(value = "超市页面增加", httpMethod = "POST", response = StatusCode.class, notes = "超市页面增加")
    @RequestMapping("/insertSupermarket")
    public void insertSupermarket(HttpServletResponse response,GoodsSupermarketDvo goodsSupermarketDvo){
        ListObject listObject=new ListObject();
        try {
            logger.info("控制层期限有没有值传进来"+goodsSupermarketDvo.getDeadline());
            logger.info("控制层期限区域有没有值传进来"+goodsSupermarketDvo.getPaceLending());
            int i=kn_goodsservice.insertSupermarket(goodsSupermarketDvo);
            if(i>0){
                listObject.setMsg("增加操作成功");
                listObject.setCode(StatusCode.CODE_SUCCESS);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }else {
                listObject.setMsg("增加操作失败");
                listObject.setCode(StatusCode.CODE_ERROR);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        }catch (Exception  e){
            listObject.setMsg("发生异常,事务回滚！");
            listObject.setCode(StatusCode.CODE_ERROR);
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
    @ApiOperation(value = "超市页面编辑", httpMethod = "POST", response = StatusCode.class, notes = "根据接收的参数编辑产品和产品详情")
    @RequestMapping("updateSupermarket")
    @ResponseBody
    public void updateSupermarket(HttpServletResponse response,GoodsSupermarketDvo goodsSupermarketDvo){
        logger.info("进入控制器"+goodsSupermarketDvo.getTitle());
        ListObject listObject=new ListObject();
        try {
            int i=kn_goodsservice.updateSupermarket(goodsSupermarketDvo);
            if(i>0){
                listObject.setMsg("编辑操作成功!");
                listObject.setCode(StatusCode.CODE_SUCCESS);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }else {
                listObject.setMsg("编辑操作失败");
                listObject.setCode(StatusCode.CODE_ERROR);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        }catch (NullPointerException e){
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
    @ApiOperation(value = "超市页面删除", httpMethod = "POST", response = StatusCode.class, notes = "超市页面删除")
    @RequestMapping("/delectSupermarket")
    public void deleteSuprmarket(HttpServletResponse response,GoodsSupermarketDvo goodsSupermarketDvo){
        kn_goods kn_goods=kn_goodsservice.selectGoodsSK(goodsSupermarketDvo.getId());
        goodsSupermarketDvo.setDetailsId(kn_goods.getDetailsId());
        logger.info("控制器传进来的值是+"+goodsSupermarketDvo.getDetailsId());
        ListObject listObject=new ListObject();
        try {

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
        }catch (Exception e){
            logger.info("发生异常");
            listObject.setMsg("删除操作失败,发生异常");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }


}
