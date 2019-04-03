package com.springmvc.mapping;

import com.springmvc.pojo.Goodspvdata;
import com.springmvc.pojo.VO.GoodsSupermarketDvo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodspvdataMapper extends Mapper<Goodspvdata> {


    /**
     * Description：
     有则更新，无能插入pv，唯一索引goodid
     * @author boyang
     * @date 2019/3/26 15:00
     * @param
     * @return
     */
    Integer INPV(@Param(value = "list")List<Goodspvdata> list);

/**
 * Description： 查询所有的产品pv通过传入id
 * @author boyang
 * @date 2019/3/28 17:22
 * @param
 * @return com.springmvc.pojo.Goodspvdata
 */
    Goodspvdata getGoodspvdata(Integer id);

    /**
     * Description：定时清空Pv
     * @author boyang
     * @date 2019/4/2 13:45
     * @param
     * @return
     */
    Integer upPv();


}