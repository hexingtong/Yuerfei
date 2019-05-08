package com.springmvc.service;

import com.springmvc.pojo.Article;
import com.springmvc.pojo.Comment;
import com.springmvc.pojo.VO.ArticleDetailVO;
import com.springmvc.pojo.VO.CommentVO;

import java.util.List;

/**
 * @ClassName ArticleService
 * @Description: 自定义发帖接口
 * @Author by
 * @Date: 2019/5/6 13:46
 **/
public interface ArticleService extends BaseService<Article> {
    /**
     * Description： 获取用户的评论总数
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/5/6 13:48
     */
    List<CommentVO> getConment(Integer articleId);

    /**
     * Description：自定义返回详情评论页面
     * @author boyang
     * @date 2019/5/6 16:19
     * @param
     * @return
     */
    ArticleDetailVO getArticledetail(Integer articleId,Integer userId);
}
