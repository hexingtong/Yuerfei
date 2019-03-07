package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**  
 * Description：角色权限关联表
 * @author boyang
 * @date 2019/3/5 19:38
 * @param 
 * @return 
 */
@Repository
public class RoleFunction {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     *
     角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     *
     权限id
     */
    @Column(name = "function_id")
    private Integer functionId;

    /**
     *
     显示状态
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}