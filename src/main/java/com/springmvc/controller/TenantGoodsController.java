package com.springmvc.controller;

import com.springmvc.pojo.JsonModel;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.service.GoodsDetailService;
import com.springmvc.service.kn_goodsservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TenantGoodsController
 * @Description:
 * @Author by
 * @Date: 2019/3/7 17:25
 **/
@ApiIgnore()
@Controller
@RequestMapping("/tenantGoods")
public class TenantGoodsController {
    final Logger logger = LoggerFactory.getLogger(TenantGoodsController.class);

    @Autowired
    kn_goodsservice knGoodsservice;
    @Autowired
    GoodsDetailService goodsDetailService;
    /**
     * Description：得到商家列表
     *
     * @param , response, pageNo：当前页, pageSize：页容量,title:产品名称，Index1排序方式，propertyId产品属性，statusId审核状态
     * @return com.springmvc.pojo.PageResultInfo
     * @author boyang
     * @date 11:21
     */
    @RequestMapping("/getList")
    @ResponseBody
    public PageResultInfo getDataList(Model model, HttpServletResponse response,
                                      @RequestParam(value = "pageNo", defaultValue = "1",
                                              required = false)
                                              Integer pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "4", required = false)
                                              Integer pageSize,
                                      @RequestParam(value = "title", required = false)
                                              String title,
                                      @RequestParam(value = "Index1",defaultValue = "0", required = false)
                                                  Integer Index1,
                                      @RequestParam(value = "propertyId",defaultValue = "0", required = false)
                                                  Integer propertyId,
                                      @RequestParam(value = "statusId",defaultValue = "0", required = false)
                                                  Integer statusId) {
        logger.info("传入的pageno,pagesize,title,Index1,propertyId,statusId"+pageNo+":"+pageSize+":"+title+":"+Index1+":"+propertyId+":"+statusId);

        PageResultInfo resultInfo = knGoodsservice.queryGoodsList(pageNo,pageSize,title,Index1,propertyId,statusId);
        return resultInfo;


    }


    /**
     * Description：删除商产品
     * @author boyang
     * @date 2019/3/8 16:09
     * @param
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonModel delete(Integer id) {
        logger.info("传入id"+id);
String ERRO="";
JsonModel jsonModel=new JsonModel();
        try {
            Integer DetailId= knGoodsservice.getDetailId(id);
          if (DetailId!=null){
              logger.info("传入id"+DetailId);
              goodsDetailService.deleteById(DetailId);
          }
            knGoodsservice.deleteById(id);
        } catch (Exception e) {
            ERRO="删除失败";
            jsonModel.setCode(JsonModel.FAILED);
            jsonModel.setMessage(ERRO);
         e.printStackTrace();
        }
        jsonModel.setCode(JsonModel.SUCCESS);
        jsonModel.setMessage("删除成功");
        return jsonModel;
    }

}
