package com.springmvc.controller;

import com.springmvc.mapping.BankCardMapper;
import com.springmvc.pojo.BankCard;
import com.springmvc.pojo.BankCategory;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.service.AllBankService;
import com.springmvc.service.BankCategoryService;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.util.JsonResult;
import com.util.StatusCode;
import com.util.shortUrl.FriendApiUtils;
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

/**
 * @ClassName AllBankCardController
 * @Description: 所有银行卡业务接口
 * @Author by
 * @Date: 2019/4/27 10:38
 **/
@Controller
@RequestMapping("/allBankCard")
public class AllBankCardController {
    @Autowired
    AllBankService allBankService;
    @Autowired
    BankCategoryService bankCategoryService;
    @Autowired
    BankCardMapper bankCardMapper;
    final Logger logger = LoggerFactory.getLogger(AllBankCardController.class);

    /**
     * Description：银行卡展示接口(分页)
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/27 10:40
     */
    @ApiOperation(value = "银行卡展示接口(分页)", httpMethod = "POST", response = StatusCode.class, notes = "银行卡展示接口(分页)")
    @RequestMapping("/getAllBankList")
    @ResponseBody
    public JsonResult getAllBankList(Model model, HttpServletResponse response,
                                     @RequestParam(value = "pageNo", defaultValue = "1",
                                             required = false)
                                             Integer pageNo,
                                     @RequestParam(value = "pageSize", defaultValue = "8", required = false)
                                             Integer pageSize,
                                     @RequestParam(value = "title", required = false)
                                             String title
    ) {
        logger.info("传入的pageno,pagesize,phone" + pageNo + ":" + pageSize + ":" + title);
        JsonResult jsonResult = new JsonResult();

        PageResultInfo resultInfo = null;
        try {
            resultInfo = allBankService.queryListBankCard(pageNo, pageSize, title);
            jsonResult.setData(resultInfo);
            jsonResult.setCode(StatusCode.SUCCESSFULLY);
        } catch (Exception e) {
            jsonResult.setCode(StatusCode.FAILED);
            e.printStackTrace();
        }
        return jsonResult;

    }

    /**
     * Description：银行卡新增接口
     * @param
     * @return
     * @author boyang
     * @date 2019/4/27 10:41
     */
    @ApiOperation(value = "银行卡新增接口", httpMethod = "POST", response = StatusCode.class, notes = "银行卡新增接口")
    @RequestMapping("/addBank")
    @ResponseBody
    public JsonResult addBank(Model model, HttpServletResponse response,@RequestBody BankCard bankCard) {
        logger.info("传入的bankCard"+bankCard.toString());
        JsonResult jsonResult = new JsonResult();
        if (bankCard != null) {
            allBankService.saveSelective(bankCard);
            jsonResult.setCode(StatusCode.SUCCESSFULLY);
        } else {
            jsonResult.setMessage("传入值为空");
        }
        return jsonResult;
    }

    /**
     * Description：银行卡删除接口
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/27 10:41
     */
    @ApiOperation(value = "银行卡删除接口", httpMethod = "POST", response = StatusCode.class, notes = "银行卡删除接口")
    @RequestMapping("/deleBank")
    @ResponseBody
    public JsonResult deleBank(Model model, HttpServletResponse response, Integer bankId) {
        logger.info("传入id{"+bankId+"}");
        JsonResult jsonResult = new JsonResult();
        try {
            allBankService.deleteById(bankId);
            jsonResult.setCode(StatusCode.SUCCESSFULLY);
        } catch (Exception e) {
            jsonResult.setCode(StatusCode.FAILED);
            e.printStackTrace();
        }
        return jsonResult;
    }
    /**
     * Description：银行卡编辑接口
     * @param
     * @return
     * @author boyang
     * @date 2019/4/27 10:41
     */
    @ApiOperation(value = "银行卡编辑接口", httpMethod = "POST", response = StatusCode.class, notes = "银行卡编辑接口")
    @RequestMapping("/modifiedBankCategory")
    @ResponseBody
    public JsonResult modifiedBankCategory(Model model, HttpServletResponse response,@RequestBody BankCard bankCard) {
        logger.info("传入BankCard{"+bankCard+"}");
        JsonResult jsonResult = new JsonResult();
        if (bankCard != null) {
            try {
                allBankService.updateSelectiveById(bankCard);
                jsonResult.setCode(StatusCode.SUCCESSFULLY);
            } catch (Exception e) {
                jsonResult.setCode(StatusCode.FAILED);
                e.printStackTrace();
            }
        } else {
            jsonResult.setMessage("传入为空");
        }
        return jsonResult;
    }
    /**
     * Description：获取银行分类接口返回id不限定
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/27 11:05
     */
    @ApiOperation(value = "获取银行分类接口", httpMethod = "POST", response = StatusCode.class, notes = "获取银行分类接口")
    @RequestMapping("/getBankCategory")
    @ResponseBody
    public JsonResult getBankCategory(Model model, HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult();
        try {
            List<BankCategory> bankCategories = bankCategoryService.queryAll();
            jsonResult.setData(bankCategories);
            jsonResult.setCode(StatusCode.SUCCESSFULLY);
        } catch (Exception e) {
            jsonResult.setCode(StatusCode.FAILED);
            e.printStackTrace();
        }
        return jsonResult;
    }
}
