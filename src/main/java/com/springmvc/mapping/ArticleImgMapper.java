package com.springmvc.mapping;

import com.springmvc.pojo.ArticleImg;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleImgMapper extends Mapper<ArticleImg> {
    /**
     * Description：得到文章对应的图片
     * @author boyang
     * @date 2019/5/7 11:13
     * @param
     * @return
     */

    List<ArticleImg> getListImg(Integer articleId);
}