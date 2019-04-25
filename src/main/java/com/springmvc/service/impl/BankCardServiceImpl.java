package com.springmvc.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.BankCardMapper;
import com.springmvc.pojo.BankCard;
import com.springmvc.pojo.DTO.knadmin2;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.service.BankCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BankCardServiceImpl
 * @Description: 银行卡业务逻辑类
 * @Author by
 * @Date: 2019/4/23 10:41
 **/
@Service
public class BankCardServiceImpl extends BaseServiceImpl<BankCard> implements BankCardService {
    final Logger logger = LoggerFactory.getLogger(kn_adminserviceimpl.class);
@Autowired
    BankCardMapper bankCardMapper;
    /**
     * Description：分页得到银行卡产品除精选
     * @author boyang
     * @date 2019/4/23 16:38
     * @param   pageNo, pageSize]
     * @return com.springmvc.pojo.PageResultInfo
     */
    @Override
    public PageResultInfo queryBankList(Integer pageNo, Integer pageSize) {
        logger.info("pageNo{"+pageNo+"},pageSize{"+pageSize+"}");
        PageHelper.startPage(pageNo, pageSize);
        List<BankCard> agentLevelSettings;
        agentLevelSettings=bankCardMapper.getBankCard();
        logger.info("获取admin表中所有数据");
        PageInfo<BankCard> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
        return resultInfo;
    }
    /**
     * Description：分页同id得到银行卡除精选
     * @author boyang
     * @date 2019/4/23 16:38
     * @param   pageNo, pageSize]
     * @return com.springmvc.pojo.PageResultInfo
     */
    @Override
    public PageResultInfo queryBankById(Integer pageNo, Integer pageSize, Integer Id) {
        logger.info("pageNo{"+pageNo+"},pageSize{"+pageSize+"},id{"+Id+"}");
        PageHelper.startPage(pageNo, pageSize);
        List<BankCard> agentLevelSettings;
        agentLevelSettings=bankCardMapper.getBankById(Id);
        PageInfo<BankCard> pageInfo = new PageInfo<>(agentLevelSettings);
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
        return resultInfo;
    }
    /**
     * Description：得到银行卡广告位接口
     * @author boyang
     * @date 2019/4/24 14:10
     * @param
     * @return
     */
    @Override
    public List<BankCard> getBankadvertisingList() {
        List<BankCard> list= bankCardMapper.getBankadvertisingList();

        return list;
    }
}
