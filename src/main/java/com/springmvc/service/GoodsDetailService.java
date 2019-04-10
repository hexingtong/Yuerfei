package com.springmvc.service;

import com.springmvc.pojo.GoodsDetail;

/**
 * Description：产品详情类
 * @author boyang
 * @date 2019/3/8 16:56
 * @param
 * @return
 */

public interface GoodsDetailService extends BaseService<GoodsDetail> {

    GoodsDetail selectDetail(int id);
}
