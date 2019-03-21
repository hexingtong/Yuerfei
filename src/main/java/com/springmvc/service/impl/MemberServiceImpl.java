package com.springmvc.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.springmvc.mapping.KnFriendMapper;
import com.springmvc.mapping.KnTagMapper;
import com.springmvc.mapping.kn_adminMapper;
import com.springmvc.mapping.kn_goodsMapper;
import com.springmvc.pojo.*;
import com.springmvc.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MemberServiceImpl
 * @Description:得到会员管理列表
 * @Author by
 * @Date: 2019/3/6 9:29
 **/
@Service
public class MemberServiceImpl  extends BaseServiceImpl<kn_admin> implements MemberService {
    final Logger logger = LoggerFactory.getLogger(kn_adminserviceimpl.class);
    @Autowired
    kn_adminMapper knAdminMapper;

    @Autowired
    private kn_goodsMapper knGoodsMapper;

    @Autowired
    KnTagMapper knTagMapper;

    @Autowired
    KnFriendMapper knFriendMapper;
    /**
     * Description：
     * @author boyang
     * @date 2019/3/6 11:42
     * @param , pageSize]
     * @return com.springmvc.pojo.PageResultInfo
     */
    @Override
    public PageResultInfo queryListAdmin(Integer pageNo, Integer pageSize, String phone) {
logger.info("传入的pageno,pagesize,phone"+pageNo+":"+pageSize+":"+phone);
        PageHelper.startPage(pageNo, pageSize);
        kn_admin knAdmin=new kn_admin();
        knAdmin.setLevel(1);
        List<kn_admin> agentLevelSettings;
        if (!StringUtils.isEmpty(phone)||!"".equals(phone)){
            knAdmin.setPhone(phone);
            agentLevelSettings = knAdminMapper.queryListAdmin(knAdmin.getLevel(),knAdmin.getPhone());
        }else {
            agentLevelSettings = knAdminMapper.queryListAdmin(knAdmin.getLevel(),knAdmin.getPhone());
        }
        logger.info("获取admin表中所有数据");
        PageInfo<kn_admin> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
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
    public PageResultInfo queryListfriend(Integer pageNo, Integer pageSize,String title,Integer Index) {
        logger.info("传入的pageno,pagesize"+pageNo+":"+pageSize);
        PageHelper.startPage(pageNo, pageSize);
        kn_friend knFriend=new kn_friend();
        List<kn_friend> agentLevelSettings;
        if(!StringUtils.isEmpty(title) && !"".equals(title)){
            logger.info("进入title");
            knFriend.setTitle(title);
            agentLevelSettings = knFriendMapper.selectFriend(knFriend);
            PageInfo<kn_friend> pageInfo = new PageInfo<>(agentLevelSettings);
            PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
            return resultInfo;
        }
        if(Index!=null&& !Index.equals("0") && !Index.equals(0)) {
            if (Index==1 || Index.equals(1) || Index.equals("1")) {
                //推荐级别
                knFriend.setLevel(2);
                agentLevelSettings = knFriendMapper.selectFriend(knFriend);
                PageInfo<kn_friend> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                return resultInfo;
            }else if(Index==2 || Index.equals(2) || Index.equals("2")){
                //添加时间
                knFriend.setAddTime(new Date());
                agentLevelSettings = knFriendMapper.selectFriend(knFriend);
                PageInfo<kn_friend> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                return resultInfo;
            }else if(Index==3 || Index.equals(3) || Index.equals("3")){
                //点击量排序
                knFriend.setClick(2);
                agentLevelSettings = knFriendMapper.selectFriend(knFriend);
                PageInfo<kn_friend> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                return resultInfo;
            }
        }
        agentLevelSettings = knFriendMapper.selectFriend(knFriend);
        logger.info("获取admin表中所有数据");
        PageInfo<kn_friend> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
        return resultInfo;
    }

    public int deleteFriend(int id){
        int i=knFriendMapper.deleteFriend(id);
        if(i>0){
            logger.info("删除成功");
            return 1;
        }else {
            logger.info("删除失败");
            return 0;
        }
    }

    @Override
    public int updateFrilend(kn_friend kn_friend) {
        int i=knFriendMapper.updateFrilend(kn_friend);
        if(i>0){
            logger.info("编辑成功");
            return 1;
        }else {
            logger.info("编辑失败");
            return 0;
        }

    }


}
