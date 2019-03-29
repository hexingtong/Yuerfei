package com.springmvc.service;

import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_friend;

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
}
