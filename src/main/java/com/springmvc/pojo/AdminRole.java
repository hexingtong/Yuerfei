package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Description：用户与角色关联表
 * @author boyang
 * @date 2019/3/5 19:06
 * @param 
 * @return 
 */
@Repository
public class AdminRole {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**角色id

     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     *
     * 用户id
     */
    @Column(name= "admin_id")
    private Long adminId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}