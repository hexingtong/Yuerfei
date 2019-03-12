package com.springmvc.mapping;

import com.springmvc.pojo.kn_admin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface kn_adminMapper extends Mapper<kn_admin> {

    kn_admin queryList(Integer id);

    List<kn_admin> queryListPhone(String phone);

    int insertAndmin(kn_admin kn_admin);

    int countAndmin(String phone);

    kn_admin queryByid(String phone);

    /**
     * Description：(id，密码）
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/3/4 16:52
     */
    kn_admin queryByPhone(String phone);

    int UpdateLoginTime(kn_admin kn_admin);

    /**
     * Description：获取列表（分页）
     *
     * @param
     * @return com.springmvc.pojo.PageResultInfo
     * @author boyang
     * @date 2019/3/6 10:48
     */
    List<kn_admin> queryListAdmin(@Param("level") Integer level, @Param("phone") String phone);

    /**
     * Description:通过id来更新kn_admin
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/3/6 17:33
     */
    int updateByPrimaryKeySelective(kn_admin record);
    /**  
     * Description：通过手机模糊查收，会员信息
     * @author boyang
     * @date  19:43
     * @param 
     * @return 
     */
    List<kn_admin> selectPhoneList(@Param("phone") String phone);
    /**
     * Description：得到管理员列表
     * @author boyang
     * @date  19:43
     * @param
     * @return
     */
    List<kn_admin> selectManagementList(@Param("phone") String phone);

}