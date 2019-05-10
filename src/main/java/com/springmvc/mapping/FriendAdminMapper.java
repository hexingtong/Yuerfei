package com.springmvc.mapping;

import com.springmvc.pojo.FriendAdmin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface FriendAdminMapper extends Mapper<FriendAdmin> {
    /**
     * Description：推广登录接口
     * @author boyang
     * @date 2019/5/8 9:22
     * @param
     * @return
     */
FriendAdmin getPwd(String username);
/**  
 * Description：通过短链接获取，扣量值
 * @author boyang
 * @date 2019/5/8 11:11
 * @param 
 * @return 
 */
FriendAdmin getQuantity(String shortUrl);
/**
 * Description：自定义通过friengId更新账号密码和扣量百分比
 * @author boyang
 * @date 2019/5/8 15:06
 * @param
 * @return
 */
Integer updateFriend(@Param("account") String account, @Param("pwd")String pwd, @Param("intradayQuantity")Integer intradayQuantity, @Param("defaultQuantity")Integer defaultQuantity, @Param("id") Integer id);
}