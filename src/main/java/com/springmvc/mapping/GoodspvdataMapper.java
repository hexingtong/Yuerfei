package com.springmvc.mapping;

import com.springmvc.pojo.Goodspvdata;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodspvdataMapper extends Mapper<Goodspvdata> {
/**
 * Description：传入list集合进行更新
 * @author boyang
 * @date 2019/3/26 14:59
 * @param
 * @return java.lang.Integer
 */
    Integer upPv(@Param(value = "list") List<Goodspvdata> list);


    /**
     * Description：查询有没有这个id 用户是否存在
     * @author boyang
     * @date 2019/3/26 15:00
     * @param
     * @return
     */
    Integer count(@Param(value = "list")Integer goodId);
}