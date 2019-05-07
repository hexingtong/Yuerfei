package com.springmvc.service.impl;

import com.springmvc.mapping.ArticleImgMapper;
import com.springmvc.mapping.ArticleMapper;
import com.springmvc.mapping.CommentMapper;
import com.springmvc.pojo.Article;
import com.springmvc.pojo.ArticleImg;
import com.springmvc.pojo.Comment;
import com.springmvc.pojo.VO.Article2;
import com.springmvc.pojo.VO.ArticleDetailVO;
import com.springmvc.pojo.VO.CommentVO;
import com.springmvc.service.ArticleService;
import com.springmvc.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArticleServiceImpl
 * @Description:
 * @Author by
 * @Date: 2019/5/6 13:55
 **/
@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ArticleImgMapper articleImgMapper;

    /**
     * Description：获取用户的评论总数
     *
     * @param
     * @return java.util.List<com.springmvc.pojo.Comment>
     * @author boyang
     * @date 2019/5/6 13:57
     */
    @Override
    public List<CommentVO> getConment(Integer articleId) {
        List<CommentVO> list = new ArrayList<>();
        if (articleId != null) {
            list = commentMapper.getCommentlist(articleId);
        }
        return list;
    }

    /**
     * Description：自定义返回详情评论页面
     *
     * @author boyang
     * @date 2019/5/6 16:19
     */
    @Override
    public ArticleDetailVO getArticledetail(Integer articleId, Integer userId) {
        List<CommentVO> comments = new ArrayList<>();
        List<ArticleImg> img=new ArrayList<>();
        //得到评论总数和用户名字和头像
        comments = commentMapper.getCommentlist(articleId);
        //得到对应的文章对象
        Article2 article = articleMapper.getArticle(articleId);
        //得到areicle对应的图片
        img= articleImgMapper.getListImg(articleId);
        //得到评论总数

        //数据组装
        ArticleDetailVO articleDetailVO=new ArticleDetailVO();
        articleDetailVO.setImgList(img);
        articleDetailVO.setCommentList(comments);
        articleDetailVO.setAddtime(article.getAddtime());
        articleDetailVO.setCheckstatus(article.getCheckstatus());
        articleDetailVO.setClick(article.getClick());
        articleDetailVO.setAdminid(article.getAdminid());
        articleDetailVO.setTitle(article.getTitle());
        articleDetailVO.setImg(article.getImg());
        return articleDetailVO;
    }
}
