package com.springmvc.service;

import com.springmvc.pojo.BankCard;
import com.springmvc.pojo.PageResultInfo;

import java.util.List;

/**
 * @ClassName BankCardService
 * @Description: 银行卡业务类
 * @Author by
 * @Date: 2019/4/23 10:38
 **/
public interface  BankCardService extends  BaseService<BankCard>  {
  /**
   * Description：分页得到银行卡产品除精选
   * @author boyang
   * @date 2019/4/23 16:38
   * @param   pageNo, pageSize]
   * @return com.springmvc.pojo.PageResultInfo
   */
    PageResultInfo queryBankList(Integer pageNo, Integer pageSize);
  /**
   * Description：分页同id得到银行卡除精选
   * @author boyang
   * @date 2019/4/23 16:38
   * @param   pageNo, pageSize]
   * @return com.springmvc.pojo.PageResultInfo
   */
  PageResultInfo queryBankById(Integer pageNo, Integer pageSize,Integer Id);

  /**
   * Description：得到广告位接口
   * @author boyang
   * @date 2019/4/24 14:10
   * @param
   * @return
   */
  List<BankCard> getBankadvertisingList();

}
