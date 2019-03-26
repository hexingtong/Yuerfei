package com.springmvc.service;

import com.springmvc.pojo.Goodspvdata;
import org.springframework.stereotype.Service;

/**
 * @ClassName GoodsdataService
 * @Description:
 * @Author by
 * @Date: 2019/3/22 15:43
 **/

public interface GoodsPvDataService extends BaseService<Goodspvdata> {

    /**
     * Description： 定时更新总的pv
     * @author boyang
     * @date 2019/3/26 14:00
     * @param
     * @return
     */

       Integer unCountPv();


}
