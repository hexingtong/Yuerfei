package com.springmvc.service;

import com.springmvc.pojo.ArticeSupper;
import com.springmvc.pojo.Article;
import com.springmvc.pojo.PageResultInfo;

import java.util.List;

public interface CommunityService extends BaseService<ArticeSupper> {
    /**
     * @Author 苏俊杰
     * @Description //TODO 社区展示
     * @Date 18:18 2019/4/25
     * @Param [article]
     * @return java.util.List
     **/
    PageResultInfo selectCommunity(Integer pageNo,Integer pageSize,ArticeSupper article);

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询自己的帖子
     * @Date 14:23 2019/4/26
     * @Param
     * @return
     **/
    PageResultInfo selectMyCommunity(Integer pageNo,Integer pageSize,ArticeSupper articeSupper);
}
