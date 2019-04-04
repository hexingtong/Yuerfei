package com.springmvc.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.KnFriendMapper;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_friend;
import com.springmvc.service.FriendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class FriendServiceImpl extends BaseServiceImpl<kn_friend> implements FriendService {
    final Logger logger = LoggerFactory.getLogger(kn_adminserviceimpl.class);

    @Autowired
    private KnFriendMapper knFriendMapper;

    @Override
    public PageResultInfo queryListfriend(Integer pageNo, Integer pageSize, String title, Integer Index) {
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
        kn_friend.setAddTime(new Date());
        int i=knFriendMapper.updateFrilend(kn_friend);
        if(i>0){
            logger.info("编辑成功");
            return 1;
        }else {
            logger.info("编辑失败");
            return 0;
        }

    }

    @Override
    public kn_friend selectFrilend(Integer id) {
        kn_friend kn_friend=knFriendMapper.selectFrilend(id);
        return kn_friend;
    }

    @Override
    public int insertFrilend(kn_friend kn_friend) {
        kn_friend.setAddTime(new Date());
        int i=knFriendMapper.insertFrilend(kn_friend);
        return i;
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询推广表所有数据
     * @Date 10:42 2019/3/26
     * @Param []
     * @return com.springmvc.pojo.kn_friend
     **/
    @Override
    public kn_friend selectAlllAndFriend() {
        kn_friend kn_friend=knFriendMapper.selectAlllAndFriend();
        return kn_friend;
    }

    @Override
    public int updateFriendZhuce(String url) {
        int i=knFriendMapper.updateFriendZhuce(url);
        return i;
    }


}
