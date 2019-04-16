package com.springmvc.controller;

import com.springmvc.pojo.Download;
import com.springmvc.service.DownloadService;
import com.util.JsonUtils;
import com.util.ListObject;
import com.util.ResponseUtils;
import com.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Api(value="app下载链接页面controller",tags={"下载链接操作接口"})
@Controller
@RequestMapping("/download")
public class DownloadContiroller {

    @Autowired
    private DownloadService downloadService;

    /**
     * @Author 苏俊杰
     * @Description //TODO 查询app下载链接
     * @Date 14:16 2019/4/14
     * @Param []
     * @return void
     **/
    @ApiOperation(value = "查询app下载链接", httpMethod = "POST", notes = "查询app下载链接")
    @RequestMapping("/selectDownload")
    @ResponseBody
    public void selectDownload(HttpServletResponse response){
        List lst=new ArrayList();
        ListObject listObject=new ListObject();
        Download download=downloadService.selectDownload();
        listObject.setMsg("查询成功");
        listObject.setCode(StatusCode.CODE_SUCCESS);
        lst.add(download);
        listObject.setItems(lst);
        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
    }

    /**
     * @Author 苏俊杰
     * @Description //TODO 编辑app下载链接
     * @Date 14:20 2019/4/14
     * @Param
     * @return
     **/
    @ApiOperation(value = "编辑app下载链接", httpMethod = "POST", response = Download.class, notes = "编辑app下载链接")
    @RequestMapping("/updateDownload")
    @ResponseBody
    public void updateDownload(HttpServletResponse response,Download download){
        ListObject listObject=new ListObject();
        int i=downloadService.updateDownload(download);
        if(i>0){
            listObject.setMsg("增加成功");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }else {
            listObject.setMsg("增加失败");
            listObject.setCode(StatusCode.CODE_ERROR_PARAMETER);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

}
