package com.springmvc.service;

import com.springmvc.pojo.kn_goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Description：
 * @author boyang
 * @date 2019/2/27 15:01
 * @param
 * @return
 */
public interface kn_goodsservice extends  BaseService<kn_goods>{


    /**
     * Description：
     * 查询商品详情接口
     * 通过排序级别排序
     *
     * @param , pageSize, id]
     * @return java.util.List<com.springmvc.pojo.kn_goods>
     * @author boyang
     * @date 2019/2/27 14:27
     */
    List<kn_goods> getGoodsList();




}
