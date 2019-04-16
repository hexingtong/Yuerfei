package com.springmvc.service.impl;

import com.springmvc.mapping.DownloadMapper;
import com.springmvc.pojo.Download;
import com.springmvc.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private DownloadMapper downloadMapper;

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询app下载链接
     * @Date 14:12 2019/4/14
     * @Param []
     * @return com.springmvc.pojo.Download
     **/
    @Override
    public Download selectDownload() {
        Download download=downloadMapper.selectDownload();
        return download;
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 编辑app下载链接
     * @Date 14:12 2019/4/14
     * @Param [id]
     * @return int
     **/
    @Override
    public int updateDownload(Download download) {
        int i=downloadMapper.updateDownload(download);
        if(i>0){
            return i;
        }
        return 0;
    }
}
