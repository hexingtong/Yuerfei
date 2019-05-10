package com.springmvc.controller;

import com.springmvc.pojo.ArticeSupper;
import com.springmvc.pojo.BankCard;
import com.springmvc.pojo.BankCategory;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.service.BankCardService;
import com.springmvc.service.BankCategoryService;
import com.util.JsonResult;
import com.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Api(value="银行类别页面controller",tags={"银行类别操作接口"})
@Controller
@RequestMapping("/bankCategory")
public class BankCategoryController {

    @Autowired
    BankCategoryService bankCategoryService;

    @Autowired
    BankCardService bankCardService;


//    /**
//     * @Author 苏俊杰
//     * @Description //TODO 银行展示列表
//     * @Date 11:24 2019/4/27
//     * @Param
//     * @return
//     **/
//    @ApiOperation(value = "获取银行展示列表", httpMethod = "POST", response = ArticeSupper.class, notes = "获取银行展示列表")
//    @RequestMapping(value = "/selectAllList",method = RequestMethod.POST)
//    @ResponseBody
//    public JsonResult selectAllBankCategory(@RequestParam(value = "pageNo", defaultValue = "1",
//            required = false)
//                                                        Integer pageNo,
//                                            @RequestParam(value = "pageSize", defaultValue = "5", required = false)
//                                                        Integer pageSize, BankCategory bankCategory){
//        JsonResult result=new JsonResult();
//        PageResultInfo pageResultInfo=bankCategoryService.selectAllBankCategory(pageNo,pageSize,bankCategory);
//        if(pageResultInfo.getTotal()==0){
//            result.setCode(StatusCode.CODE_NULL);
//            result.setMessage("is ok,but no result");
//        }else {
//            result.setCode(StatusCode.SUCCESSFULLY);
//            result.setData(pageResultInfo);
//        }
//        return  result;
//
//    }


    /**
     * @Author 苏俊杰
     * @Description //TODO 银行展示列表
     * @Date 11:24 2019/4/27
     * @Param
     * @return
     **/
    @ApiOperation(value = "获取银行展示列表", httpMethod = "POST", response = BankCategory.class, notes = "name(银行名称) img(银行图片) welfare(银行福利) " +
            "speed(发卡速度) banklimit(额度) passrate(通过率) shorturl(网址)")
    @RequestMapping(value = "/selectAllList",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectAllBankCategory(@RequestParam(value = "pageNo", defaultValue = "1",
            required = false)
                                                    Integer pageNo,
                                            @RequestParam(value = "pageSize", defaultValue = "5", required = false)
                                                    Integer pageSize, BankCategory bankCategory){
        JsonResult result=new JsonResult();
        PageResultInfo pageResultInfo=bankCategoryService.selectAllBankCategory(pageNo,pageSize,bankCategory);
        if(pageResultInfo.getTotal()==0){
            result.setCode(StatusCode.CODE_NULL);
            result.setMessage("is success,but no result");
            return  result;
        }else {
            result.setCode(StatusCode.SUCCESSFULLY);
            result.setMessage("is ok");
            result.setData(pageResultInfo);
            return result;
        }
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 增加银行类别
     * @Date 14:29 2019/4/27
     * @Param [bankCategory]
     * @return com.util.JsonResult
     **/
    @ApiOperation(value = "增加银行类别", httpMethod = "POST", response = BankCategory.class, notes = "name(银行名称) img(银行图片) welfare(银行福利) " +
            "speed(发卡速度) banklimit(额度) passrate(通过率) shorturl(网址)")
    @RequestMapping("/insertBankCategory")
    @ResponseBody
    public JsonResult insertBankCategory(BankCategory bankCategory) {
        JsonResult result = new JsonResult();
        bankCategory.setAddtime(new Date());
        int i = bankCategoryService.insertBankCategory(bankCategory);
        if (i>0) {
            result.setMessage("is success");
            result.setCode(StatusCode.SUCCESSFULLY);
            return result;
        } else {
            result.setMessage("Maybe Parameter Exception");
            result.setCode(StatusCode.FAILED);
            return result;
        }
    }
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 删除银行分类
     * @Date 15:00 2019/4/27
     * @Param []
     * @return com.util.JsonResult
     **/
    @ApiOperation(value = "删除银行类别", httpMethod = "POST", response = BankCategory.class, notes = "参数 id")
    @RequestMapping("/deleteBankCategory")
    @ResponseBody
    public JsonResult deleteBankCategory(BankCategory bankCategory){
        //删除银行卡之前 先查询有没有这个分类 有就不删除 没就删除
        JsonResult result=new JsonResult();
        BankCard bankCard=new BankCard();
        bankCard.setCardcategoryid(bankCategory.getId());
        long i=bankCardService.queryCountByWhere(bankCard);
        if(i>0){
            result.setCode(StatusCode.FAILED);
            result.setMessage("不能删除,因为它下面有银行卡");
            return result;
        }else {
            try {
                bankCategoryService.deleteById(bankCategory.getId());
                result.setCode(StatusCode.SUCCESSFULLY);
                result.setMessage("is success");
                return result;
            }catch (Exception e){
                result.setCode(StatusCode.FAILED);
                result.setMessage("is Exception!");
                return result;
            }
        }
    }

    @ApiOperation(value = "编辑银行类别", httpMethod = "POST", response = BankCategory.class, notes = "id name(银行名称) img(银行图片) welfare(银行福利) " +
                "speed(发卡速度) banklimit(额度) passrate(通过率) shorturl(网址)")
    @RequestMapping("/updateBankCategory")
    @ResponseBody
    public JsonResult updateBamkCategory(BankCategory bankCategory){
        JsonResult result=new JsonResult();
        try {
            bankCategoryService.updateSelectiveById(bankCategory);
            result.setMessage("is success");
            result.setCode(StatusCode.SUCCESSFULLY);
            return result;
        }catch (Exception e){
            result.setCode(StatusCode.FAILED);
            e.printStackTrace();
            result.setMessage("is Exception");
            return result;
        }
    }


}
