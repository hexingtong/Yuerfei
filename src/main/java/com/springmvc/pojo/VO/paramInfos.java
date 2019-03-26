package com.springmvc.pojo.VO;

/**
 * @ClassName paramInfos 用来接收pv uv
 * @Description:
 * @Author by
 * @Date: 2019/3/25 17:22
 **/
public class paramInfos {
//次数
private String count;

//id
    private String name;
    //比率
    private String percent;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "paramInfos{" +
                "count='" + count + '\'' +
                ", name='" + name + '\'' +
                ", percent='" + percent + '\'' +
                '}';
    }
}
