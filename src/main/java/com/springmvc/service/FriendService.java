package com.springmvc.service;

import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_friend;

import java.util.List;

public interface FriendService extends  BaseService<kn_friend> {

    /**
     * 查询推广链接
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResultInfo queryListfriend(Integer pageNo, Integer pageSize, String title, Integer Index1);


    /**
     * 删除推广链接
     * @param id
     * @return
     */
    int deleteFriend(int id);
    /**
     * 编辑推广链接
     */
    int updateFrilend(kn_friend kn_friend);
    /**
     * 根据id查询单个推广链接所有数据
     */
    kn_friend selectFrilend(Integer id);

    /**
     * 增加推广链接
     * @param kn_friend
     * @return
     */
    int insertFrilend(kn_friend kn_friend);

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询推广表所有数据
     * @Date 10:41 2019/3/26
     * @Param []
     * @return com.springmvc.pojo.kn_friend
     **/
    kn_friend selectAlllAndFriend();

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广链接注册埋点
     * @Date 9:45 2019/4/4
     * @Param
     * @return
     **/
    int updateFriendZhuce(String url);

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询所有推广链接
     * @Date 2:34 2019/4/10
     * @Param
     * @return
     **/
    List<kn_friend> selectFriendAll();
    /**
     * @Author 苏俊杰
     * @Description //TODO 生成6位推广链接
     * @Date 16:44 2019/4/11
     * @Param 
     * @return 
     **/
    String getShortUrl();
    /**
     * @Author 苏俊杰
     * @Description //TODO 根据短链接查询真实路径
     * @Date 17:27 2019/4/12
     * @Param
     * @return
     **/
    String restoreUrl(kn_friend kn_friend);

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页pv点击埋点+1
     * @Date 11:15 2019/4/23
     * @Param
     * @return
     **/
    Integer updateFriendPv(String shorturl);

}
