package com.springmvc.service;

import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_goods;

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

    /**
     * Description：得到商家产品列表
     *
     * @param , response, pageNo：当前页, pageSize：页容量,title:产品名称，Index1排序方式，propertyId产品属性，statusId审核状态
     * @return com.springmvc.pojo.PageResultInfo
     * @author boyang
     * @date 11:21
     */
    PageResultInfo queryGoodsList(Integer pageNo, Integer pageSize, String title, Integer Index1, Integer propertyId, Integer statusId);
    /**
     * Description：通过id得到商品详情id
     * @author boyang
     * @date 2019/3/8 17:46
     * @param
     * @return
     */
    Integer getDetailId(Integer id);
    //根据
    int queryMerchantId(Integer id);

    int delectMerchant(Integer id);
}
