package com.springmvc.service;

import com.springmvc.pojo.LoanTerm;
import com.springmvc.pojo.VO.Regustered;
import com.springmvc.pojo.kn_admin;

import java.util.List;

public interface kn_adminservice  extends BaseService<kn_admin> {

    /**
     * 查询id
     * @param id
     * @return
     */
    kn_admin queryList(Integer id);



    /**
     * 根据手机号查询用户信息
     */
    List<kn_admin> queryListPhone(String phone);

    /**
     * 添加手机号和时间
     */
    int insertAndmin(kn_admin kn_admin);

    /**
     * 查询数据库有没有这个用户
     *
     */
    int countAndmin(String phone);

    /**
     * 根据手机号查到id值
     * @param phone
     * @return
     */
    kn_admin queryByid(String phone);

    /**
     * 根据id 修改最近登录时间
     */
    int UpdateLoginTime(kn_admin kn_admin);


    /**
     * Description：通过用户名得到用户信息(id，密码）
     * @author boyang
     * @date 2019/3/4 16:48
     * @param
     * @return
     */
    kn_admin queryByPhone(String phone);

    /**
     * 查询用户信息
     */
    kn_admin selectUser(Integer id);

    /**
     * @Author 苏俊杰
     * @Description //TODO 根据短链接查询一个月每天的注册总数
     * @Date 15:03 2019/4/19
     * @Param
     * @return
     **/
    List<Regustered> selectMonthRegistered(kn_admin kn_admin);
    /**
     * Description： 短连接对应数据并进行扣量计算
     * @author boyang
     * @date 2019/5/8 10:46
     * @param
     * @return
     */
    List<Regustered> getMonthCountRegistered(String shortUrl);

}
