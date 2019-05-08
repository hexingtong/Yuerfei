package com.springmvc.mapping;

import com.springmvc.pojo.Comment;
import com.springmvc.pojo.VO.CommentVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommentMapper extends Mapper<Comment> {


    /**
     * Description：
     * @author boyang
     * @date 2019/5/6 14:08
     * @param
     * @return
     */

    List<CommentVO> getCommentlist(Integer articleId);
}