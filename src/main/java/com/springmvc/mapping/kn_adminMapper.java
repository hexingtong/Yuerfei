package com.springmvc.mapping;

import com.springmvc.pojo.kn_admin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface kn_adminMapper  extends Mapper<kn_admin>{

    kn_admin queryList(Integer id);

    List<kn_admin> queryListPhone(String phone);

    int insertAndmin(kn_admin kn_admin);

    int countAndmin(String phone);

    kn_admin queryByid(String phone);

    /**
     * Description：(id，密码）
     * @author boyang
     * @date 2019/3/4 16:52
     * @param
     * @return
     */
    kn_admin queryByPhone(String phone);

    int UpdateLoginTime(kn_admin kn_admin);
    /**
     *
     * Description:查询获取所有level
     * @author willem
     * @date 2018年10月25日
     * @return
     */
        List<kn_admin> queryListAdmin(@Param("level") Integer level);


}