package com.springmvc.pojo;

public class RequestIp {
    private String ip ;

    private long createTime;

    private Integer reCount;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setReCount(Integer reCount) {
        this.reCount = reCount;
    }

    public String getIp() {
        return ip;
    }

    public long getCreateTime() {
        return createTime;
    }

    public Integer getReCount() {
        return reCount;
    }

    @Override
    public String toString() {
        return "RequestIp{" +
                "ip='" + ip + '\'' +
                ", createTime=" + createTime +
                ", reCount=" + reCount +
                '}';
    }
}
