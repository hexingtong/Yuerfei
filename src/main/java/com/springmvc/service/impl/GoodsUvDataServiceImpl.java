package com.springmvc.service.impl;

import com.springmvc.mapping.GoodsuvdataMapper;
import com.springmvc.pojo.Goodsuvdata;
import com.springmvc.service.GoodsUvDataService;
import com.util.pvDataUtuil.getCountPv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GoodsUvDataServiceImpl
 * @Description:
 * @Author by
 * @Date: 2019/3/22 15:53
 **/
@Service
public class GoodsUvDataServiceImpl  extends  BaseServiceImpl<Goodsuvdata> implements GoodsUvDataService {
@Autowired
    GoodsuvdataMapper goodsuvdataMapper;
    @Override
    public Integer unCountUv() {
        List<Goodsuvdata> list= getCountPv.getUv();
        //更新数据
        int i;
        if (list!=null){
            i= goodsuvdataMapper.inUV(list);
            if (i>0){
                return 1;
            }
        }else {
            return -1;
        }
        return 0;
    }

    @Override
    public Integer deleUv() {
      int i=  goodsuvdataMapper.deleUv();
        return i;
    }
}
