package com.springmvc.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.BankCardMapper;
import com.springmvc.pojo.BankCard;
import com.springmvc.pojo.DTO.knadmin2;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.service.AllBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AllBankServiceImpl
 * @Description: 自定义银行卡接口
 * @Author by
 * @Date: 2019/4/27 11:36
 **/
@Service
public class AllBankServiceImpl extends BaseServiceImpl<BankCard> implements AllBankService {
    final Logger logger = LoggerFactory.getLogger(AllBankServiceImpl.class);
    @Autowired
    BankCardMapper bankCardMapper;

    /**
     * Description： 分页得到所有银行卡接口
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/27 11:40
     */
    @Override
    public PageResultInfo queryListBankCard(Integer pageNo, Integer pageSize, String title) {

        logger.info("传入的pageno,pagesize,phone,startTime,endTime{" + pageNo + "}:{" + pageSize + "}:{" + title + "}{" );
        PageHelper.startPage(pageNo, pageSize);
        BankCard bankCard = new BankCard();
        List<BankCard> agentLevelSettings;
        bankCard.setTitle(title == null ? null : title);
        agentLevelSettings = bankCardMapper.getAllBank(bankCard);
        logger.info("获取admin表中所有数据");
        PageInfo<BankCard> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
        return resultInfo;

    }
}
