package com.springmvc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.kn_adminMapper;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MemberServiceImpl
 * @Description:得到会员管理列表
 * @Author by
 * @Date: 2019/3/6 9:29
 **/
@Service
public class MemberServiceImpl  extends BaseServiceImpl<kn_admin> implements MemberService  {
    final Logger logger = LoggerFactory.getLogger(kn_adminserviceimpl.class);
    @Autowired
    kn_adminMapper knAdminMapper;

    @Override
    public PageResultInfo queryListAdmin(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        //获取agent的level
        kn_admin knAdmin=new kn_admin();
        knAdmin.setLevel(2);
        List<kn_admin> agentLevelSettings = knAdminMapper.queryListAdmin(knAdmin.getLevel());
        logger.info("获取agent_level_setting表中所有数据");
        PageInfo<kn_admin> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
        return resultInfo;

    }
}
