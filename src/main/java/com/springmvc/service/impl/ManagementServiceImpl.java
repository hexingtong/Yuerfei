package com.springmvc.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.kn_adminMapper;
import com.springmvc.pojo.DTO.knadmin2;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.ManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ManagementServiceImpl
 * @Description: 用户管理列表
 * @Author by
 * @Date: 2019/3/9 14:29
 **/
@Service
public class ManagementServiceImpl  extends  BaseServiceImpl<kn_admin> implements ManagementService {

    final Logger logger = LoggerFactory.getLogger(ManagementServiceImpl.class);

    @Autowired
    kn_adminMapper knAdminMapper;


    public PageResultInfo queryManagementList(Integer pageNo, Integer pageSize, String phone) {
        logger.info("传入的pageno,pagesize,phone"+pageNo+":"+pageSize+":"+phone);
        PageHelper.startPage(pageNo, pageSize);
        knadmin2 knAdmin=new knadmin2();
        List<knadmin2> agentLevelSettings;
        if (!StringUtils.isEmpty(phone)||!"".equals(phone)){
            knAdmin.setPhone(phone);
            agentLevelSettings = knAdminMapper.selectManagementList(knAdmin.getPhone());
        }else {
            agentLevelSettings = knAdminMapper.selectManagementList(knAdmin.getPhone());
        }
        logger.info("获取admin表中所有数据");
        PageInfo<knadmin2> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
        return resultInfo;
    }
    /**
     * Description：新增管理人员
     * @author boyang
     * @date 2019/3/9 16:32
     * @param
     * @return
     */
    @Override
    public int saveManment(kn_admin knAdmin) {
        logger.info("传入新增参数phone"+knAdmin.getPhone()+knAdmin.getLevel()+knAdmin.getImg());
        kn_admin knAdmin1 =new kn_admin();

        if (StringUtils.isEmpty(knAdmin.getPhone())&&"".equals(knAdmin.getPhone())){
            knAdmin1.setPhone(knAdmin.getPhone());
            knAdmin1.setAddTime(new Date());
            knAdmin1.setTitle(knAdmin.getTitle());
            knAdmin1.setLevel(knAdmin.getLevel());
            knAdmin1.setImg(knAdmin.getImg());
            knAdmin1.setLoginIp(knAdmin.getLoginIp());
            knAdminMapper.insert(knAdmin1);
            // int in=  knAdminMapper.insertAndmin(knAdmin1);
//          if (in>0){
//              return 1;
//          }else {
//              return 0;
//          }
            return 1;

        }else {
            return 0;
        }


    }
}
