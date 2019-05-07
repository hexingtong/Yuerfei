package com.springmvc.mapping;

import com.springmvc.pojo.Article;
import com.springmvc.pojo.VO.Article2;
import tk.mybatis.mapper.common.Mapper;

public interface ArticleMapper extends Mapper<Article> {
    /**
     * Description： 得到文章信息
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/5/6 17:25
     */
    Article2 getArticle(Integer articleId);

}