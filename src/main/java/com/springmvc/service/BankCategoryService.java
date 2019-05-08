package com.springmvc.service;

import com.springmvc.pojo.BankCategory;
import com.springmvc.pojo.PageResultInfo;

import java.util.List;

/**
 * Description： 银行卡分类
 * @author boyang
 * @date 2019/4/23 10:47
 * @param
 * @return
 */
public interface BankCategoryService extends  BaseService<BankCategory> {

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询所有银行类别
     * @Date 11:42 2019/4/27
     * @Param [pageNo, pageSize, bankCategory]
     * @return com.springmvc.pojo.PageResultInfo
     **/
    PageResultInfo  selectAllBankCategory(Integer pageNo, Integer pageSize,BankCategory bankCategory);

    /**
     * @Author 苏俊杰
     * @Description //TODO 增加银行类别
     * @Date 14:38 2019/4/27
     * @Param [bankCategory]
     * @return int
     **/
    int insertBankCategory(BankCategory bankCategory);

}
