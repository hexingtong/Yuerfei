package com.springmvc.mapping;

import com.springmvc.pojo.DTO.FriendDVO;
import com.springmvc.pojo.FriendAdmin;
import com.springmvc.pojo.kn_friend;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface KnFriendMapper extends Mapper<kn_friend> {
    /**
     * 获得推广列表
     * @param kn_friend
     * @return
     */
    List<FriendDVO> selectFriend(kn_friend kn_friend);

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

    String restoreUrl(kn_friend kn_friend);

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页pv点击埋点+1
     * @Date 11:15 2019/4/23
     * @Param
     * @return
     **/
    Integer updateFriendPv(String shorturl);

    /**
     * @Author 苏俊杰
     * @Description //TODO 增加admin推广
     * @Date 11:16 2019/5/8
     * @Param
     * @return
     **/
    int insertAdminFrilend(FriendAdmin friendAdmin);

    /**
     * @Author 苏俊杰
     * @Description //TODO 推广页面删除
     * @Date 9:18 2019/5/9
     * @Param
     * @return
     **/
    int deleteAndminFriend(Integer friendid);

}