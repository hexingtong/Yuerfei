package com.springmvc.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.FriendAdminMapper;
import com.springmvc.mapping.KnFriendMapper;
import com.springmvc.pojo.DTO.FriendDVO;
import com.springmvc.pojo.FriendAdmin;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_friend;
import com.springmvc.service.FriendService;
import com.util.JsonUtils;
import com.util.ResponseUtils;
import com.util.StatusCode;
import com.util.shortUrl.shortUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class FriendServiceImpl extends BaseServiceImpl<kn_friend> implements FriendService {
    final Logger logger = LoggerFactory.getLogger(kn_adminserviceimpl.class);
    @Autowired
    private FriendAdminMapper friendAdminMapper;
    @Autowired
    private KnFriendMapper knFriendMapper;

    @Override
    public PageResultInfo queryListfriend(Integer pageNo, Integer pageSize, String title, Integer Index) {
        logger.info("传入的pageno,pagesize"+pageNo+":"+pageSize);
        PageHelper.startPage(pageNo, pageSize);
        kn_friend knFriend=new kn_friend();
        List<FriendDVO> agentLevelSettings;
        if(!StringUtils.isEmpty(title) && !"".equals(title)){
            logger.info("进入title");
            knFriend.setTitle(title);
            agentLevelSettings = knFriendMapper.selectFriend(knFriend);
            PageInfo<FriendDVO> pageInfo = new PageInfo<>(agentLevelSettings);
            PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
            return resultInfo;
        }
        if(Index!=null&& !Index.equals("0") && !Index.equals(0)) {
            if (Index==1 || Index.equals(1) || Index.equals("1")) {
                //推荐级别
                knFriend.setLevel(2);
                agentLevelSettings = knFriendMapper.selectFriend(knFriend);
                PageInfo<FriendDVO> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                return resultInfo;
            }else if(Index==2 || Index.equals(2) || Index.equals("2")){
                //添加时间
                knFriend.setAddTime(new Date());
                agentLevelSettings = knFriendMapper.selectFriend(knFriend);
                PageInfo<FriendDVO> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                return resultInfo;
            }else if(Index==3 || Index.equals(3) || Index.equals("3")){
                //点击量排序
                knFriend.setClick(2);
                agentLevelSettings = knFriendMapper.selectFriend(knFriend);
                PageInfo<FriendDVO> pageInfo = new PageInfo<>(agentLevelSettings);
                PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
                return resultInfo;
            }
        }
        agentLevelSettings = knFriendMapper.selectFriend(knFriend);
        logger.info("获取admin表中所有数据");
        PageInfo<FriendDVO> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
        return resultInfo;
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public int deleteFriend(int id){
            int i=knFriendMapper.deleteFriend(id);
            try {


                if (i > 0) {
                    int z = knFriendMapper.deleteAndminFriend(id);
                    if (z > 0) {
                        logger.info("删除成功");
                        return 1;
                    } else {
                        logger.info("删除admin失败");
                        throw new RuntimeException("删除失败第2张表,抛出异常,事务回滚");
                    }

                } else {
                    logger.info("删除失败");
                    throw new RuntimeException("删除失败第一张表,抛出异常,事务回滚");
                }
            }catch (Exception e){
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
    @Transactional(rollbackFor=Exception.class)
    public int updateFrilend2 (String title,Integer id,String longUrl,String username,String pwd,Integer intradayQuantity,Integer defaultQuantity) throws RuntimeException  {
        kn_friend kn_friend=new kn_friend();
        kn_friend.setTitle(title);
        kn_friend.setLongUrl(longUrl);
        kn_friend.setId(id);
        kn_friend.setAddTime(new Date());
        int i=knFriendMapper.updateFrilend(kn_friend);
        Integer j= friendAdminMapper.updateFriend(username,pwd,intradayQuantity,defaultQuantity,id);
        if (j>0&i>0){
        return 1;
        }else {
            throw new RuntimeException("抛出异常,事务回滚");
        }
    }

    @Override
    public kn_friend selectFrilend(Integer id) {
        kn_friend kn_friend=knFriendMapper.selectFrilend(id);
        return kn_friend;
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 同时插入两个推广表数据
     * @Date 11:02 2019/5/8
     * @Param [kn_friend]
     * @return int
     **/
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public int insertFrilend(FriendDVO kn_friend) {
        kn_friend.setAddTime(new Date());
        int i=knFriendMapper.insertFrilend(kn_friend);
        logger.info("插入的id是"+kn_friend.getId());
        if(i>0){
            FriendAdmin friendAdmin=new FriendAdmin();
            friendAdmin.setAccount(kn_friend.getAccount());
            friendAdmin.setPwd(kn_friend.getPwd());
            friendAdmin.setDefaultquantity(kn_friend.getDefaultQuantity());
            friendAdmin.setIntradayquantity(kn_friend.getIntradayQuantity());
            friendAdmin.setFriendid(kn_friend.getId());
            //获取6位唯一字母
            friendAdmin.setShorturl(kn_friend.getShortUrl());
            int z=knFriendMapper.insertAdminFrilend(friendAdmin);
            if(z>0){
                logger.info("最终插入成功");
                return z;
            }else {
                throw new RuntimeException("插入失败第二张表,抛出异常,事务回滚");
            }
        }else {
            //失败
            throw new RuntimeException("插入失败第一张表,抛出异常,事务回滚");
        }
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

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询所有推广链接
     * @Date 2:33 2019/4/10
     * @Param
     * @return
     **/
    public List<kn_friend> selectFriendAll(){
        List<kn_friend> kn_friend=knFriendMapper.selectFriendAll();
        return kn_friend;
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 8
     * @Date 18:10 2019/4/11
     * @Param [long_url]
     * @return java.lang.String
     **/
    public String getShortUrl() {
        String shorturl=shortUrl.getShortUrlx();
        //生成短链接 然后判断数据库有没有值
        List<kn_friend> lst=knFriendMapper.selectFriendAll();
        kn_friend knFriend=new kn_friend();
        for(int i=0;i<lst.size();i++){
            knFriend=lst.get(i);
            if(knFriend.getShortUrl().equals(shorturl)){
                System.out.println("有重复链接");
                shorturl=shortUrl.getShortUrlx();
                System.out.println("生成的链接"+shorturl);
                i=0;
            }
        }
        return shorturl;
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 根据传进来的短链接查找真实路径
     * @Date 17:36 2019/4/12
     * @Param [kn_friend]
     * @return java.lang.String
     **/
    @Override
    public String restoreUrl(kn_friend kn_friend) {
        if(StringUtils.isNotEmpty(kn_friend.getShortUrl())){
            String i=knFriendMapper.restoreUrl(kn_friend);
            return i;
        }else{
            return "404";
        }
    }
    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页pv点击埋点+1
     * @Date 11:15 2019/4/23
     * @Param
     * @return
     **/
    @Override
    public Integer updateFriendPv(String shorturl){
        int i=knFriendMapper.updateFriendPv(shorturl);
        return i;
    }

    @Override
    public int selectRegister(FriendAdmin friendAdmin) {
        int i=knFriendMapper.selectRegister(friendAdmin);
        if(i>0){
            return 1;
        }else {
            return 0;
        }

    }


}
