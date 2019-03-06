package com.springmvc.controller;

import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName MemberController
 * @Description:会员借口
 * @Author by
 * @Date: 2019/3/6 9:15
 **/
@Controller
@RequestMapping("/Member")
public class MemberController {
    @Autowired
    MemberService memberService;

/**
 * Description：得到商家列表
 * @author boyang
 * @date  11:21
 * @param [model, response, pageNo：当前页, pageSize：页容量]
 * @return com.springmvc.pojo.PageResultInfo
 */
    @RequestMapping("/getList")
    @ResponseBody
    public PageResultInfo getDataList(Model model, HttpServletResponse response,
                                      @RequestParam(value = "pageNo", defaultValue = "1",
                                              required = false)
                                              Integer pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "5", required = false)
                                              Integer pageSize) {

       PageResultInfo resultInfo= memberService.queryListAdmin(pageNo, pageSize);

        return resultInfo;


    }

}
