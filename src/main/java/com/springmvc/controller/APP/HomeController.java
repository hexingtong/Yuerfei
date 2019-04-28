package com.springmvc.controller.APP;

import com.aliyuncs.utils.StringUtils;
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
import com.util.JsonResult;
import com.util.StatusCode;
import com.util.redis.RedisService;
import com.util.redis.impl.RedisPoolService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import springfox.documentation.annotations.ApiIgnore;

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
@ApiIgnore()
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
    @Autowired
    RedisService redisService;

    /**
     * Description：APP产品属性接口
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/3/8 15:19
     */
    @ApiOperation(value = "APP产品属性接口", httpMethod = "POST", response = StatusCode.class, notes = "APP产品属性接口")
    @RequestMapping("/getAttributelist")
    @ResponseBody
    public Map<String, List<KnProperty>> getPropertyList(HttpServletResponse response
    ) {
        Map<String, List<KnProperty>> map = new HashMap<String, List<KnProperty>>();

        map.put("property", propertyService.queryAll());
        return map;
    }

    /**
     * Description：精选列表接口模糊查找有精选的s
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/3/12 10:24
     */
    @ApiOperation(value = "精选列表接口", httpMethod = "POST", response = StatusCode.class, notes = "精选列表接口")
    @RequestMapping("/getGoodList")
    @ResponseBody
    public Map<String, List<kn_goods>> getGoods(HttpServletResponse response
    ) {
        Map<String, List<kn_goods>> map = new HashMap<String, List<kn_goods>>();
        knGoodsservice.queryByTagid().get(0).getId();
        map.put("goods", knGoodsservice.queryByTagid());
        return map;
    }

    /**
     * Description：得到公告
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/3/12 14:20
     */
    @ApiOperation(value = "得到公告", httpMethod = "POST", response = StatusCode.class, notes = "得到公告")
    @RequestMapping("/getNoticelist")
    @ResponseBody
    public Map<String, List<Notice>> getNotice(HttpServletResponse response
    ) {
        Map<String, List<Notice>> map = new HashMap<String, List<Notice>>();
        map.put("goods", noticeService.queryAll());
        return map;
    }

    /**
     * Description： 首页搜索接口
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/3/12 14:41
     */
    @ApiOperation(value = "首页搜索接口", httpMethod = "POST", response = StatusCode.class, notes = "首页搜索接口")
    @RequestMapping("/getGoodesName")
    @ResponseBody
    public Map<String, List<kn_goods>> getGoodesName(@RequestParam(value = "name", required = false) String name
    ) {
        logger.info("传入产品名称" + name);
        Map<String, List<kn_goods>> map = new HashMap<String, List<kn_goods>>();
        if (com.aliyuncs.utils.StringUtils.isNotEmpty(name)) {
            map.put("goods", knGoodsservice.queryGoodes(name));
            return map;
        } else {
            map.put("goods", knGoodsservice.getGoodsList());
            return map;
        }
    }
    /**
     * Description：首页搜索接口android
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/11 17:29
     */
    @ApiOperation(value = "首页搜索接口", httpMethod = "POST", response = StatusCode.class, notes = "首页搜索接口")
    @RequestMapping("/getGoodesNameAndroid")
    @ResponseBody
    public PageResultInfo getGoodesNameAndroid(Model model, HttpServletResponse response,
                                               @RequestParam(value = "pageNo", defaultValue = "1",
                                                       required = false)
                                                       Integer pageNo,
                                               @RequestParam(value = "pageSize", defaultValue = "8", required = false)
                                                       Integer pageSize,
                                               @RequestParam(value = "name", required = false) String name
    ) {
        logger.info("传入产品名称" + name);
        PageHelper.startPage(pageNo, pageSize);
        if (com.aliyuncs.utils.StringUtils.isNotEmpty(name)) {
            PageInfo<kn_goods> pageInfo = new PageInfo<kn_goods>(knGoodsservice.queryGoodes(name));
            PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
            return resultInfo;
        } else {
            PageInfo<kn_goods> pageInfo = new PageInfo<kn_goods>(knGoodsservice.getGoodsList());
            PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(), pageInfo.getList());
            return resultInfo;
        }
    }
    /**
     * Description：分页得到产品列表
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/2 10:26
     */
    @ApiOperation(value = "分页得到产品列表接口", httpMethod = "POST", response = StatusCode.class, notes = "分页得到产品列表接口")
    @RequestMapping("/getPageGoodsList")
    @ResponseBody
    public PageResultInfo getDataList(Model model, HttpServletResponse response,
                                      @RequestParam(value = "pageNo", defaultValue = "1",
                                              required = false)
                                              Integer pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "8", required = false)
                                              Integer pageSize) {
        logger.info("传入的pageno,pagesize,phone" + pageNo + ":" + pageSize);
        PageResultInfo resultInfo = knGoodsservice.pagegoodslist(pageNo, pageSize);
        return resultInfo;
    }

    /**
     * Description：返回qq号的接口,可以返回为空
     * @param
     * @return
     * @author boyang
     * @date 2019/4/19 13:43
     */
    @ApiOperation(value = "得到qq号码接口", httpMethod = "POST", response = StatusCode.class, notes = "得到qq号码接口")
    @RequestMapping("/getQQ")
    @ResponseBody
    public JsonResult getQQ() {
       // Jedis jedis = new Jedis("39.98.53.253", 6379);
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult.setData(redisService.get("qq"));

        } catch (Exception e) {
            jsonResult.setMessage("获取出错");
            jsonResult.setResult(JsonResult.ResultStatus.fail);
            jsonResult.setCode(StatusCode.CODE_ERROR);
            e.printStackTrace();
        }
        jsonResult.setCode(StatusCode.CODE_SUCCESS);
        jsonResult.setMessage("获取成功");
        jsonResult.setResult(JsonResult.ResultStatus.success);
        return jsonResult;
    }

    /**
     * Description：后台传入qq号接口
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/19 13:43
     */
    @ApiOperation(value = "保存qq号码接口", httpMethod = "POST", response = StatusCode.class, notes = "保存qq号码接口")
    @RequestMapping("/saveQQ")
    @ResponseBody
    public JsonResult saveQQ(String qq) {
       // Jedis jedis = new Jedis("39.98.53.253", 6379);
        JsonResult jsonResult = new JsonResult();
        try {
            if (StringUtils.isNotEmpty(qq)) {
                redisService.set("qq", qq);
            } else {
                redisService.set("qq", "null");
            }
        } catch (Exception e) {
            logger.info("qq保存失败");
            jsonResult.setMessage("保存出错");
            jsonResult.setCode(StatusCode.CODE_ERROR);
            e.printStackTrace();
        }
        logger.info("qq保存成功");
        jsonResult.setMessage("保存成功");
        jsonResult.setResult(JsonResult.ResultStatus.success);
        return jsonResult;
    }

    /**
     * Description：返回微信号的接口,可以返回为空
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/19 13:43
     */
    @ApiOperation(value = "得到微信号码接口", httpMethod = "POST", response = StatusCode.class, notes = "得到微信号码接口")
    @RequestMapping("/getWeixin")
    @ResponseBody
    public JsonResult getWeixing() {
       // Jedis jedis = new Jedis("39.98.53.253", 6379);
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult.setData(redisService.get("weixin"));

        } catch (Exception e) {
            jsonResult.setMessage("获取出错");
            jsonResult.setResult(JsonResult.ResultStatus.fail);
            jsonResult.setCode(StatusCode.CODE_ERROR);
            e.printStackTrace();
        }
        jsonResult.setMessage("获取成功");
        jsonResult.setCode(StatusCode.CODE_SUCCESS);
        jsonResult.setResult(JsonResult.ResultStatus.success);
        return jsonResult;
    }

    /**
     * Description：后台传入微信号接口
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/19 13:43
     */
    @ApiOperation(value = "保存微信号码接口", httpMethod = "POST", response = StatusCode.class, notes = "保存微信号码接口")
    @RequestMapping("/saveWeixin")
    @ResponseBody
    public JsonResult saveWeixing(String weiXing) {
       // Jedis jedis = new Jedis("39.98.53.253", 6379);
        JsonResult jsonResult = new JsonResult();
        try {
            if (StringUtils.isNotEmpty(weiXing)) {
                redisService.set("weixin", weiXing);
            } else {
                redisService.set("weixin", "null");
            }
        } catch (Exception e) {
            logger.info("微信保存失败");
            jsonResult.setMessage("保存出错");
            jsonResult.setCode(StatusCode.CODE_ERROR);
            e.printStackTrace();
        }
        logger.info("保存成功");
        jsonResult.setMessage("保存成功");
        jsonResult.setCode(StatusCode.CODE_SUCCESS);
        jsonResult.setResult(JsonResult.ResultStatus.success);
        return jsonResult;
    }
}
