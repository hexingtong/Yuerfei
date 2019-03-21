package com.springmvc.mapping;

import com.springmvc.pojo.KnFriend;
import com.springmvc.pojo.kn_friend;
import com.springmvc.pojo.kn_goods;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface KnFriendMapper extends Mapper<kn_friend> {
    /**
     * 获得推广列表
     * @param kn_friend
     * @return
     */
    List<kn_friend> selectFriend(kn_friend kn_friend);

    /**
     * 删除推广
     * @param id
     * @return
     */
    int deleteFriend(int id);

    /**
     * 编辑推广
     * @param
     * @return
     */
    int updateFrilend(kn_friend kn_friend);
}