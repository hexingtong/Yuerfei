package com.springmvc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.springmvc.mapping.KnTagMapper;
import com.springmvc.pojo.KnTag;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_tag;
import com.springmvc.service.KnTagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName KnTagServiceImpl
 * @Description:
 * @Author by
 * @Date: 2019/3/8 18:03
 **/
@Service
public class KnTagServiceImpl extends BaseServiceImpl<KnTag> implements KnTagService {
    final Logger logger = LoggerFactory.getLogger(kn_adminserviceimpl.class);

    @Autowired
    private KnTagMapper knTagMapper;

    @Override
    public int MercjatTagDelete(Integer id) {
        int i=knTagMapper.MercjatTagDelete(id);
        return i;
    }

    @Override
    public PageResultInfo queryListTag(Integer pageNo, Integer pageSize, String title) {
        logger.info("传入的pageno,pagesize,phone"+pageNo+":"+pageSize+":"+title);
        PageHelper.startPage(pageNo, pageSize);
        //获取agent的level
        kn_tag knTag = new kn_tag();
        List<kn_tag> agentLevelSettings;
        if (!StringUtil.isEmpty(title)||!"".equals(title)){
            logger.info("查询到了");
//            knTag.setTitle(title);
            agentLevelSettings = knTagMapper.queryListTag(title);
        }else {
            logger.info("没有查询到");
            agentLevelSettings = knTagMapper.queryListTag(title);
        }
        logger.info("获取tag表中所有数据");
        PageInfo<kn_tag> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
        return resultInfo;
    }

    @Override
    public int MercjatTagIncrease(kn_tag knTag) {
        int ls=knTagMapper.MercjatTagIncrease(knTag);
        return ls;
    }

    @Override
    public int MercjatTagUpadete(kn_tag knTag) {
        int ls=knTagMapper.MercjatTagUpadete(knTag);
        return ls;
    }

    @Override
    public kn_tag selectByidTag(Integer id) {
        kn_tag kn_tag=knTagMapper.selectByidTag(id);
        return kn_tag;
    }

}
