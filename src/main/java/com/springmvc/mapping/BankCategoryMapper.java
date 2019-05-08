package com.springmvc.mapping;

import com.springmvc.pojo.BankCategory;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BankCategoryMapper extends Mapper<BankCategory> {
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 查询所有银行类别
     * @Date 11:42 2019/4/27
     * @Param [bankCategory]
     * @return java.util.List
     **/
    List selectAllBankCategory(BankCategory bankCategory);
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 增加银行类别
     * @Date 14:38 2019/4/27
     * @Param [bankCategory]
     * @return int
     **/
    int insertBankCategory(BankCategory bankCategory);

}