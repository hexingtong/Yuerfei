package com.springmvc.mapping;

import com.springmvc.pojo.ArticeSupper;
import com.springmvc.pojo.Article;
import com.util.ListObject;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommunityMapper extends Mapper<ArticeSupper>{
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 查询所有的文章
     * @Date 17:15 2019/4/25
     * @Param 
     * @return 
     **/
    List selectCommunity(ArticeSupper article);

    /**
     * @Author 苏俊杰
     * @Description //TODO 删除
     * @Date 14:22 2019/4/26
     * @Param
     * @return
     **/

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询自己的帖子
     * @Date 14:23 2019/4/26
     * @Param
     * @return
     **/
    List selectMyCommunity(ArticeSupper articeSupper);
}
