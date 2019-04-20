package com.springmvc.mapping;

import com.springmvc.pojo.DTO.knadmin2;
import com.springmvc.pojo.VO.Regustered;
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
    List<knadmin2> queryListAdmin(@Param("level") Integer level, @Param("phone") String phone);
    /**
     * Description：获取列表（分页）新增通过时间段查询
     *
     * @param
     * @return com.springmvc.pojo.PageResultInfo
     * @author boyang
     * @date 2019/3/6 10:48
     */
    List<knadmin2> queryListAdmin2(@Param("level") Integer level, @Param("phone") String phone,@Param("startTime")String startTime ,@Param("endTime")String endTime);

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
    List<knadmin2> selectManagementList(@Param("phone") String phone);
    /***
     * 查询用户信息
     */
    kn_admin selectUser(Integer id);
    /**
     * 根据id删除商家账户
     * @param id
     * @return
     */
    int deletebyIdMerchant(Integer id);
    /**
     * @Author 苏俊杰
     * @Description //TODO 回显会员名字:
     * @Date 10:36 2019/3/29
     * @Param
     * @return
     **/
    kn_admin selectIdOne(Integer id);

    /**
     * @Author 苏俊杰
     * @Description //TODO 根据短链接查询一个月每天的注册总数
     * @Date 15:03 2019/4/19
     * @Param
     * @return
     **/
    List<Regustered> selectMonthRegistered(kn_admin kn_admin);
}