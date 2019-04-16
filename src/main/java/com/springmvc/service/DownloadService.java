package com.springmvc.service;

import com.springmvc.pojo.Download;

public interface DownloadService {


    /**
     * @Author 苏俊杰
     * @Description //TODO 查询下载链接
     * @Date 14:03 2019/4/14
     * @Param
     * @return
     **/
    Download selectDownload();


    /**
     * @Author 苏俊杰
     * @Description //TODO 编辑下载链接
     * @Date 14:04 2019/4/14
     * @Param
     * @return
     **/
    int updateDownload(Download download);
}
