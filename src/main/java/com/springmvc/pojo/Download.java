package com.springmvc.pojo;

import javax.persistence.Column;

public class Download {

    private Integer id;


    //app下载链接
    @Column(name = "download_app")
    private String downloadApp;

    public Integer getId() {
        return id;
    }

    public String getDownloadApp() {
        return downloadApp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDownloadApp(String downloadApp) {
        this.downloadApp = downloadApp;
    }

    @Override
    public String toString() {
        return "Download{" +
                "id=" + id +
                ", downloadApp='" + downloadApp + '\'' +
                '}';
    }
}
