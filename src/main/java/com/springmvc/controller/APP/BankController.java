package com.springmvc.controller.APP;

import com.springmvc.mapping.BankCardMapper;
import com.springmvc.mapping.BankCategoryMapper;
import com.springmvc.pojo.BankCard;
import com.springmvc.pojo.BankCategory;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.service.BankCardService;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.util.JsonResult;
import com.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName BankController
 * @Description: 银行卡业务接口
 * @Author by
 * @Date: 2019/4/23 9:57
 **/
@Api(value="银行卡页面controller",tags={"银行卡操作接口"})
@Controller
@RequestMapping("/Bank")
public class BankController {
        @Autowired
        BankCategoryMapper bankCategoryMapper;
        @Autowired
    BankCardService bankCardService;
    final Logger logger = LoggerFactory.getLogger(BankController.class);
    /**
     * Description： 得到所有银行卡分类接口
     * @param
     * @return
     * @author boyang
     * @date 2019/4/23 11:13
     */
    @ApiOperation(value = "银行卡分类接口", httpMethod = "POST", response = StatusCode.class, notes = "银行卡分类接口")
        @RequestMapping("/bankClassify")
    @ResponseBody
    public JsonResult getBankClassify() {
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult.setData(bankCategoryMapper.selectAll());
        } catch (Exception e) {
            jsonResult.setCode(StatusCode.CODE_ERROR);
            jsonResult.setMessage("获取错误");
            e.printStackTrace();
        }
        jsonResult.setCode(StatusCode.CODE_SUCCESS);
        jsonResult.setResult(JsonResult.ResultStatus.success);
        return jsonResult;
    }

    /**
     * Description： 分页得到银行卡列表排除广告位
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/23 11:19
     */
    @ApiOperation(value = "分页得到所有银行卡列表接口", httpMethod = "POST", response = StatusCode.class, notes = "分页得到所有银行卡列表接口")
    @RequestMapping("/getPageBankList")
    @ResponseBody
    public JsonResult getPageBankList(Model model,
                                          @RequestParam(value = "pageNo", defaultValue = "1",
                                                  required = false)
                                                  Integer pageNo,
                                          @RequestParam(value = "pageSize", defaultValue = "8", required = false)
                                                  Integer pageSize) {

        logger.info("传入的pageno,pagesize,phone" + pageNo + ":" + pageSize);
        JsonResult jsonResult = new JsonResult();

        PageResultInfo resultInfo = null;
        try {
            resultInfo = bankCardService.queryBankList(pageNo,pageSize);
            jsonResult.setCode(StatusCode.SUCCESSFULLY);
            jsonResult.setData(resultInfo);
        } catch (Exception e) {
            jsonResult.setCode(StatusCode.FAILED);
            e.printStackTrace();
        }

        return jsonResult;

    }

    /**
     * Description： 得到银行卡广告位接口
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/23 11:21
     */
    @ApiOperation(value = "得到银行卡广告位接口", httpMethod = "POST", response = StatusCode.class, notes = "得到银行卡广告位接口")
    @RequestMapping("/getAdvertising")
    @ResponseBody
    public JsonResult getAdvertising(
    ) {   List<BankCard> list = null;

        JsonResult jsonResult = new JsonResult();
        try {
          list= bankCardService.getBankadvertisingList();
        } catch (Exception e) {
            jsonResult.setCode(StatusCode.CODE_SUCCESS);
            jsonResult.setMessage("查询失败");
            e.printStackTrace();
        }
        jsonResult.setCode(StatusCode.CODE_SUCCESS);
        jsonResult.setData(list);
        return jsonResult;
    }

    /**
     * Description： 传入分类id得到对应的银行卡
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/23 11:21
     */
    @ApiOperation(value = "分类取卡接口", httpMethod = "POST", response = StatusCode.class, notes = "分类取卡接口")
    @RequestMapping("/getAdvertisingCard")
    @ResponseBody
    public JsonResult getAdvertisingCard(@RequestParam(value = "pageNo", defaultValue = "1",
            required = false) Integer pageNo,
                                         @RequestParam(value = "pageSize", defaultValue = "8", required = false)
                                                 Integer pageSize,Integer bankId) {
        JsonResult jsonResult = new JsonResult();
        PageResultInfo resultInfo = null;
        try {
            resultInfo = bankCardService.queryBankById(pageNo,pageSize,bankId);
            jsonResult.setCode(StatusCode.SUCCESSFULLY);
            jsonResult.setData(resultInfo);
        } catch (Exception e) {
            jsonResult.setCode(StatusCode.FAILED);
            e.printStackTrace();
        }
        return jsonResult;
    }
}
