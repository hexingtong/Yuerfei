package com.springmvc.mapping;

import com.springmvc.pojo.Goodspvdata;
import com.springmvc.pojo.Goodsuvdata;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodsuvdataMapper extends Mapper<Goodsuvdata> {
    /**
     * Description：
     有则更新，无能插入pv，唯一索引goodid
     * @author boyang
     * @date 2019/3/26 15:00
     * @param
     * @return
     */
    Integer inUV(@Param(value = "list")List<Goodsuvdata> list);
    /**
     * Description：定时清空Uv
     * @author boyang
     * @date 2019/4/2 13:45
     * @param
     * @return
     */
    Integer deleUv();
}