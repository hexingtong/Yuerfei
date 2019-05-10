package com.springmvc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.BankCategoryMapper;
import com.springmvc.pojo.BankCategory;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_goodsSupper;
import com.springmvc.service.BankCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BankCategoryServiceImple
 * @Description: 银行卡分类
 * @Author by
 * @Date: 2019/4/23 10:48
 **/
@Service
public class BankCategoryServiceImple extends BaseServiceImpl<BankCategory> implements BankCategoryService {

    final Logger logger = LoggerFactory.getLogger(BankCategoryServiceImple.class);

    @Autowired
     private BankCategoryMapper bankCategoryMapper;
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 查询银行的所有类别
     * @Date 11:41 2019/4/27
     * @Param [pageNo, pageSize, bankCategory]
     * @return com.springmvc.pojo.PageResultInfo
     **/
    @Override
    public PageResultInfo selectAllBankCategory(Integer pageNo, Integer pageSize, BankCategory bankCategory) {
        logger.info("传入的pageNo:"+pageNo+"--pageSize:"+pageSize+"--name="+bankCategory.getName());
        PageHelper.startPage(pageNo, pageSize);
        List<BankCategory> lst=bankCategoryMapper.selectAllBankCategory(bankCategory);
        PageInfo<BankCategory> pageInfo = new PageInfo<>(lst);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
        return resultInfo;
    }
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 增加银行分类接口
     * @Date 14:28 2019/4/28
     * @Param [bankCategory]
     * @return int
     **/
    @Override
    public int insertBankCategory(BankCategory bankCategory) {
        int i=bankCategoryMapper.insertBankCategory(bankCategory);
        return i;
    }

}
