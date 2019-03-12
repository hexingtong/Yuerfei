package com.springmvc.mapping;

import com.springmvc.pojo.kn_goods;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 产品类
 */
public interface kn_goodsMapper extends Mapper<kn_goods> {

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
    List<kn_goods> queryGoodsList(kn_goods kn_goods);
    /**
     * Description：通过id得到商品详情id
     * @author boyang
     * @date 2019/3/8 17:46
     * @param
     * @return
     */
    int getDetailId(Integer id);

    /**
     * Description：模糊查找含有精选的商品
     * @author boyang
     * @date 2019/3/12 12:31
     * @param
     * @return
     */
    List<kn_goods> queryByTagid();
}
