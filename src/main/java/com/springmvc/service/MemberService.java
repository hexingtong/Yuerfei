package com.springmvc.service;

import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**  
 * Description：会员管理(当level为2的时候是会员）
 * @author boyang
 * @date 2019/3/6 9:16
 * @param 
 * @return 
 */

public interface MemberService  extends  BaseService<kn_admin>{

/**
 * Description：获取列表（分页）
 * @author boyang
 * @date 2019/3/6 10:48
 * @param
 * @return com.springmvc.pojo.PageResultInfo
 */
    PageResultInfo queryListAdmin(Integer pageNo, Integer pageSize,String phone);
    /**
     * Description:通过id来更新kn_admin
     * @author boyang
     * @date 2019/3/6 17:33
     * @param
     * @return
     */
    int updateByPrimaryKeySelective(Integer id,String phone);

    /**
     * Description：通过手机模糊查收，会员信息
     * @author boyang
     * @date  19:43
     * @param
     * @return
     */
    List<kn_admin> selectPhoneList( String phone);
}
