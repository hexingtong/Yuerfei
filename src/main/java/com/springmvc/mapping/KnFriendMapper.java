package com.springmvc.mapping;

import com.springmvc.pojo.kn_friend;
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

    /**
     * 根据id查询单个推广链接所有数据
     */
    kn_friend selectFrilend(Integer id);
    /**
     * 增加推广链接
     */
    int insertFrilend(kn_friend kn_friend);
    /**
     * 查询所有 推广数据
     */
    kn_friend selectAlllAndFriend();

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页注册埋点
     * @Date 9:45 2019/4/4
     * @Param
     * @return
     **/
    int updateFriendZhuce(String url);
    /**
     * @Author 苏俊杰
     * @Description //TODO 查询所有推广链接
     * @Date 2:32 2019/4/10
     * @Param
     * @return
     **/
     List<kn_friend> selectFriendAll();
     
     /**
      * @Author 苏俊杰
      * @Description //TODO 查询短链接数据
      * @Date 16:23 2019/4/11
      * @Param 
      * @return 
      **/
    List<kn_friend> selectShortUrl();


}