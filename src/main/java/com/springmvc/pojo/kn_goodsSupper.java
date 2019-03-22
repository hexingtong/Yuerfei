package com.springmvc.pojo;

import javax.persistence.Column;


public class kn_goodsSupper extends kn_goods {
    @Column(name = "ptitle")
    private String ptitle;

    private String pstatus;

    @Override
    public String toString() {
        return "kn_goodsSupper{" +
                "ptitle='" + ptitle + '\'' +
                ", pstatus='" + pstatus + '\'' +
                '}';
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public String getPstatus() {

        return pstatus;
    }

    public String getPtitle() {

        return ptitle;
    }
}
