package com.springmvc.mapping;

import com.springmvc.pojo.GoodsDetail;
import tk.mybatis.mapper.common.Mapper;

public interface GoodsDetailMapper extends Mapper<GoodsDetail>{


    /**
     * 插入详情表后返回主键id
     */
    int insertGoodsDetailMapper(GoodsDetail goodsDetail);

    /*
     * @Author 苏俊杰
     * @Description //TODO 查询详情信息
     * @Date 15:38 2019/4/4
     * @Param
     * @return
     **/
    GoodsDetail selectDetail(int id);

}