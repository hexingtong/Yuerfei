package com.springmvc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.CommunityMapper;
import com.springmvc.pojo.ArticeSupper;
import com.springmvc.pojo.Article;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_goodsSupper;
import com.springmvc.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityServiceImpl extends BaseServiceImpl<ArticeSupper> implements CommunityService{

    final Logger logger = LoggerFactory.getLogger(CommunityServiceImpl.class);

    @Autowired
    private  CommunityMapper communityMapper;

    /**
     * @Author 苏俊杰
     * @Description //TODO 社区帖子展示
     * @Date 14:24 2019/4/26
     * @Param [article]
     * @return java.util.List
     **/
    @Override
    public PageResultInfo selectCommunity(Integer pageNo,Integer pageSize,ArticeSupper article) {
        logger.info("实现层传进来的参数"+article.getIndex()+"--");
        List<ArticeSupper> lst=new ArrayList<>();
        PageHelper.startPage(pageNo, pageSize);
        //如果等于1就查询审核成功的
        if(article.getIndex()==1){
            article.setAdminid(1);
            article.setCheckstatus(1);
            lst=communityMapper.selectCommunity(article);
            PageInfo<ArticeSupper> pageInfo = new PageInfo<>(lst);
            PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
            return resultInfo;
        }else {
            //0就查询所有
            article.setAdminid(1);
            lst=communityMapper.selectCommunity(article);
            PageInfo<ArticeSupper> pageInfo = new PageInfo<>(lst);
            PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
            return resultInfo;
        }

    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 查看自己的帖子
     * @Date 14:24 2019/4/26
     * @Param [articeSupper]
     * @return java.util.List
     **/
    @Override
    public PageResultInfo selectMyCommunity(Integer pageNo,Integer pageSize,ArticeSupper articeSupper) {
        logger.info("实现层传进来的参数"+articeSupper.getAdminid());
        PageHelper.startPage(pageNo, pageSize);
        List<ArticeSupper>  lst=new ArrayList<>();
        lst=communityMapper.selectMyCommunity(articeSupper);
        PageInfo<ArticeSupper> pageInfo = new PageInfo<>(lst);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
        return resultInfo;
    }

}
