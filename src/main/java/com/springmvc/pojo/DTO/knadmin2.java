package com.springmvc.pojo.DTO;

import com.springmvc.pojo.kn_admin;

import javax.persistence.Column;

/**
 * @ClassName knadmin2自定义dto
 * @Description:
 * @Author by
 * @Date: 2019/3/18 15:53
 **/
public class knadmin2 extends kn_admin {
    //角色名字
    @Column(name="role_name")
    private String roleName;
private String adminPhone;
//开始时间
    private String startTime;
    //结束时间
private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
