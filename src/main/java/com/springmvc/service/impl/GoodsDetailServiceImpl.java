package com.springmvc.service.impl;

import com.springmvc.mapping.GoodsDetailMapper;
import com.springmvc.pojo.GoodsDetail;
import com.springmvc.service.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName GoodsDetailServiceImpl
 * @Description:产品详情类
 * @Author by
 * @Date: 2019/3/8 16:57
 **/
@Service
public class GoodsDetailServiceImpl extends BaseServiceImpl<GoodsDetail> implements GoodsDetailService {

    @Autowired
    GoodsDetailMapper goodsDetailMapper;

    @Override
    public GoodsDetail selectDetail(int id) {
        GoodsDetail goodsDetail=goodsDetailMapper.selectDetail(id);
        return goodsDetail;
    }

}
