package com.springmvc.mapping;

import com.springmvc.pojo.kn_goods;
import org.apache.ibatis.annotations.Param;
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


}
