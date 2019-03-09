package com.springmvc.controller;

import com.springmvc.mapping.KnPropertyMapper;
import com.springmvc.pojo.JsonModel;
import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.service.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName GoodsAttributeController
 * @Description:产品属性类这里和产品没有关联
 * @Author by
 * @Date: 2019/3/6 18:22
 **/
@Controller
@RequestMapping("/GoodsAttribute")
public class GoodsAttributeController {

@Autowired
    PropertyService propertyService;

    final Logger logger = LoggerFactory.getLogger(MemberController.class);

    /**
     * Description：, pageNo：当前页, pageSize：页容量,传入的手机号
     * @author boyang
     * @date 2019/3/7 11:04
     * @param response, pageNo, pageSize, 不做查询分页]
     * @return com.springmvc.pojo.PageResultInfo
     */
    @RequestMapping("/getGoodsList")
    @ResponseBody
    public List<KnProperty> getDataList(Model model, HttpServletResponse response,
                                        @RequestParam(value = "pageNo", defaultValue = "1",
                                              required = false)
                                              Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "3", required = false)
                                              Integer pageSize) {
        logger.info("传入的pageno,pagesize"+pageNo+":"+pageSize);
        return  propertyService.queryListByPage(pageNo,pageSize);


    }
    
    /**  
     * Description：增加产品属性
     * @author boyang（未测）
     * @date 2019/3/7 14:05
     * @param 
     * @return 
     */
    @RequestMapping("/addAttribute")
    @ResponseBody
    public int save(KnProperty property) {
        logger.info("传入产品"+property);
        if (property.getId()!=null){
    property.setAddTime(new Date());
            propertyService.saveSelective(property);
        }else {
            propertyService.updateSelectiveById(property);
        }
         return  property.getId();
    }
    /**
     * Description：删除产品属性
     * @author boyang(未测）
     * @date 2019/3/7 14:54
     * @param
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public int delete(Integer id) {
        logger.info("传入产品属性id"+id);
        if (id!=null){
            propertyService.deleteById(id);
        }else {
            return 0;
        }

        return 1;
    }


    /**
     * 图片文件上传
     */
    @ResponseBody
    @RequestMapping("/uploadImg.xhtml")
    public JsonModel uploadPicture(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request,HttpServletResponse response){
       // ResponseResult result = new ResponseResult();
        Map<String, Object> map = new HashMap<String, Object>();
        File targetFile=null;
        String url="";//返回存储路径
        int code=1;
        System.out.println(file);
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/upload/imgs/";//存储路径
            String path = request.getSession().getServletContext().getRealPath("upload/imgs"); //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名

            //先判断文件是否存在
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String fileAdd = sdf.format(new Date());
            //获取文件夹路径
            File file1 =new File(path+"/"+fileAdd);
            //如果文件夹不存在则创建
            if(!file1 .exists()  && !file1 .isDirectory()){
                file1 .mkdir();
            }
            //将图片存入文件夹
            targetFile = new File(file1, fileName);
            try {
                //将上传的文件写到服务器上指定的文件。
                file.transferTo(targetFile);
                url=returnUrl+fileAdd+"/"+fileName;
                code=0;
               /* result.setCode(code);
                result.setMessage("图片上传成功");*/
                map.put("url", url);
                /*result.setResult(map);*/
            } catch (Exception e) {
                e.printStackTrace();
               /* result.setMessage("系统异常，图片上传失败");*/
            }
        }
        return  new JsonModel();
    }

}
