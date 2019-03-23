package com.springmvc.controller.APP;

import com.github.pagehelper.StringUtil;
import com.springmvc.mapping.KnPropertyMapper;
import com.springmvc.mapping.LoanTermMapper;
import com.springmvc.mapping.MoneyInfoMapper;
import com.springmvc.pojo.MoneyInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.springmvc.service.kn_adminservice;
import com.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private MoneyInfoMapper moneyInfoMapper;
    @Autowired
    private LoanTermMapper loanTermMapper;
    @Autowired
    private KnPropertyMapper knPropertyMapper;
    @Autowired
    private kn_adminservice knAdminservice;

    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);

    @RequestMapping("/MoneyList")
    @ResponseBody
    public Map selectMoneyList() {
        Map map = new HashMap<>();
        List lstje = new ArrayList();
        lstje = moneyInfoMapper.selectAll();
        List lstqx = new ArrayList();
        lstqx = loanTermMapper.selectAll();
        List lstpx = new ArrayList();
        lstpx = knPropertyMapper.selectAll();
        map.put("cashAmount", lstje);
        map.put("deadLine", lstqx);
        map.put("compositeRank", lstpx);
        return map;
    }


    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    @ResponseBody
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map map = new HashMap();
        ListObject listObject = new ListObject();
        List lst=new ArrayList();
        try{
            String token2 = request.getHeader("Authorization");
            String token = token2.substring(7);
            logger.info("token截取后的值是：" + token);
            kn_admin kn_admin = new kn_admin();
            String id = TokenTest.ValidToken(token);
            Integer ids = Integer.parseInt(id);
            logger.info("ids有没有值" + ids);
            if (StringUtil.isNotEmpty(id) && !id.equals("")) {
                kn_admin = knAdminservice.selectUser(ids);
                lst.add(kn_admin);
                listObject.setItems(lst);
                listObject.setCode(StatusCode.CODE_SUCCESS);
                logger.info(""+kn_admin.getAddTime());
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
            if (id.equals("error")) {
//                System.out.println("token过期了");
                listObject.setCode(StatusCode.CODE_ERROR);
                listObject.setMsg("token过期了");
                logger.info("token过期了");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        }catch (NullPointerException e) {
            listObject.setMsg("token为空");
            listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }


    }

}