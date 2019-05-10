package com.springmvc.pojo.VO;

public class SmsPhonegetDvo {
    //状态码
    private String code;
    //msgId
    private String msgId;
    //time
    private String time;
    private String errorMsg;

    public String getCode() {
        return code;
    }

    public String getMsgId() {
        return msgId;
    }

    public String getTime() {
        return time;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "SmsPhonegetDvo{" +
                "code='" + code + '\'' +
                ", msgId='" + msgId + '\'' +
                ", time='" + time + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
