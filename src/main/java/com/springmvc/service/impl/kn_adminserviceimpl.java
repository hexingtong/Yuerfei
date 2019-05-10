package com.springmvc.service.impl;

import com.springmvc.mapping.FriendAdminMapper;
import com.springmvc.mapping.kn_adminMapper;
import com.springmvc.pojo.FriendAdmin;
import com.springmvc.pojo.LoanTerm;
import com.springmvc.pojo.VO.Regustered;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.FriendService;
import com.springmvc.service.kn_adminservice;
import com.util.DateUtils2;
import com.util.getRegistered.getzhuce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class kn_adminserviceimpl  extends BaseServiceImpl<kn_admin> implements kn_adminservice  {
    final Logger logger = LoggerFactory.getLogger(kn_adminserviceimpl.class);

    @Autowired
    private kn_adminMapper adminMapper;
    @Autowired
    private FriendAdminMapper friendAdminMapper;

    public kn_admin queryList(Integer id) {
        kn_admin knAdmin=adminMapper.queryList(id);
        return knAdmin;
    }

    public List<kn_admin> queryListPhone(String phone){
        List<kn_admin> kn_Admin=adminMapper.queryListPhone(phone);
        return kn_Admin;
    }

    public int insertAndmin(kn_admin kn_admin){
        int kn_Admin=adminMapper.insertAndmin(kn_admin);
        return kn_Admin;
    }

    public int countAndmin(String phone){
        int kn_Admin=adminMapper.countAndmin(phone);
        return kn_Admin;
    }
    public kn_admin queryByid(String phone){
        kn_admin knAdmin=adminMapper.queryByid(phone);
        return knAdmin;
    }
    public int UpdateLoginTime(kn_admin kn_admin){
        int knadmin=adminMapper.UpdateLoginTime(kn_admin);
        return knadmin;
    }


    /**
     * Description：通过用户名得到用户信息(id，密码）
     * @author boyang
     * @date 2019/3/4 16:50
     * @param
     * @return com.springmvc.pojo.kn_admin
     */
    @Override
    public kn_admin queryByPhone(String phone) {
        logger.info("传入手机号码"+"{"+phone+"}");
        kn_admin knAdmin;
        if (phone!=null){
            knAdmin= adminMapper.queryByPhone(phone);
            return  knAdmin;
        }else {
            logger.info("手机号码为空");
        }
        return null;
    }

    @Override
    public kn_admin selectUser(Integer id) {
        kn_admin knAdmin=new kn_admin();
        knAdmin=adminMapper.selectUser(id);
        return knAdmin;
    }

//    @Override
//    public List selectMonthRegistered(kn_admin kn_admin) {
//        List<Regustered> lst=adminMapper.selectMonthRegistered(kn_admin);
//        List lsts=new ArrayList();
//        List lst2=new ArrayList<>();
//        List<Regustered> lst3=new ArrayList();
//        List lst1=getzhuce.completionDate(lsts, DateUtils2.getBeGinDaYoFMoth(),DateUtils2.getDaysOfMonth(DateUtils2.getToYear(),DateUtils2.getToMonth()));
//        int sum=lst.size();
//        for (int z=0;z<lst.size();z++) {
//            Map map = new HashMap();
//            Regustered regustered=new Regustered();
//            regustered.setWeeks(lst.get(z).getWeeks());
//            regustered.setCount(lst.get(z).getCount());
//            lst3.add(regustered);
//            lsts.add(lst.get(z).getWeeks());
//            System.out.println(lst3.toString());
//            if(z==sum-1){
//                for (int i = 0; i < lst1.size(); i++) {
//                    Map map1 = new HashMap();
//                    for(int x=0;x<lst3.size();x++){
//                        System.out.println(lst3.get(x).getWeeks());
//                        System.out.println(lst3.get(x).getCount());
//                        if (lst1.get(i).toString().equals(lst3.get(x).getWeeks())) {
//                            System.out.println("时间相同");
//                            map1.put("weeks", lst3.get(x).getWeeks());
//                            map1.put("count", Integer.parseInt(lst3.get(x).getCount().toString()));
//                            logger.info("相同的时候的map"+map1.toString());
//                        }else {
//                            System.out.println("时间不同就赋值");
//                            map1.put("weeks", lst1.get(i).toString());
//                            map1.put("count", 0);
//                            logger.info("不相同的时候的map"+map1.toString());
//                        }
//                    }
//                    lst2.add(map1);
//                    System.out.println(lst2.toString());
//                }
//            }
//        }
//
//        return lst2;
//    }


    public List selectMonthRegistered(kn_admin kn_admin) {
        List lst=adminMapper.selectMonthRegistered(kn_admin);
        return  lst;
    }

    /**
     * Description： 短连接对应数据并进行扣量计算
     * @author boyang
     * @date 2019/5/8 10:46
     */
    @Override
    public List<Regustered> getMonthCountRegistered(String shortUrl) {
        //获取计算值
        List<Regustered> lst=adminMapper.getMonthCountRegistered(shortUrl);
        //得到当天和默认的扣量百分比
      FriendAdmin friendAdmin= friendAdminMapper.getQuantity(shortUrl);
      if (friendAdmin!=null&& lst!=null){
          for (Regustered li:lst){
              //等于单天的时候
                   if(li.getWeeks()==DateUtils2.getCurrDate(DateUtils2.LONG_DATE_FORMAT)){
                       logger.info("得到的当天的扣量"+friendAdmin.getIntradayquantity()+"当前的时间"+li.getWeeks()+"当前的值"+li.getCount());
                     li.setCount((int)Math.rint( (friendAdmin.getIntradayquantity()*0.01*li.getCount())));
                     logger.info("当天计算后的结果"+(int) ((100-friendAdmin.getIntradayquantity())*0.01*li.getCount()));
                   }else {
                       logger.info("得到的当天的扣量"+friendAdmin.getIntradayquantity()+"当前的时间"+li.getWeeks()+"当前的值"+li.getCount());
                       li.setCount((int) Math.rint(((100-friendAdmin.getDefaultquantity())*0.01*li.getCount())));
                       logger.info("默认计算后的结果"+(int) (friendAdmin.getDefaultquantity()*0.01*li.getCount()));
                   } }
                   }
        return lst;
    }

}
