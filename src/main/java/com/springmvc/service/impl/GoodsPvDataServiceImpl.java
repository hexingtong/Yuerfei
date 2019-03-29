package com.springmvc.service.impl;

import com.springmvc.mapping.GoodspvdataMapper;
import com.springmvc.pojo.Goodspvdata;
import com.springmvc.service.GoodsPvDataService;
import com.util.pvDataUtuil.getCountPv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.client.exception.OceanException;
import com.springmvc.controller.MemberController;
import com.springmvc.pojo.Goodspvdata;
import com.springmvc.pojo.VO.paramInfos;
import com.umeng.uapp.param.*;
import org.jsoup.helper.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ClassName GoodsPvDataServiceImpl
 * @Description: 用来更新gongspv
 * @Author by
 * @Date: 2019/3/22 15:51
 **/
@Service
public class GoodsPvDataServiceImpl  extends BaseServiceImpl<Goodspvdata> implements GoodsPvDataService{

@Autowired
    GoodspvdataMapper goodspvdataMapper;

    @Override
    public Integer unCountPv() {
//得到总的pv
        List<Goodspvdata> list=getCountPv.getPv();
        //更新数据
        int i;
        if (list!=null){
           i= goodspvdataMapper.INPV(list);
            if (i>0){
                return 1;
            }
        }else {
            return -1;
        }
        return 0;
    }
}
