package com.springmvc.mapping;

import com.springmvc.pojo.BankCard;
import io.swagger.models.auth.In;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Column;
import java.util.List;

public interface BankCardMapper extends Mapper<BankCard> {
    /**
     * Description： 查询银行卡接口排除精选
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/23 16:44
     */
    List<BankCard> getBankCard();

    /**
     * Description： 分页查询同一银行的卡
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/23 17:15
     */
    List<BankCard> getBankById(Integer Id);

    /**
     * Description：得到银行卡广告位接口
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/24 14:10
     */
    List<BankCard> getBankadvertisingList();

    /**
     * Description：后台分页得到银行卡展示
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/27 11:50
     */

    List<BankCard> getAllBank(BankCard bankCard);

    /**
     * Description：选择性插入数据
     *
     * @param
     * @return int
     * @author boyang
     * @date 2019/4/28 16:36
     */
    int insertSelective(BankCard record);

}