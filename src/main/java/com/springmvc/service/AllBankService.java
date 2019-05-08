package com.springmvc.service;

import com.springmvc.pojo.BankCard;
import com.springmvc.pojo.PageResultInfo;

/**
 * @ClassName AllBankService
 * @Description: 自定义银行卡接口
 * @Author by
 * @Date: 2019/4/27 11:34
 **/
public interface AllBankService extends  BaseService<BankCard> {


    /**
     * Description： 分页得到所有银行卡接口
     * @author boyang
     * @date 2019/4/27 11:40
     * @param
     * @return
     */
    PageResultInfo queryListBankCard(Integer pageNo, Integer pageSize, String title);

}
