package com.springmvc.controller;

import com.jayway.jsonpath.spi.Mode;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_tag;
import com.springmvc.service.KnTagService;
import com.springmvc.service.MemberService;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Tag")
public class TagController {

    @Autowired
    private KnTagService knTagService;

    //标签展示页面and查询
    @RequestMapping("/MercjatTagList")
    @ResponseBody
    public void MercjatTag(Mode model, HttpServletResponse response, @RequestParam(value = "pageNo",
            defaultValue = "1", required = false) Integer pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "7", required = false)
                                   Integer pageSize, String title) {
        ListObjectPage listObject = new ListObjectPage();
        List lst = new ArrayList();
        kn_tag knTag = new kn_tag();

        PageResultInfo resultInfo = knTagService.queryListTag(pageNo, pageSize, title);
        if (resultInfo != null) {
            lst.add(resultInfo);
            listObject.setMsg("查询成功");
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setItems(lst);
            Integer pagenum=Integer.parseInt(String.valueOf(resultInfo.getTotal()));
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        } else {
            listObject.setMsg("查询失败");
            System.out.println("查询失败");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }

    }

    //标签增加页面
    @RequestMapping("/MercjatTagListIncrease")
    @ResponseBody()
    public void MercjatTagListIncrease(HttpServletResponse response, String title) {
        kn_tag knTag = new kn_tag();
        ListObject listObject = new ListObject();
        if (!"".equals(title) && title != null) {
            knTag.setTitle(title);
            String dateUtil = DateUtil.getNowDate();
            Date utilDate = DateUtil.stringToDate(dateUtil);
            knTag.setAddTime(utilDate);
            int i = knTagService.MercjatTagIncrease(knTag);
            if (i > 0) {
                listObject.setCode(StatusCode.CODE_SUCCESS);
                listObject.setMsg("增加成功");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            } else {
                listObject.setCode(StatusCode.CODE_SUCCESS);
                listObject.setMsg("增加失败");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        } else {
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("title不能为空");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }

    }


    //编辑标签页面
    @RequestMapping("/MercjatTagListUpadete")
    @ResponseBody
    public void MercjatTagListIncrease(HttpServletResponse response, Integer id, String title) {
        kn_tag knTag = new kn_tag();
        ListObject listObject = new ListObject();
        if (id != null && !"".equals(id) && title != null && !"".equals(title)) {
            knTag.setTitle(title);
            knTag.setId(id);
            int i = knTagService.MercjatTagUpadete(knTag);
            if (i > 0) {
                listObject.setCode(StatusCode.CODE_SUCCESS);
                listObject.setMsg("更新成功");
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            } else {
                listObject.setMsg("更新失败");
                listObject.setCode(StatusCode.CODE_ERROR);
                ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
            }
        } else {
            listObject.setMsg("id或title为空");
            listObject.setCode(StatusCode.CODE_ERROR);
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

    //标签删除页面
    @RequestMapping("/TagDelete")
    @ResponseBody
    public void TagDelete(HttpServletResponse response, Integer id) {
        ListObject listObject = new ListObject();
        int i = knTagService.MercjatTagDelete(id);
        if (i > 0) {
            listObject.setCode(StatusCode.CODE_SUCCESS);
            listObject.setMsg("删除成功");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        } else {
            listObject.setCode(StatusCode.CODE_ERROR);
            listObject.setMsg("删除失败");
            ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));
        }
    }

}
