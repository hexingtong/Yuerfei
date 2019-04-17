package com.springmvc.service.impl;

import com.springmvc.pojo.Person;
import com.springmvc.pojo.VO.Datacountpvuv;
import com.springmvc.pojo.kn_goods;
import com.springmvc.service.FriendTimer;
import com.springmvc.service.PvUvDataService;
import com.springmvc.service.kn_goodsservice;
import com.util.redis.RedisService;
import com.util.redis.impl.RedisPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PvUvDataServiceImpl
 * @Description:
 * @Author by
 * @Date: 2019/4/15 14:25
 **/
@Service
public class PvUvDataServiceImpl implements PvUvDataService {





    @Autowired
    private kn_goodsservice knGoodsservice;
    @Override
    public List getcountPvUv() {
        //得到产品所有的pvuv
        List<kn_goods> goods=knGoodsservice.getGoodsList();
        List<Person> lst = new ArrayList<>();
        List<Person> lst2 = new ArrayList<>();
        String format = "day";
        Jedis jedis=new Jedis("47.92.53.177",6379);
int to=0;
        for (kn_goods gos:goods){
            //把redis清楚

            Person[] person= FriendTimer.DatePvUv(gos.getShortUrl(), format);

            if (to==0){
                for (int i = 0; i < person.length; i++) {

                    System.out.println(person[i].toString());

                    to+=1;
                    lst2.add(person[i]);
                }
            }else {
                for (int i = 0; i < person.length; i++) {
                    System.out.println(person[i].toString());
                    lst.add(person[i]);
                }
            }

//两次list集合当id相等的时候相加


        }
        for(Person pers2:lst2){

            for(Person pers:lst){

                if(pers2.getId()==pers.getId()){
                    System.out.println("pers2.getUv()"+pers2.getUv()+"pers.getUv()"+pers.getUv());
                    pers2.setUv((Integer.parseInt(pers2.getUv())+Integer.parseInt(pers.getUv()))+"");
                    pers2.setVisitCount((Integer.parseInt(pers2.getVisitCount())+Integer.parseInt(pers.getVisitCount()))+"");
                    pers2.setDay(pers2.getDay());
                }
            }
        }
        for(Person pers2:lst){
            System.out.println("合并的"+pers2.toString());
        }
        for(Person pers2:lst2){
            System.out.println("合并的lst2"+pers2.toString());
        }
        return lst2;
    }
}

