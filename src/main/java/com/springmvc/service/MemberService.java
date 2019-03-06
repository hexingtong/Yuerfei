package com.springmvc.service;

import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
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
 * @param [pageNo, pageSize]
 * @return com.springmvc.pojo.PageResultInfo
 */
    PageResultInfo queryListAdmin(Integer pageNo, Integer pageSize);
    
}
