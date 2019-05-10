package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.springmvc.pojo.Person;
import com.springmvc.pojo.VO.SmsPhonegetDvo;
import com.util.sms.request.SmsReportRequest;
import com.util.sms.request.SmsSendRequest;
import com.util.sms.request.SmsVariableRequest;
import com.util.sms.response.SmsReportResponse;
import com.util.sms.response.SmsSendResponse;
import com.util.sms.response.SmsVariableResponse;
import com.util.sms.util.ChuangLanSmsUtil;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: ZouLF
 * @Date: 2018/5/29 10:49
 * @Description: 短信验证码测试
 */
public class SmsPhone {


    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIZqIQKeA19Nww";
    static final String accessKeySecret = "xK5oLTTMPbhitBAMXHUO2UdHNYCzRc";



    public static SendSmsResponse sendSms(String telephone, String code) throws ClientException {

        // 可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        // 初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        // 组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        // 必填:待发送手机号
        request.setPhoneNumbers(telephone);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName("52卡盟"); // TODO 改这里
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_151175428");  // TODO 改这里
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的用户,您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\"" + code + "\"}");

        // 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        // request.setSmsUpExtendCode("90997");

        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        // hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
            System.out.println("短信发送成功！");
        }else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }


    private static String newcode;

    public static String getNewcode() {
        return newcode;
    }

    public static void setNewcode(){
        newcode  =String.valueOf(new Random().nextInt(899999) + 100000);  //每次调用生成一次六位数的随机数
    }


//-----------------------------------------------------------------以下为创蓝通讯短信接口----------------------------------------------------------------------------------------------------------
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 创蓝短信通讯
     * @Date 15:37 2019/4/28
     * @Param [args]
     * @return void
     **/
    //创蓝api账号
     final static String  ACCOUNT="N4762662";
    //创蓝api密码
     final static String PASSWORD="Nq4Op5Uk6";
    //编码格式
    public static final String charset = "utf-8";


    /**
     * @Author 苏俊杰
     * @Description //TODO 创蓝拉取状态报告
     * @Date 15:49 2019/4/28
     * @Param []
     * @return com.util.JsonResult
     **/
    public JsonResult smsReport(){
        //拉取状态报告的URL 请登录zz.253.com 获取完整的URL接口信息
        JsonResult jsonResult=new JsonResult();
        String smsReportRequestUrl = "http://smssh1.253.com/msg/send/json";
        //状态报告拉取条数
        String count = "1";
        SmsReportRequest smsReportRequest = new SmsReportRequest(ACCOUNT, PASSWORD, count);
        String requestJson = JSON.toJSONString(smsReportRequest);
        System.out.println("before request string is: " + requestJson);
        String response = ChuangLanSmsUtil.sendSmsByPost(smsReportRequestUrl, requestJson);
        System.out.println("response after request result is : " + response);
        SmsReportResponse smsReportRespnse = JSON.parseObject(response, SmsReportResponse.class);
        System.out.println("response  toString is : " + smsReportRespnse.getResult());
        
        return jsonResult;
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 变量短信发送
     * @Date 15:52 2019/4/28
     * @Param []
     * @return void
     **/
    public void smsVariable(){
        //变量短信发送的URL 请登录zz.253.com 获取完整的URL接口信息
        String smsVariableRequestUrl = "https://xxx/msg/variable/json";
        //设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
        String msg = "【253云通讯】尊敬的{$var},您好,您的验证码是{$var},{$var}分钟内有效";
        //参数组
        String params = "187********,女士,123456,3;130********,先生,123456,3;";
        //状态报告
        String report= "true";
        SmsVariableRequest smsVariableRequest=new SmsVariableRequest(ACCOUNT, PASSWORD, msg, params, report);
        String requestJson = JSON.toJSONString(smsVariableRequest);
        System.out.println("before request string is: " + requestJson);
        String response = ChuangLanSmsUtil.sendSmsByPost(smsVariableRequestUrl, requestJson);
        System.out.println("response after request result is : " + response);
        SmsVariableResponse smsVariableResponse = JSON.parseObject(response, SmsVariableResponse.class);
        System.out.println("response  toString is : " + smsVariableResponse);
    }
    
    /**
     * @Author 苏俊杰
     * @Description //TODO 短信发送
     * @Date 15:57 2019/4/28
     * @Param []
     * @return void
     **/
    public static SmsPhonegetDvo  smsSend(String phone,String code){
        String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
        String time="15";
        String msg = "【鱼儿飞】尊敬的用户，您本次的验证码为"+code+"有效期"+time+"分钟。 ";
        //是否需要状态报告（默认false） 如需状态报告则传true（如需要状态报告和上行的拉取或者推送，必须为true）
        String report= "false";
        //下发短信号码扩展码  纯数字，需保证手机端口号加自定义扩展码总位数不超过20位，建议1-3位，如需上行短信推送或拉取则必填
//        String extend = "123";
        //一般可以设置订单号或者短信发送记录流水号，用于区分短信业务，总位数不超过40位
        //String uid = "abc123";
        //SmsSendRequest smsSingleRequest = new SmsSendRequest(ACCOUNT, PASSWORD, msg, phone,report,extend);
        SmsSendRequest smsSingleRequest = new SmsSendRequest(ACCOUNT, PASSWORD, msg, phone,report);
        String requestJson = JSON.toJSONString(smsSingleRequest);
        System.out.println("请求的字符串为:"+requestJson);
        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);
        System.out.println("请求结果后的响应为:"+response);
        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);
        System.out.println("对字符串的响应是 :" + smsSingleResponse);


        JSONObject obj = JSONObject.parseObject( response.toString());

        JSONObject  j=JSONObject.parseObject(JSON.toJSONString(obj));
        SmsPhonegetDvo person=new SmsPhonegetDvo();
        person.setCode(obj.get("code").toString());
        person.setErrorMsg(obj.get("errorMsg").toString());
        String codex=person.getCode();
        return person;
    }







    public static void main(String[] args) throws Exception {
//        setNewcode();
//        String code = getNewcode();
//        SendSmsResponse sendSms =sendSms("13022061304",code);//填写你需要测试的手机号码
//        System.out.println("短信接口返回的数据----------------");
//        System.out.println("Code=" + sendSms.getCode());
//        System.out.println("Message=" + sendSms.getMessage());
//        System.out.println("RequestId=" + sendSms.getRequestId());
//        System.out.println("BizId=" + sendSms.getBizId());

    }
}
