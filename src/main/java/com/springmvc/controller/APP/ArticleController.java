package com.springmvc.controller.APP;

import com.aliyuncs.utils.StringUtils;
import com.springmvc.pojo.VO.ArticleDetailVO;
import com.springmvc.service.ArticleService;
import com.util.JsonResult;
import com.util.StatusCode;
import com.util.redis.RedisService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ArticleController
 * @Description: 发帖业务类
 * @Author by
 * @Date: 2019/4/25 16:33
 **/
@Controller
@RequestMapping("/Article")
public class ArticleController {
    @Autowired
    RedisService redisService;
    @Autowired
    ArticleService articleService;

    /**
     * Description：判断用户是否达到发帖次数（每天重置）
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/25 16:35
     */
    @ApiOperation(value = "发帖次数接口", httpMethod = "POST", response = StatusCode.class, notes = "发帖次数接口")
    @RequestMapping("/getArticleStatus")
    @ResponseBody
    public JsonResult getAdvertising(String userId) {
        String nmuber = null;
        String count = redisService.get(userId);
        JsonResult jsonResult = new JsonResult();
        if (StringUtils.isNotEmpty(userId) && !"".equals(userId)) {
            //当redis没有这个值的时候，可以进入
            if (StringUtils.isEmpty(count)) {
                jsonResult.setCode(StatusCode.CODE_SUCCESS);
                nmuber = "0";
                jsonResult.setData(nmuber);
            } else {
                jsonResult.setCode(StatusCode.CODE_SUCCESS);
                jsonResult.setMessage("");
                nmuber = count;
                jsonResult.setData(nmuber);
            }
        } else {
            jsonResult.setMessage("传入为空");
        }
        return jsonResult;
    }


    /**
     * Description：发新帖子
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/26 10:41
     */
    @ApiOperation(value = "发帖接口", httpMethod = "POST", response = StatusCode.class, notes = "发帖接口")
    @RequestMapping("/sendArticle")

    @ResponseBody
    public JsonResult sendArticle(String textUrl, Integer userId) {
        return null;
    }

    /**
     * Description：发帖详情接口
     * @return
     * @author boyang
     * @date 2019/5/6 10:37
     * @paramLl
     */
    @ApiOperation(value = "发帖详情接口", httpMethod = "POST", response = StatusCode.class, notes = "发帖详情接口")
    @RequestMapping("/sendArticledetail")
    @ResponseBody
    public JsonResult sendArticledetail(Integer articleId,Integer userId) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData( articleService.getArticledetail(articleId,userId));
        return jsonResult;

    }
}
