package com.springmvc.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.KnGoodsMapper;
import com.springmvc.pojo.DTO.GoodsAttributeDto;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.KnGoods;
import com.springmvc.service.kn_goodsservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *@ClassName kn_goodsServiceimpl
 *@Description:
 *@Author by
 *@Date: 2019/2/27 15:02
 **/
@Service
public  class kn_goodsServiceimpl extends BaseServiceImpl<KnGoods> implements kn_goodsservice {
    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);
@Autowired
  private KnGoodsMapper knGoodsMapper;



    /**
     * Description：得到產品列表
     * @author boyang
     * @date 2019/2/27 15:10
     * @param
     * @return java.util.List<com.springmvc.pojo.kn_goods>
     */
    @Override
    public List<KnGoods> getGoodsList() {
       logger.info("沒有參數");
             List<KnGoods> lis=new ArrayList();
             lis=knGoodsMapper.getGoodsList();
               if (lis!=null){
                   logger.info("參數為："+lis);
                   return lis;
               }else {
                   return  null;
               }


    }
    /**
     * Description：得到商家产品列表
     *
     * @param , response, pageNo：当前页, pageSize：页容量,title:产品名称，Index1排序方式，propertyId产品属性，statusId审核状态
     * @return com.springmvc.pojo.PageResultInfo
     * @author boyang
     * @date 11:21
     */
    @Override
    public PageResultInfo queryGoodsList(Integer pageNo, Integer pageSize, String title, Integer Index1, Integer propertyId, Integer statusId) {
        logger.info("传入的pageno,pagesize,title,Index1,propertyId,statusId"+pageNo+":"+pageSize+":"+title+":"+Index1+":"+propertyId+":"+statusId);
        PageHelper.startPage(pageNo, pageSize);
        GoodsAttributeDto knGoods=new GoodsAttributeDto();
        List<GoodsAttributeDto> agentLevelSettings;

        if (!StringUtils.isEmpty(title)&&!"".equals(title)){
            logger.info("进入title");
            knGoods.setTitle(title);

        }if(propertyId!=null&&propertyId.equals("0")){
            logger.info("进入propertyId");
            knGoods.setPropertyIds(propertyId.toString());

        }if(statusId!=null&&statusId.equals("0")){
            logger.info("进入statusId");
            knGoods.setStatus(statusId);
        }
        if (Index1!=null&&!Index1.equals("0")&&!Index1.equals(0)){
            logger.info("进入index1");
            if (Index1==1||Index1.equals(1)||Index1.equals("1")){
                logger.info("进入index11");
                knGoods.setAddTime(new Date());
                agentLevelSettings= knGoodsMapper.queryGoodsList(knGoods);
                PageInfo<GoodsAttributeDto> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
                logger.info("传出的pageno,pagesize,title,Index1,propertyId,statusId"+pageNo+":"+pageSize+":"+title+":"+Index1+":"+propertyId+":"+statusId);
                return resultInfo;
            }else if(Index1==2||Index1.equals(2)||Index1.equals("2")){
                logger.info("进入index2");
                knGoods.setClick(2);
                agentLevelSettings= knGoodsMapper.queryGoodsList(knGoods);

                PageInfo<GoodsAttributeDto> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
                logger.info("传出的pageno,pagesize,title,Index1,propertyId,statusId"+pageNo+":"+pageSize+":"+title+":"+Index1+":"+propertyId+":"+statusId);
                return resultInfo;
            }
        }else {

            logger.info("不进入index1");
            try {
                knGoods.setId(1);
                        agentLevelSettings= knGoodsMapper.queryGoodsList(knGoods);
                PageInfo<GoodsAttributeDto> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
                logger.info("传出的pageno,pagesize,title,Index1,propertyId,statusId"+pageNo+":"+pageSize+":"+title+":"+Index1+":"+propertyId+":"+statusId);
                return resultInfo;

            } catch (NullPointerException e) {
                logger.info("运行错误");
            }



        }

//        logger.info("获取admin表中所有数据");
//        PageInfo<kn_goods> pageInfo = new PageInfo<kn_goods>(agentLevelSettings);
//        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
//        return resultInfo;
        System.out.println("null");
        return null;
    }
    /**
     * Description：通过id得到商品详情id
     * @author boyang
     * @date 2019/3/8 17:46
     * @param
     * @return
     */
    @Override
    public Integer getDetailId(Integer id) {
        if (id!=null){
            int in=knGoodsMapper.getDetailId(id);
            return in;
        }
        return null;
    }

    @Override
    public List<KnGoods> queryByTagid() {
        logger.info("进入查询接口");
        List<KnGoods> list=new ArrayList<>();
        try {
            list= knGoodsMapper.queryByTagid();
        } catch (Exception e) {
            logger.info("查询失败");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<KnGoods> queryGoodes(String title) {
        logger.info("传入搜索产品名"+title);
        List list=new ArrayList();
        if (StringUtils.isNotEmpty(title)){
            list= knGoodsMapper.queryGoodes(title);
            return list;
        }else {
            return null;
        }

    }


}
