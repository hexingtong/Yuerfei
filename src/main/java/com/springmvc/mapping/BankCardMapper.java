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
     * @author boyang
     * @date 2019/4/23 17:15
     * @param
     * @return
     */
    List<BankCard> getBankById( Integer Id);
    /**
     * Description：得到银行卡广告位接口
     * @author boyang
     * @date 2019/4/24 14:10
     * @param
     * @return
     */
    List<BankCard> getBankadvertisingList();

}