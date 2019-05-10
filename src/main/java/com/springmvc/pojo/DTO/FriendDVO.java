package com.springmvc.pojo.DTO;

import com.springmvc.pojo.kn_friend;

public class FriendDVO extends kn_friend {
    //推广表
    private Integer friendId;
    //账号
    private String account;
    //密码
    private String pwd;
    //当天扣量
    private Integer intradayQuantity;
    //默认扣量
    private Integer defaultQuantity;

    public Integer getFriendId() {
        return friendId;
    }

    public String getAccount() {
        return account;
    }

    public String getPwd() {
        return pwd;
    }

    public Integer getIntradayQuantity() {
        return intradayQuantity;
    }

    public Integer getDefaultQuantity() {
        return defaultQuantity;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setIntradayQuantity(Integer intradayQuantity) {
        this.intradayQuantity = intradayQuantity;
    }

    public void setDefaultQuantity(Integer defaultQuantity) {
        this.defaultQuantity = defaultQuantity;
    }

    @Override
    public String toString() {
        return "FriendDVO{" +
                "friendId=" + friendId +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", intradayQuantity=" + intradayQuantity +
                ", defaultQuantity=" + defaultQuantity +
                '}';
    }
}
