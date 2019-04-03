package com.springmvc.controller.APP;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.Notice;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_goods;
import com.springmvc.service.NoticeService;
import com.springmvc.service.PropertyService;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.springmvc.service.kn_goodsservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HomeController
 * @Description: App首页接口
 * @Author by
 * @Date: 2019/3/11 18:05
 **/
@RequestMapping("/APP")
@Controller
public class HomeController {
    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);
    @Autowired
PropertyService propertyService;
@Autowired
kn_goodsservice knGoodsservice;
@Autowired
NoticeService noticeService;
    /**
     * Description：APP产品属性接口
     * @author boyang
     * @date 2019/3/8 15:19
     * @param
     * @return
     */
    @RequestMapping("/getAttributelist")
    @ResponseBody
    public Map<String,List<KnProperty>> getPropertyList(HttpServletResponse response
    ) {
        Map<String,List<KnProperty>>map=new HashMap<String,List<KnProperty>>();

        map.put("property",propertyService.queryAll());
        return map;
    }


    /**
     * Description：精选列表接口模糊查找有精选的s
     * @author boyang
     * @date 2019/3/12 10:24
     * @param
     * @return
     */
    @RequestMapping("/getGoodList")
    @ResponseBody
    public Map<String,List<kn_goods>> getGoods(HttpServletResponse response
    ) {
        Map<String,List<kn_goods>>map=new HashMap<String,List<kn_goods>>();

        map.put("goods",knGoodsservice.queryByTagid());
        return map;
    }
    /**
     * Description：得到公告
     * @author boyang
     * @date 2019/3/12 14:20
     * @param
     * @return
     */
    @RequestMapping("/getNoticelist")
    @ResponseBody
    public Map<String,List<Notice>> getNotice(HttpServletResponse response
    ) {
        Map<String,List<Notice>>map=new HashMap<String,List<Notice>>();
        map.put("goods",noticeService.queryAll());
        return map;
    }

    /**
     * Description： 首页搜索接口
     * @author boyang
     * @date 2019/3/12 14:41
     * @param
     * @return
     */
    @RequestMapping("/getGoodesName")
    @ResponseBody
    public Map<String,List<kn_goods>> getGoodesName(@RequestParam(value = "name", required = false)String name
    ) {
        logger.info("传入产品名称"+name);
        Map<String,List<kn_goods>>map=new HashMap<String,List<kn_goods>>();
        if (com.aliyuncs.utils.StringUtils.isNotEmpty(name)){
            map.put("goods",knGoodsservice.queryGoodes(name));
            return map;
        }else {
           map.put("goods",knGoodsservice.getGoodsList());
           return  map;
        }


    }
/**
 * Description：分页得到产品列表
 * @author boyang
 * @date 2019/4/2 10:26
 * @param
 * @return
 */
@RequestMapping("/getPageGoodsList")
@ResponseBody
public PageResultInfo getDataList(Model model, HttpServletResponse response,
                                  @RequestParam(value = "pageNo", defaultValue = "1",
                                          required = false)
                                          Integer pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = "8", required = false)
                                          Integer pageSize
) {
    logger.info("传入的pageno,pagesize,phone"+pageNo+":"+pageSize);
    PageResultInfo resultInfo = knGoodsservice.pagegoodslist(pageNo,pageSize);

    return  resultInfo;


}
}
