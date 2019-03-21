package com.springmvc.mapping;

import com.springmvc.pojo.GoodsDetail;
import tk.mybatis.mapper.common.Mapper;

public interface GoodsDetailMapper extends Mapper<GoodsDetail>{


    /**
     * 插入详情表后返回主键id
     */
    int insertGoodsDetailMapper(GoodsDetail goodsDetail);



}