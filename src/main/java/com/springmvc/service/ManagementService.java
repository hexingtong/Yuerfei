package com.springmvc.service;

import com.springmvc.pojo.DTO.knadmin2;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;

/**
 * @ClassName ManagementService
 * @Description: 用户管理列表
 * @Author by
 * @Date: 2019/3/9 14:28
 **/
public interface ManagementService extends BaseService<kn_admin> {


 /**
  * Description： 管理人员列表
  * @author boyang
  * @date 2019/3/9 14:33
  * @param  pageSize, phone]
  * @return com.springmvc.pojo.PageResultInfo
  */
 PageResultInfo queryManagementList(Integer pageNo, Integer pageSize, String phone);


 /**
  * Description：新增管理人员
  * @author boyang
  * @date 2019/3/9 16:32
  * @param
  * @return
  */
 public int saveManment(kn_admin knAdmin);

}
