package com.springmvc.controller;

import com.springmvc.pojo.JsonModel;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.MemberService;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MemberController
 * @Description:会员接口
 * @Author by
 * @Date: 2019/3/6 9:15
 **/
@Controller
@RequestMapping("/Member")
public class MemberController {
    final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService memberService;

    /**
     * Description：得到商家列表
     *
     * @param , response, pageNo：当前页, pageSize：页容量]
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
                                      @RequestParam(value = "pageSize", defaultValue = "3", required = false)
                                              Integer pageSize,
                                      @RequestParam(value = "phone", defaultValue = "null", required = false)
                                                  String phone) {
        logger.info("传入的pageno,pagesize,phone"+pageNo+":"+pageSize+":"+phone);
        PageResultInfo resultInfo = memberService.queryListAdmin(pageNo, pageSize,phone);
        return resultInfo;


    }

    /**
     * Description：通过用户id删除商家信息
     *
     * @return
     * @author boyang
     * @date 2019/3/6 11:50
     * @param: 传入商户的id
     */
    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public JsonModel delete(Integer id) {
        logger.info("传入用户id：" + "{" + id + "}");
        String erro = "";
        try {
            memberService.deleteById(id);
        } catch (Exception e) {
            logger.info("代码异常");
            e.printStackTrace();
            erro = "接口异常";
            return new JsonModel(JsonModel.FAILED, erro);
        }
        logger.info("删除成功");
        return new JsonModel(JsonModel.SUCCESS);
    }

    /**
     * Description：编辑接口根据id来修改手机号码
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/3/6 14:43
     */
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public JsonModel updateAdmin(Integer id, String phone) {
        logger.info("传入用户id,pone" + "{" + id + ":" + phone + "}");
        String erro = "";
        try {
            memberService.updateByPrimaryKeySelective(id, phone);
        } catch (Exception e) {
            erro = "更新异常";
            e.printStackTrace();
            return new JsonModel(JsonModel.FAILED, erro);
        }
        return new JsonModel(JsonModel.SUCCESS);

    }

    /**
     * Description：会员手机号码搜索接口
     * @author boyang
     * @date 2019/3/6 19:20
     * @param
     * @return
     */
    @RequestMapping("/selectPhoneList")
    @ResponseBody
    public List<kn_admin> selectPhoneList(String phone) {
        logger.info("传入查询的手机号"+phone);
        List list=new ArrayList();
         if (phone!=null){
             list=  memberService.selectPhoneList(phone);
             logger.info("返回数据"+list);
             return  list;
        }else {
             logger.info("没有数据返回");
             return null;

         }

    }


}
