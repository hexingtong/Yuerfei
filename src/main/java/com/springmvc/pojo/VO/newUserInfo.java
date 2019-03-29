package com.springmvc.pojo.VO;

/**
 * @ClassName newUserInfo
 * @Description: 统计七天的新增用户
 * @Author by
 * @Date: 2019/3/27 17:58
 **/
public class newUserInfo {
    //时间
    private  String date ;
    //值
    private String value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "newUserInfo{" +
                "date='" + date + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
