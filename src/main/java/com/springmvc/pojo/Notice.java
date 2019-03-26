package com.springmvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Description：公共表
 * @author boyang
 * @date 2019/3/12 14:07
 * @param
 * @return
 */
@Repository
  public class Notice {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;


    private String notice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addtime;

    @Column(name="index_loan")
    private Integer indexLoan;

    public void setIndexLoan(Integer indexLoan) {
        this.indexLoan = indexLoan;
    }

    public Integer getIndexLoan() {

        return indexLoan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}