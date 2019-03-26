package com.springmvc.service.impl;

import com.springmvc.mapping.GoodspvdataMapper;
import com.springmvc.pojo.Goodspvdata;
import com.springmvc.service.GoodsPvDataService;
import com.util.pvDataUtuil.getCountPv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Goodspvdata> list=getCountPv.getPv();
        //更新数据
        for (Goodspvdata i:list){

        }
        return null;
    }
}
