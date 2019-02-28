package com.springmvc.service.impl;

import com.springmvc.mapping.kn_goodsMapper;
import com.springmvc.pojo.kn_goods;

import com.springmvc.service.kn_goodsservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName kn_goodsServiceimpl
 *@Description:
 *@Author by
 *@Date: 2019/2/27 15:02
 **/
@Service
public  class kn_goodsServiceimpl extends  BaseServiceImpl<kn_goods> implements kn_goodsservice {
    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);
@Autowired
  private kn_goodsMapper knGoodsMapper;
    private String s;


    /**
     * Description：得到產品列表
     * @author boyang
     * @date 2019/2/27 15:10
     * @param
     * @return java.util.List<com.springmvc.pojo.kn_goods>
     */
    @Override
    public List<kn_goods> getGoodsList() {
       logger.info("沒有參數");
             List<kn_goods> lis=new ArrayList();
             lis=knGoodsMapper.getGoodsList();
               if (lis!=null){
                   logger.info("參數為："+lis);
                   return lis;
               }else {
                   return  null;
               }


    }





}
