package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Repository
public class Goodspvdata {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "goodId")
    private Integer goodid;


    private Integer pone;


    private Integer ptwo;

    private Integer pthree;


    private Integer pfour;

    private Integer pfive;


    private Integer psat;


    private Integer psunday;

    @Override
    public String toString() {
        return "Goodspvdata{" +
                "id=" + id +
                ", goodid=" + goodid +
                ", pone=" + pone +
                ", ptwo=" + ptwo +
                ", pthree=" + pthree +
                ", pfour=" + pfour +
                ", pfive=" + pfive +
                ", psat=" + psat +
                ", psunday=" + psunday +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getPone() {
        return pone;
    }

    public void setPone(Integer pone) {
        this.pone = pone;
    }

    public Integer getPtwo() {
        return ptwo;
    }

    public void setPtwo(Integer ptwo) {
        this.ptwo = ptwo;
    }

    public Integer getPthree() {
        return pthree;
    }

    public void setPthree(Integer pthree) {
        this.pthree = pthree;
    }

    public Integer getPfour() {
        return pfour;
    }

    public void setPfour(Integer pfour) {
        this.pfour = pfour;
    }

    public Integer getPfive() {
        return pfive;
    }

    public void setPfive(Integer pfive) {
        this.pfive = pfive;
    }

    public Integer getPsat() {
        return psat;
    }

    public void setPsat(Integer psat) {
        this.psat = psat;
    }

    public Integer getPsunday() {
        return psunday;
    }

    public void setPsunday(Integer psunday) {
        this.psunday = psunday;
    }
}