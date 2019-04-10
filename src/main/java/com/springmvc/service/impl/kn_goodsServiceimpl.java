package com.springmvc.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.kn_goodsMapper;
import com.springmvc.pojo.*;
import com.springmvc.pojo.DTO.GoodsAttributeDto;
import com.springmvc.pojo.VO.GoodsSupermarketDvo;
import com.springmvc.pojo.VO.paramInfos;
import com.springmvc.service.GoodsPvDataService;
import com.springmvc.service.GoodsUvDataService;
import com.springmvc.service.kn_goodsservice;
import com.util.OpenAPI;
import com.util.pvDataUtuil.getCountPv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *@ClassName kn_goodsServiceimpl
 *@Description:
 *@Author by
 *@Date: 2019/2/27 15:02
 **/
@Service
public  class kn_goodsServiceimpl extends BaseServiceImpl<kn_goods> implements kn_goodsservice {
    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);
@Autowired
  private kn_goodsMapper knGoodsMapper;
@Autowired
private GoodsPvDataService godsPvDataService;
@Autowired
private GoodsUvDataService goodsUvDataService;


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
    public List<kn_goods> queryByTagid() {
        logger.info("进入查询接口");
        List<kn_goods> list=new ArrayList<>();
        try {
            list= knGoodsMapper.queryByTagid();
        } catch (Exception e) {
            logger.info("查询失败");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<kn_goods> queryGoodes(String title) {
        logger.info("传入搜索产品名"+title);
        List list=new ArrayList();
        if (StringUtils.isNotEmpty(title)){
            list= knGoodsMapper.queryGoodes(title);
            return list;
        }else {
            return null;
        }

    }
    /**
     * Description：得到超市产品列表
     *
     * @param , response, pageNo：当前页, pageSize：页容量,title:产品名称，Index1排序方式，propertyId产品属性，statusId审核状态
     * @return com.springmvc.pojo.PageResultInfo
     * @author boyang
     * @date 11:21
     */
    @Override
    public PageResultInfo queryGoods(Integer pageNo, Integer pageSize, String title, Integer Index1, Integer propertyId, Integer status) {
        logger.info("传入的pageno,pagesize,title,Index1,propertyId,status" + pageNo + ":" + pageSize + ":" + title + ":" + Index1 + ":" + propertyId + ":" + status);
        PageHelper.startPage(pageNo, pageSize);
        logger.info("propertyIds");
        kn_goodsSupper knGoods = new kn_goodsSupper();
        List<kn_goodsSupper> agentLevelSettings;
        if (!StringUtils.isEmpty(title) && !"".equals(title)) {
            logger.info("进入title");
            knGoods.setTitle(title);
        }
        if (propertyId != null && propertyId.equals("0")) {
            logger.info("进入propertyId");
            knGoods.setPropertyIds(propertyId.toString());
        }
        if (status != null && status.equals("0")) {
            logger.info("进入statusId");
            knGoods.setStatus(status);
        }
        if (Index1 != null && !Index1.equals("0") && !Index1.equals(0)) {
            if (Index1 == 1 || Index1.equals(1) || Index1.equals("1")) {
                logger.info("进入进入按时间排序1");
                    if(propertyId!=null&&!propertyId.equals(0)){
                        logger.info("进入按时间按产品属性排序");
                        knGoods.setAddTime(new Date());
                        logger.info("propertyId转换后的String值"+propertyId.toString());
                        knGoods.setPropertyIds(propertyId.toString());
                        agentLevelSettings = knGoodsMapper.queryGoods(knGoods);
                        PageInfo<kn_goodsSupper> pageInfo = new PageInfo<>(agentLevelSettings);
                        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                        logger.info("传出的pageno,pagesize,title,Index1,propertyId,statusId" + pageNo + ":" + pageSize + ":" + title + ":" + Index1 + ":" + propertyId + ":" + status);
                        return resultInfo;
                    }
                knGoods.setAddTime(new Date());
                agentLevelSettings = knGoodsMapper.queryGoods(knGoods);
                PageInfo<kn_goodsSupper> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                logger.info("传出的pageno,pagesize,title,Index1,propertyId,statusId" + pageNo + ":" + pageSize + ":" + title + ":" + Index1 + ":" + propertyId + ":" + status);
                return resultInfo;
            } if (Index1 == 2 || Index1.equals(2) || Index1.equals("2")) {
                    logger.info("进入推荐级别排序");
                    if(propertyId!=null&&!propertyId.equals(0)&&!propertyId.equals(0)){
                        logger.info("进入按推荐级别和按属性排序");
                        knGoods.setLevel(2);
                        logger.info("propertyId转换后的String值"+propertyId.toString());
                        knGoods.setPropertyIds(propertyId.toString());
                        logger.info("level的值"+knGoods.getLevel());
                        agentLevelSettings = knGoodsMapper.queryGoods(knGoods);
                        PageInfo<kn_goodsSupper> pageInfo = new PageInfo<>(agentLevelSettings);
                        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                        logger.info("传出的pageno,pagesize,title,Index1,propertyId,statusId" + pageNo + ":" + pageSize + ":" + title + ":" + Index1 + ":" + propertyId + ":" + status);
                        return resultInfo;
                    }
                knGoods.setLevel(1);
                agentLevelSettings = knGoodsMapper.queryGoods(knGoods);
                PageInfo<kn_goodsSupper> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                logger.info("传出的pageno,pagesize,title,Index1,propertyId,statusId" + pageNo + ":" + pageSize + ":" + title + ":" + Index1 + ":" + propertyId + ":" + status);
                return resultInfo;
            }
            if(Index1==3||Index1.equals(3) || Index1.equals("3")){
                logger.info("进入点击量排序");
                if(propertyId!=null&&!propertyId.equals(0)&&!propertyId.equals(0)){
                    logger.info("进入按点击量和按属性排序");
                    knGoods.setClick(2);
                    logger.info("propertyId转换后的String值"+propertyId.toString());
                    knGoods.setPropertyIds(propertyId.toString());
                    agentLevelSettings = knGoodsMapper.queryGoods(knGoods);
                    PageInfo<kn_goodsSupper> pageInfo = new PageInfo<>(agentLevelSettings);
                    PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                    logger.info("传出的pageno,pagesize,title,Index1,propertyId,statusId" + pageNo + ":" + pageSize + ":" + title + ":" + Index1 + ":" + propertyId + ":" + status);
                    return resultInfo;
                }
                knGoods.setClick(2);
                agentLevelSettings = knGoodsMapper.queryGoods(knGoods);
                PageInfo<kn_goodsSupper> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                logger.info("传出的pageno,pagesize,title,Index1,propertyId,statusId" + pageNo + ":" + pageSize + ":" + title + ":" + Index1 + ":" + propertyId + ":" + status);
                return resultInfo;

            }
        } else {
            logger.info("不进入index1");
            try {
                knGoods.setTitle(title);
                agentLevelSettings = knGoodsMapper.queryGoods(knGoods);
                PageInfo<kn_goodsSupper> pageInfo = new PageInfo<>(agentLevelSettings);
                logger.info("传入的title"+title);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                logger.info("传出的pageno,pagesize,title,Index1,propertyId,statusId" + pageNo + ":" + pageSize + ":" + title + ":" + Index1 + ":" + propertyId + ":" + status);
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
    //增加超市
    @Override
    @Transactional (propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public int insertSupermarket(GoodsSupermarketDvo goodsSupermarketDvo) {
        logger.info("index的值"+goodsSupermarketDvo.getIndexx());
        logger.info("getTitle的值"+goodsSupermarketDvo.getTitle());
        //增加超市
        if(goodsSupermarketDvo.getIndexx()==0){
            logger.info("进入（只用增加goods表）");
            logger.info("传进来的值：title" + goodsSupermarketDvo.getTitle() + "apply_count`" + goodsSupermarketDvo.getApplyCount() + "Limit`" + goodsSupermarketDvo.getLimit() + "Deadline"
                    + goodsSupermarketDvo.getDeadline()
                    + "Interest_rate" + goodsSupermarketDvo.getInterestrate() +
                    "property_ids" + goodsSupermarketDvo.getPropertyIds() + "tag_id" + goodsSupermarketDvo.getTagId() + "details" +
                    goodsSupermarketDvo.getDetails() + "status" + goodsSupermarketDvo.getStatus()
                    + "url" + goodsSupermarketDvo.getUrl());
            kn_goods knGoods=new kn_goods();
            knGoods.setTitle(goodsSupermarketDvo.getTitle());
            knGoods.setId(knGoods.getId());
            knGoods.setApplyCount(goodsSupermarketDvo.getApplyCount());
            knGoods.setLimit(goodsSupermarketDvo.getLimit());
            knGoods.setDeadline(goodsSupermarketDvo.getDeadline());
            knGoods.setInterestrate(goodsSupermarketDvo.getInterestrate());
            knGoods.setPropertyIds(goodsSupermarketDvo.getPropertyIds());
            knGoods.setTagId(goodsSupermarketDvo.getTagId());
            knGoods.setDetails(goodsSupermarketDvo.getDetails() );
            knGoods.setStatus(goodsSupermarketDvo.getStatus());
            knGoods.setUrl(goodsSupermarketDvo.getUrl());
            knGoods.setImg(goodsSupermarketDvo.getImg());
            knGoods.setPaceLending(goodsSupermarketDvo.getPaceLending());
            knGoods.setAdminId(goodsSupermarketDvo.getAdminId());
            logger.info("service期限区域有没有加入去值+"+knGoods.getPaceLending());
            knGoods.setAddTime(new Date());
            int i=knGoodsMapper.insertGoodsSk(knGoods);
            if(i>0){
                logger.info("插入成功！");
                return 1;
            }else{
                throw new RuntimeException("抛出异常,事务回滚");
            }
        }else if(goodsSupermarketDvo.getIndexx()==1){
            //添加详情表
            logger.info("进入详情表");
            GoodsDetail goodsDetail=new GoodsDetail();
            goodsDetail.setDescription(goodsSupermarketDvo.getDescription());
            goodsDetail.setApplicationCondition(goodsSupermarketDvo.getApplicationConditions());
            goodsDetail.setLoopLines(goodsSupermarketDvo.getLoopLiness());
            goodsDetail.setActivationProcess(goodsSupermarketDvo.getActivationProcesss());
            int i=knGoodsMapper.insertGoodsDetailSK(goodsDetail);
            logger.info("受影响的id值是"+goodsDetail.getId());
            if(i>0){
                logger.info("详情表插入成功!");
                kn_goods knGoods=new kn_goods();
                knGoods.setTitle(goodsSupermarketDvo.getTitle());
                knGoods.setId(goodsDetail.getId());
                knGoods.setApplyCount(goodsSupermarketDvo.getApplyCount());
                knGoods.setLimit(goodsSupermarketDvo.getLimit());
                knGoods.setDeadline(goodsSupermarketDvo.getDeadline());
                knGoods.setInterestrate(goodsSupermarketDvo.getInterestrate());
                knGoods.setPropertyIds(goodsSupermarketDvo.getPropertyIds());
                knGoods.setTagId(goodsSupermarketDvo.getTagId());
                knGoods.setDetails(goodsSupermarketDvo.getDetails() );
                knGoods.setStatus(goodsSupermarketDvo.getStatus());
                knGoods.setUrl(goodsSupermarketDvo.getUrl());
                knGoods.setDetailsId(goodsDetail.getId());
                knGoods.setAddTime(new Date());
                knGoods.setImg(goodsSupermarketDvo.getImg());
                knGoods.setPaceLending(goodsSupermarketDvo.getPaceLending());
                logger.info("插入的详情表的id是"+goodsDetail.getId());

                int x=knGoodsMapper.insertGoodsSk(knGoods);
                logger.info("goodsDetail.getId()");
                if(x>0){
                    logger.info("goods表插入成功");
                    return 1;
                }
            }else{
                //失败
                throw new RuntimeException("抛出异常,事务回滚");
            }
        }
        throw new RuntimeException("抛出异常,事务回滚");
    }
    //编辑超市
    @Override
    @Transactional (propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public int updateSupermarket(GoodsSupermarketDvo goodsSupermarketDvo) {
        logger.info("index的值"+goodsSupermarketDvo.getIndexx());
        //增加超市
        if(goodsSupermarketDvo.getIndexx()==0){
            logger.info("进入（只用增加goods表）");
            logger.info("传进来的值：title" + goodsSupermarketDvo.getTitle() + "apply_count`" + goodsSupermarketDvo.getApplyCount() + "Limit`" + goodsSupermarketDvo.getLimit() + "Deadline"
                    + goodsSupermarketDvo.getDeadline()
                    + "Interest_rate" + goodsSupermarketDvo.getInterestrate() +
                    "property_ids" + goodsSupermarketDvo.getPropertyIds() + "tag_id" + goodsSupermarketDvo.getTagId() + "details" +
                    goodsSupermarketDvo.getDetails() + "status" + goodsSupermarketDvo.getStatus()
                    + "url" + goodsSupermarketDvo.getUrl());
            kn_goods knGoods=new kn_goods();
            knGoods.setTitle(goodsSupermarketDvo.getTitle());
            knGoods.setId(goodsSupermarketDvo.getId());
            knGoods.setApplyCount(goodsSupermarketDvo.getApplyCount());
            knGoods.setLimit(goodsSupermarketDvo.getLimit());
            knGoods.setDeadline(goodsSupermarketDvo.getDeadline());
            knGoods.setInterestrate(goodsSupermarketDvo.getInterestrate());
            knGoods.setPropertyIds(goodsSupermarketDvo.getPropertyIds());
            knGoods.setTagId(goodsSupermarketDvo.getTagId());
            knGoods.setDetails(goodsSupermarketDvo.getDetails() );
            knGoods.setStatus(goodsSupermarketDvo.getStatus());
            knGoods.setUrl(goodsSupermarketDvo.getUrl());
            knGoods.setImg(goodsSupermarketDvo.getImg());
            knGoods.setPaceLending(goodsSupermarketDvo.getPaceLending());
            knGoods.setAddTime(new Date());
            int i=knGoodsMapper.updateGoodsSk(knGoods);
            logger.info("i的值"+i);
            if(i>0){
                logger.info("编辑成功！");
                return 1;
            }else{
                logger.info("编辑失败！");
                throw new RuntimeException("抛出异常,事务回滚");
            }
        }else if(goodsSupermarketDvo.getIndexx()==1){
            //添加详情表
            logger.info("进入添加详情表");
            GoodsDetail goodsDetail=new GoodsDetail();
            goodsDetail.setId(goodsSupermarketDvo.getDetailsId());
            logger.info("goodsdetail的id值是"+goodsDetail.getId());
            goodsDetail.setDescription(goodsSupermarketDvo.getDescription());
            logger.info("Description的id值是"+goodsDetail.getDescription());
            goodsDetail.setApplicationCondition(goodsSupermarketDvo.getApplicationConditions());
            goodsDetail.setLoopLines(goodsSupermarketDvo.getLoopLiness());
            goodsDetail.setActivationProcess(goodsSupermarketDvo.getActivationProcesss());
            int i=knGoodsMapper.updateGoodsDetailSK(goodsDetail);
            if(i>0){
                logger.info("详情表编辑成功!");
                kn_goods knGoods=new kn_goods();
                knGoods.setTitle(goodsSupermarketDvo.getTitle());
                knGoods.setId(goodsSupermarketDvo.getId());
                knGoods.setApplyCount(goodsSupermarketDvo.getApplyCount());
                knGoods.setLimit(goodsSupermarketDvo.getLimit());
                knGoods.setDeadline(goodsSupermarketDvo.getDeadline());
                knGoods.setInterestrate(goodsSupermarketDvo.getInterestrate());
                knGoods.setPropertyIds(goodsSupermarketDvo.getPropertyIds());
                knGoods.setTagId(goodsSupermarketDvo.getTagId());
                knGoods.setDetails(goodsSupermarketDvo.getDetails() );
                knGoods.setStatus(goodsSupermarketDvo.getStatus());
                knGoods.setUrl(goodsSupermarketDvo.getUrl());
                knGoods.setDetailsId(goodsDetail.getId());
                knGoods.setImg(goodsSupermarketDvo.getImg());
                knGoods.setPaceLending(goodsSupermarketDvo.getPaceLending());
                knGoods.setAddTime(new Date());
                int x=knGoodsMapper.updateGoodsSk(knGoods);
                if(x>0){
                    logger.info("goods表编辑成功");
                    return 1;
                }
            }else{
                //失败
                logger.info("详情表增加失败");
                throw new RuntimeException("抛出异常,事务回滚");
            }
        }
        throw new RuntimeException("抛出异常,事务回滚");
    }

    /**
     * 删除超市
     * @param goodsSupermarketDvo
     * @return
     */
    @Override
    public int deleteSupermarket(GoodsSupermarketDvo goodsSupermarketDvo) {
        kn_goods knGoods=new kn_goods();
        GoodsDetail goodsDetail=new GoodsDetail();
        logger.info("id值是:"+goodsSupermarketDvo.getDetailsId());
        goodsDetail.setId(goodsSupermarketDvo.getDetailsId());
        knGoods.setId(goodsSupermarketDvo.getId());
        //删除产品表
        int i=knGoodsMapper.deleteGoodsSk(knGoods);
        if(i>0) {
            logger.info("产品表删除成功");

            //删除详情表

//            int z = knGoodsMapper.deleteGoodsDetailSK(goodsDetail);
//            if(z>0){
//                logger.info("详情表删除成功");
//                return 1;
//            }else {
//                logger.info("详情表删除失败");
//                throw new RuntimeException("抛出异常,事务回滚");
//            }
            return 1;
        }else{
            logger.info("产品表删除失败");
            throw new RuntimeException("抛出异常,事务回滚");
        }


    }


    @Override
    public kn_goods selectGoodsSK(int id) {
        kn_goods knGoods=knGoodsMapper.selectGoodsSK(id);
       return knGoods;
    }


    /**
 * Description：定时更新pv uv
 * @author boyang
 * @date 2019/3/25 17:35
 * @param
 * @return com.springmvc.pojo.kn_goods()
 */

    public int upgoodsPvUv() {

        OpenAPI.umengAndroidPvEventParamGetValueList();
       List LI= OpenAPI.umengAndroidEventParamGetValueList();
        LI.get(0);
        logger.info("pu"+OpenAPI.umengAndroidPvEventParamGetValueList());


        return 1;


    }
    /**
     * Description：得到pagegoodslist
     * @author boyang
     * @date 2019/4/2 11:36
     * @param
     * @return
     */
    @Override
    public PageResultInfo pagegoodslist(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<kn_goods> agentLevelSettings;
        agentLevelSettings= knGoodsMapper.getGoodsList();
        PageInfo<kn_goods> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());

        return resultInfo;
    }
    /**
     * Description：实时更新pvuv数据
     * @author boyang
     * @date 2019/4/3 9:55
     * @param
     * @return
     */
    @Override
    @Transactional
    public Integer updateGoodspvuv() {
        //得到所有的pv,uv
//        List<Goodspvdata> Pv=godsPvDataService.queryAll();
//        List<Goodsuvdata> Uv=goodsUvDataService.queryAll();
        //得到总的pv：getPv2
        List<kn_goods> goodpv= getCountPv.getPv2();
        List<kn_goods> goodUv=getCountPv.getUv2();
//        List<kn_goods> goods = new ArrayList<>();;
//
//        for(Goodsuvdata u:Uv){
//            logger.info("uv"+u.toString());
//            kn_goods goods1=new kn_goods();
//            goods1.setUv((u.getUone()+u.getUtwo()+u.getUthree()+u.getUfour()+u.getUfive()+u.getUsat()+u.getUsunday()));
//            goods1.setId(u.getGoodsid());
//            goods.add(goods1);
//        }
//        for (Goodspvdata p:Pv){
//            logger.info("pv"+p.toString());
//            kn_goods goods2=new kn_goods();
//            goods2.setPv(p.getPone()+p.getPtwo()+p.getPthree()+p.getPfour()+p.getPfive()+p.getPsat()+p.getPsunday());
//            goods2.setId(p.getGoodid());
//            goods.add(goods2);
//        }
      Integer i=0;
        for ( kn_goods gos:goodpv){
             i=knGoodsMapper.updateOnepvuv(gos);

        }
        for ( kn_goods gose:goodUv){
           knGoodsMapper.updateOnepvuv(gose);

        }
        if (i>0){
            return 1;
        }
        return -1;
    }


    @Override
    public GoodsDetail selectGoodsOne(int id) {
        GoodsDetail goodsDetail=new GoodsDetail();
            goodsDetail = knGoodsMapper.selectGoodsOne(id);
            return goodsDetail;
    }


}
