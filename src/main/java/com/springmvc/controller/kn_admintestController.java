package com.springmvc.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.StringUtil;
import com.springmvc.pojo.VO.SmsPhonegetDvo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.pojo.kn_friend;
import com.springmvc.service.FriendService;
import com.springmvc.service.MemberService;
import com.springmvc.service.impl.kn_goodsServiceimpl;
import com.springmvc.service.kn_adminservice;
import com.sun.javafx.collections.MappingChange;
import com.util.*;
import com.util.SCaptchaUtil.SCaptcha;
import com.util.token.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import springfox.documentation.annotations.ApiIgnore;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.util.SmsPhone.sendSms;

@Api(value = "app注册登录操作类", tags = {"登录接口"})
@Controller
@RequestMapping("/admin")
public class kn_admintestController {
    @Autowired
    private kn_adminservice knAdminservice;

    final Logger logger = LoggerFactory.getLogger(kn_goodsServiceimpl.class);

    @Autowired
    private FriendService friendService;

    /**
     * @Author 苏俊杰
     * @Description //TODO Web端发送验证码接口
     * @Date 16:59 2019/5/7
     * @Param
     * @return
     **/
    @ApiOperation(value = "WEB根据手机号发送验证码", httpMethod = "POST", response = StatusCode.class, notes = "参数 Phone(手机号) SCode(图片验证码)")
    @RequestMapping(value = "/smsPhone1")
    @ResponseBody
    public void test(HttpSession session,HttpServletResponse response, String Phone,String SCode) {
        List<kn_admin> lst = new ArrayList();
        ListObject listObject = new ListObject();
        Jedis jedis = new Jedis("39.98.53.253",6379);
        try {
            if (StringUtil.isEmpty(Phone)&&Phone.equals("")) {
                listObject.setCode(StatusCode.CODE_ERROR);
                listObject.setMsg("手机号为空！");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
            Date now=new Date();
            Long codeTime = Long.valueOf(session.getAttribute("codeTime") + "");
            Object cko = session.getAttribute("simpleCaptcha");
            if (cko == null){
                listObject.setCode(StatusCode.CODE_NULL);
                listObject.setMsg("请输入验证码!");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
            String captcha = cko.toString();
            // 判断验证码输入是否正确
            if (StringUtils.isEmpty(SCode) || captcha == null || !(SCode.equalsIgnoreCase(captcha))) {
                listObject.setCode(StatusCode.FAILED);
                listObject.setMsg("验证码输入错误!");
                // 验证码有效时长为1分钟
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            } else if ((now.getTime() - codeTime) / 1000 / 60 > 1) {
                listObject.setCode(StatusCode.CODE_NULL);
                listObject.setMsg("验证码已失效,请重新点击验证码!");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            } else {
                // 在这里可以处理自己需要的事务，比如验证登陆等
                if((session.getAttribute("simpleCaptcha").toString()).equalsIgnoreCase(SCode)){
                    SmsPhone.setNewcode();
                    String code = SmsPhone.getNewcode();
                    SmsPhonegetDvo smsPhonegetDvo =SmsPhone.smsSend(Phone,code);
                    logger.info("短信接口返回的数据----------------");
                    logger.info("Code=" + smsPhonegetDvo.getCode());
                    logger.info("验证码为:" + code);
                    if (smsPhonegetDvo.getCode().equals("0")){
                        logger.info("成功");
//               session.setAttribute("SmsCode", code);
//               session.setAttribute("Smsphones", Phone);
                        String rc = "SmsCode" + Phone;
                        String rp = "SmsPhone" + Phone;
                        //验证码存redis中
                        jedis.set("SmsCode" + Phone + "", code);
                        //手机号存redis中
                        jedis.set("SmsPhone" + Phone + "", Phone);
                        //设置时间为毫秒
                        jedis.pexpire("SmsCode" + Phone + "", 1800000);
                        logger.info("redis里的验证码为：" + jedis.get(rc));
                        logger.info("redis的手机号为：" + jedis.get(rp));
                        jedis.pexpire("SmsPhone" + Phone + "", 1800000);
                        listObject.setCode(StatusCode.CODE_SUCCESS);
                        listObject.setMsg("发送成功！");
                        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                    } else {
                        logger.info("失败");
                        listObject.setCode("9527");
                        listObject.setMsg(smsPhonegetDvo.getErrorMsg());
                        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            listObject.setCode(StatusCode.CODE_ERROR_503);
            listObject.setMsg("请先获取图片验证码");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }


    //发送验证码接口
    @ApiOperation(value = "根据手机号发送验证码", httpMethod = "POST", response = StatusCode.class, notes = "根据手机号发送验证码")
    @RequestMapping(value = "/smsPhone")
    @ResponseBody
    public void test(HttpServletResponse response, String Phone) {
        List<kn_admin> lst = new ArrayList();
        ListObject listObject = new ListObject();
        Jedis jedis = new Jedis("39.98.53.253",6379);
        try {
            if (StringUtil.isEmpty(Phone)&&Phone.equals("")) {
                listObject.setCode(StatusCode.CODE_ERROR);
                listObject.setMsg("手机号为空！");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
            SmsPhone.setNewcode();
            String code = SmsPhone.getNewcode();
            SmsPhonegetDvo smsPhonegetDvo =SmsPhone.smsSend(Phone,code);
            logger.info("短信接口返回的数据----------------");
            logger.info("Code=" + code);
            logger.info("验证码为:" + code);
            if (smsPhonegetDvo.getCode().equals("0")) {
                logger.info("成功");
//               session.setAttribute("SmsCode", code);
//               session.setAttribute("Smsphones", Phone);
                String rc = "SmsCode" + Phone;
                String rp = "SmsPhone" + Phone;
                //验证码存redis中
                jedis.set("SmsCode" + Phone + "", code);
                //手机号存redis中
                jedis.set("SmsPhone" + Phone + "", Phone);
                //设置时间为毫秒
                jedis.pexpire("SmsCode" + Phone + "", 1800000);
                logger.info("redis里的验证码为：" + jedis.get(rc));
                logger.info("redis的手机号为：" + jedis.get(rp));
                jedis.pexpire("SmsPhone" + Phone + "", 1800000);
                listObject.setCode(StatusCode.CODE_SUCCESS);
                listObject.setMsg("发送成功！");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            } else {
                logger.info("失败");
                listObject.setCode("9527");
                listObject.setMsg("错误");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ApiOperation(value = "根据手机号和验证码登录", httpMethod = "POST", response = StatusCode.class, notes = "根据手机号和验证码登录")
    @RequestMapping(value = "/login" ,method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public void login(HttpSession session, HttpServletResponse response, String PhoneCode, String Phone, HttpServletRequest request,
                      @RequestParam(value = "index",
                              defaultValue = "0", required = false)String index,
                      @RequestParam(value = "shortUrl",
            defaultValue = "", required = false)String shortUrl) {
        ListObject listObject = new ListObject();
        ListObjectSuper listObjectSuper = new ListObjectSuper();
        Jedis jedis = new Jedis("39.98.53.253",6379);
        List<kn_admin> lst = new ArrayList();
        String rc = "SmsCode" + Phone;
        //拿取redis里的值
        String redisCode = jedis.get(rc);
        String rp = "SmsPhone" + Phone;
        String redisPhone = jedis.get(rp);
        logger.info("redis验证码为:" + redisCode + "redis手机号为:" + redisPhone);
        logger.info("PhoneCode" + PhoneCode + "Phone" + Phone);
        logger.info(redisPhone);
        if (StringUtil.isEmpty(PhoneCode) || PhoneCode.equals("")) {
            listObject.setMsg("验证码为空！");
            listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
        if (StringUtil.isEmpty(Phone) || Phone.equals("")) {
            listObject.setMsg("手机号为空！");
            listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
        if (StringUtil.isNotEmpty(redisPhone) && !redisPhone.equals("") && StringUtil.isNotEmpty(redisCode) && !redisCode.equals("")) {
            logger.info("------------------获取redis的code 为：" + redisCode + "Phones" + redisPhone);
            kn_admin kn = new kn_admin();
            //判断验证码是否一致
            if (redisCode.equals(PhoneCode) && redisPhone.equals(Phone)) {
                //判断是否注册
                int i = knAdminservice.countAndmin(Phone);
                if (i > 0) {
                    //已经注册
                    kn_admin kns = knAdminservice.queryByid(Phone);
                    List<kn_admin> lsx = new ArrayList();
                    logger.info("已注册:" + Phone);
                    logger.info("测试数据");
                    kn_admin knAdmin2 = new kn_admin();
                    knAdmin2.setPhone(Phone);
                    session.setAttribute("id", kns.getId());
                    Object ids = session.getAttribute("id");
                    String id = ids.toString();
                    String tokens = jedis.get("token" + id);
                    String token = TokenTest.TokenTest(id);
                    //token 解析方法
                    //TokenTest.ValidToken(token);
                    //date日期转换
                    String dateUtil = DateUtil.getNowDate();
                    Date utilDate = DateUtil.stringToDate(dateUtil);
                    //修改最后一次登录时间
                    kn_admin kna = new kn_admin();
                    kna.setLoginTime(utilDate);
                    kna.setId(Integer.parseInt(id));
                    knAdminservice.UpdateLoginTime(kna);
                    kn_admin knx = new kn_admin();
                    lsx = knAdminservice.queryListByWhere(knAdmin2);
                    //转null为空字符串
                    if (lsx.get(0).getFrendSource() == null) {
                        lsx.get(0).setFrendSource("");
                    }
                    listObjectSuper.setMsg("登录成功！");
                    listObjectSuper.setCode(StatusCode.CODE_SUCCESS);
                    listObjectSuper.setItems(lsx);
                    listObjectSuper.setToken(token);
                    //存入token
                    jedis.set("token" + id + "", token);
                    //设置时间为毫秒
                    jedis.pexpire("token", 1296000000);
                    jedis.close();
                    logger.info("登录成功：已注册用户");
                    ResponseUtils.renderJson(response, JsonUtils.toJson(listObjectSuper));
                } else {
                    if (index.equals("1")) {
                        //推广链接进入的
                        logger.info("进入埋点!");
//                    String url=request.getHeader("Referer");
                        logger.info("url的值是" + shortUrl);
                        List<kn_friend> list = friendService.queryAll();
                        kn_friend[] kn_friends = new kn_friend[list.size()];
                        for (int c = 0; c < list.size(); c++) {
                            kn_friends[c] = list.get(c);
                            logger.info("数据库的url" + kn_friends[c].getShortUrl());
                            if (kn_friends[c].getShortUrl().equals(shortUrl)) {
                                //当前url的注册+1
                                //update `kn_friend` set enrollment=enrollment+1 where url = 'https://12i.cn/00Sebf'
                                int q = friendService.updateFriendZhuce(shortUrl);
                                if (q > 0) {
                                    logger.info("埋点成功啦！");
                                } else {
                                    logger.info("埋点失败了! QAQ");
                                    listObjectSuper.setMsg("发生未知错误,请重新注册！");
                                    listObjectSuper.setCode(StatusCode.CODE_ERROR_PARAMETER);
                                    ResponseUtils.renderJson(response, JsonUtils.toJson(listObjectSuper));
                                }
                            }

                        }
                    }
                    //没有注册
                    logger.info("未注册:");
                    kn.setPhone(Phone);
                    String dateUtil = DateUtil.getNowDate();
                    Date utilDate = DateUtil.stringToDate(dateUtil);
                    kn.setAddTime(utilDate);
                    kn.setLoginTime(utilDate);
                    String bs = IPutil.isClient(request);
                    logger.info("注册来源" + bs);
                    //添加注册来源
                    kn.setRegisteredSource(bs);
                    //添加注册渠道
                    kn.setFrendSource(shortUrl);
                    logger.info("Date时间:");
                    if (knAdminservice.insertAndmin(kn) > 0) {
                        logger.info("注册成功！");
                        //根据手机号查询id
                        kn_admin kns = knAdminservice.queryByid(Phone);
                        session.setAttribute("id", kns.getId());
                        logger.info("测试id值" + session.getAttribute("id"));
                        Object ids = session.getAttribute("id");
                        String id = ids.toString();
                        System.out.println();
                        String token = TokenTest.TokenTest(id);
                        TokenTest.ValidToken(token);
                        listObject.setMsg("注册成功&&通过验证");
                        listObject.setCode(StatusCode.CODE_SUCCESS);
                        logger.info("id数据:" + id);
                        kn_admin knAdmin2 = new kn_admin();
                        knAdmin2.setPhone(Phone);
                        lst = knAdminservice.queryListByWhere(knAdmin2);
                        if (lst.get(0).getFrendSource() == null) {
                            lst.get(0).setFrendSource("");
                        }
                        listObjectSuper.setItems(knAdminservice.queryListPhone(Phone));
                        listObjectSuper.setItems(lst);
                        listObjectSuper.setToken(token);
                        //存入token
                        jedis.set("token" + id, token);
                        logger.info(jedis.get(token + id));
                        //设置时间为毫秒
                        jedis.pexpire("token" + id + "", 1296000000);
                        jedis.close();
                        logger.info("注册登录成功:未注册用户");
                        listObjectSuper.setMsg("注册成功!");
                        listObjectSuper.setCode(StatusCode.CODE_SUCCESS);
                        ResponseUtils.renderJson(response, JsonUtils.toJson(listObjectSuper));
                    } else {
                        logger.info("注册失败！");
                        listObject.setMsg("注册失败！");
                        listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                        listObject.setItems(lst);
                        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
                    }
                }
            }
            else {
                listObject.setItems(lst);
                listObject.setMsg("验证码不正确或手机号不正确");
                listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
                listObject.setItems(lst);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        } else {
            listObject.setCode(StatusCode.CODE_ERROR);
            listObject.setMsg("验证码已失效或手机号失效");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }


    /**
     * @Author 苏俊杰
     * @Description //TODO 判断图片验证码是否正确
     * @Date 15:26 2019/5/7
     * @Param
     * @return
     **/
    @ApiOperation(value = "判断图片验证码是否正确", httpMethod = "POST", response = StatusCode.class, notes = "参数 SCode(用户输入的图片验证码)")
    @RequestMapping(value = "/ScaptchaBoolean",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JsonResult checkcode(HttpServletRequest request,
                            HttpSession session,
                            String SCode) throws Exception {

        // 获得验证码对象
        JsonResult result=new JsonResult();
        Date now=new Date();
        try {
            Long codeTime = Long.valueOf(session.getAttribute("codeTime") + "");
            Object cko = session.getAttribute("simpleCaptcha");
            if (cko == null) {
                result.setCode(StatusCode.CODE_NULL);
                result.setMessage("请输入验证码!");
                return result;
            }
            String captcha = cko.toString();
            // 判断验证码输入是否正确
            if (StringUtils.isEmpty(SCode) || captcha == null || !(SCode.equalsIgnoreCase(captcha))) {
                result.setCode(StatusCode.FAILED);
                result.setMessage("验证码输入错误!");
                // 验证码有效时长为1分钟
                return result;

            } else if ((now.getTime() - codeTime) / 1000 / 60 > 1) {
                result.setCode(StatusCode.CODE_NULL);
                result.setMessage("验证码已失效,请重新点击验证码!");
                return result;
            } else {
                // 在这里可以处理自己需要的事务，比如验证登陆等
                result.setCode(StatusCode.SUCCESSFULLY);
                result.setMessage("验证成功!");
                return result;
            }
        }catch (NumberFormatException e){
                e.getLocalizedMessage();
            result.setCode(StatusCode.FAILED);
            result.setMessage("请先获取图片验证码!");
            return result;
        }
    }


    /**
     * @return
     * @Author 苏俊杰
     * @Description //TODO 根据推广链接查询30天注册人数
     * @Date 10:35 2019/4/20
     * @Param
     * @return
     **/
        @ApiOperation(value = "查询最近30天的注册人数", httpMethod = "POST", response = StatusCode.class, notes = "查询最近30天的注册人数")
        @RequestMapping(value = "/slectRegistered",method = {RequestMethod.POST, RequestMethod.GET})
        public void selectRegistered(HttpServletResponse response,kn_admin kn_admin){
            ListObject listObject=new ListObject();
            List lst=knAdminservice.selectMonthRegistered(kn_admin);
            listObject.setItems(lst);
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("查询成功");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    /**
     * Description：指定短连接的推广链接注册人数,要通过扣量百分比
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/5/8 10:38
     */
    @ApiOperation(value = "查询推广注册人数", httpMethod = "POST", response = StatusCode.class, notes = "查询推广注册人数")
    @RequestMapping("/getRegistered")
    @ResponseBody
    public JsonResult getRegistered(HttpServletResponse response, String shortUrl) {
        JsonResult jsonResult = null;
        if (StringUtils.isNotEmpty(shortUrl)){
            try {
                jsonResult = new JsonResult();
                jsonResult.setData(knAdminservice.getMonthCountRegistered(shortUrl));
                jsonResult.setCode(StatusCode.SUCCESSFULLY);
                jsonResult.setMessage("返回成功扣量后的百分比");
            } catch (Exception e) {
                jsonResult.setMessage("返回错误");
                jsonResult.setCode(StatusCode.FAILED);
                e.printStackTrace();
            }
        }else {
            jsonResult.setMessage("传入值为空");

        }

        return jsonResult;
    }
    /**
     * 用于生成带四位数字验证码的图片
     */
    @ApiOperation(value = "生成图片验证码", httpMethod = "POST", response = StatusCode.class, notes = "生成图片验证码")
    @RequestMapping(value = "/userInfo/verification")
    @ResponseBody
    public String imagecode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        JsonResult result=new JsonResult();
        OutputStream os = response.getOutputStream();
        //返回验证码和图片的map
        Map<String,Object> map = SCaptcha.getImageCode(86, 37, os);
        String simpleCaptcha = "simpleCaptcha";
        request.getSession().setAttribute(simpleCaptcha, map.get("strEnsure").toString().toLowerCase());
        request.getSession().setAttribute("codeTime",new Date().getTime());
        try {
            ImageIO.write((BufferedImage) map.get("image"), "jpg", os);
        } catch (IOException e) {
            result.setMessage("发生异常："+e.getLocalizedMessage());
            result.setCode(StatusCode.FAILED);
            return "";
        }   finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }
        return "";
    }


}
