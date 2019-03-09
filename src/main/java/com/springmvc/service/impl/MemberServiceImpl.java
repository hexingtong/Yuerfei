package com.springmvc.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.springmvc.mapping.kn_adminMapper;
import com.springmvc.mapping.kn_goodsMapper;
import com.springmvc.mapping.KnTagMapper;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.pojo.kn_tag;
import com.springmvc.service.MemberService;
import com.springmvc.service.kn_adminservice;
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
public class MemberServiceImpl extends BaseServiceImpl<kn_admin> implements MemberService {
    final Logger logger = LoggerFactory.getLogger(kn_adminserviceimpl.class);
    @Autowired
    kn_adminMapper knAdminMapper;

    @Autowired
    private kn_goodsMapper knGoodsMapper;

    @Autowired
    KnTagMapper knTagMapper;
    /**
     * Description：
     * @author boyang
     * @date 2019/3/6 11:42
     * @param , pageSize]
     * @return com.springmvc.pojo.PageResultInfo
     */
    @Override
    public PageResultInfo queryListAdmin(Integer pageNo, Integer pageSize,String phone) {
logger.info("传入的pageno,pagesize,phone"+pageNo+":"+pageSize+":"+phone);
        PageHelper.startPage(pageNo, pageSize);
        //获取agent的level
        kn_admin knAdmin = new kn_admin();
        knAdmin.setLevel(2);
        List<kn_admin> agentLevelSettings;
        if (!StringUtils.isEmpty(phone)||!"".equals(phone)){
            knAdmin.setPhone(phone);
            agentLevelSettings = knAdminMapper.queryListAdmin(knAdmin.getLevel(),knAdmin.getPhone());
        }else {
            agentLevelSettings = knAdminMapper.queryListAdmin(knAdmin.getLevel(),knAdmin.getPhone());
        }
        logger.info("获取admin表中所有数据");
        PageInfo<kn_admin> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
        return resultInfo;
    }
    /**
     * Description:通过id来更新kn_admin
     * @author boyang
     * @date 2019/3/6 17:33
     * @param
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Integer id,String phone) {
        logger.info("传入商户id：phone"+id+":"+phone);
        kn_admin knAdmin =new kn_admin();
        if (id!=null&&phone!=null){
            knAdmin.setId(id);
            knAdmin.setPhone(phone);

            try {
                knAdminMapper.updateByPrimaryKeySelective(knAdmin);
                logger.info("更新成功");
                return 1;
            } catch (Exception e) {
                logger.info("更新失败");
                e.printStackTrace();
                return 0;
            }

    }else {
            logger.info("id:phone,有空值");
            return 0;
        }


    }
    /**
     * Description：通过手机模糊查收，会员信息
     * @author boyang
     * @date  19:43
     * @param
     * @return
     */
    @Override
    public List<kn_admin> selectPhoneList(String phone) {
        logger.info("传入商户的手机"+phone);
        if (phone!=null){
            return knAdminMapper.selectPhoneList(phone);
        }else {
            return null;
        }


    }

    @Override
    public int deletebyIdMerchant(Integer id) {
        int kn = knAdminMapper.deletebyIdMerchant(id);
        if (kn > 0) {

            if (knGoodsMapper.delectMerchant(id) > 0) {
                logger.info("删除商家产品成功");
                return kn;
            } else {
                logger.info("删除商家产品失败");
            }
            return kn;
        } else {
            return kn;
        }

    }

    @Override
    public PageResultInfo queryListTag(Integer pageNo, Integer pageSize,String title) {
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


}
