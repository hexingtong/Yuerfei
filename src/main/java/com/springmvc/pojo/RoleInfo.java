package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Description：角色表
 * @author boyang
 * @date 2019/3/5 19:39
 * @param 
 * @return 
 */
@Repository
public class RoleInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.id
     *
     * @mbg.generated Tue Mar 05 18:04:04 CST 2019
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     *
     角色名字
     */
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "parentId")
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}