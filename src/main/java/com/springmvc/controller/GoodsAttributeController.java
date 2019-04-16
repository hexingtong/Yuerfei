package com.springmvc.controller;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapping.KnPropertyMapper;
import com.springmvc.pojo.JsonModel;
import com.springmvc.pojo.KnProperty;
import com.springmvc.pojo.PageResultInfo;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.PropertyService;
import com.util.ImageUtil;
import com.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

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

@Api(value="产品controller",tags={"产品操作接口"})
@Controller
@RequestMapping("/GoodsAttribute")
public class GoodsAttributeController {

    @Autowired
    PropertyService propertyService;

    final Logger logger = LoggerFactory.getLogger(MemberController.class);


/**
 * Description：跳到新增
 * @author boyang
 * @date 2019/3/19 15:33
 * @param
 * @return
 */
@ApiIgnore()
@RequestMapping("toAdd")
public String toAdd(Model model, Integer id) {
    return "productAdd";
}

    /**
     * Description：跳到产品属性编辑
     * @author boyang
     * @date 2019/3/18 10:01
     * @param
     * @return
     */
    @ApiIgnore()
    @RequestMapping("/toEdit")
    public String toEdit(Model model, Integer id){
        KnProperty property=  propertyService.queryById(id);
        model.addAttribute("property", property);
        return "productEditor";
    }

    /**
     * Description：, pageNo：当前页, pageSize：页容量,传入的手机号
     * @author boyang
     * @date 2019/3/7 11:04
     * @param response, pageNo, pageSize, 不做查询分页]
     * @return com.springmvc.pojo.PageResultInfo
     */
    @ApiOperation(value = "获得产品列表", httpMethod = "POST", response = StatusCode.class, notes = "获得产品列表")
    @RequestMapping("/getGoodsList")
    @ResponseBody
    public PageResultInfo getDataList(Model model, HttpServletResponse response,
                                        @RequestParam(value = "pageNo", defaultValue = "1",
                                              required = false)
                                              Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "90", required = false)
                                              Integer pageSize
                                                    ) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<KnProperty> pageInfo = new PageInfo<KnProperty>(propertyService.queryAll());
        PageResultInfo resultInfo = new PageResultInfo(pageInfo.getTotal(),pageInfo.getList());
        logger.info("传入的pageno,pagesize"+pageNo+":"+pageSize);
        return  resultInfo;


    }
    
    /**  
     * Description：增加产品属性
     * @author boyang（未测）
     * @date 2019/3/7 14:05
     * @param 
     * @return 
     */
    @ApiOperation(value = "增加产品属性", httpMethod = "POST", response = StatusCode.class, notes = "增加产品属性")
    @RequestMapping("/addAttribute")
    @ResponseBody
    public int save(@RequestBody KnProperty property) {
        logger.info("传入产品"+property);
        if (property!=null){
    property.setAddTime(new Date());
            propertyService.saveSelective(property);
            return 1;
        }else {
            return  0;
        }

    }
    /**
     * Description：删除产品属性
     * @author boyang(未测）
     * @date 2019/3/7 14:54
     * @param
     * @return
     */
    @ApiOperation(value = "删除产品属性", httpMethod = "POST", response = StatusCode.class, notes = "删除产品属性")
    @RequestMapping("/delete")
    @ResponseBody
    public int delete(Integer id) {
        logger.info("传入产品属性id"+id);
        if (id!=null){
            propertyService.deleteById(id);
            return 1;
        }else {
            return 0;
        }


    }
/**
 * Description：编辑产品属性接口
 * @author boyan
 * @date 2019g/3/18 11:28
 * @param
 * @return
 */
@ApiOperation(value = "编辑产品属性接口", httpMethod = "POST", response = StatusCode.class, notes = "编辑产品属性接口")
@RequestMapping("/updateAttribute")
@ResponseBody
public JsonModel updateAdmin(Integer id, String img,String title) {
    logger.info("传入用户id,img" + "{" + id + ":" + img + "}");
    KnProperty knProperty=new KnProperty();
    if (id!=null&& StringUtils.isNotEmpty(img)&&StringUtils.isNotEmpty(title)){
        knProperty.setImg(img);
        knProperty.setId(id);
        knProperty.setTitle(title);
    }
    String erro = "";
    try {
        propertyService.updateSelectiveById(knProperty);
        return new JsonModel(JsonModel.SUCCESS);
    } catch (Exception e) {
        erro = "更新异常";
        e.printStackTrace();
        return new JsonModel(JsonModel.FAILED, erro);
    }
}
    /**
     * @Author 苏俊杰
     * @Description //TODO  t
     * @Date 14:02 2019/4/8
     * @Param
     * @return
     **/
    @ApiIgnore()
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

    /**
     * 用户信息头像上传功能
     *
     * @param
     * @param
     * @return
     */
    @ApiOperation(value = "图片上传", httpMethod = "POST", response = StatusCode.class, notes = "图片上传")
    @RequestMapping("/addUserInfo")
    public void addUserInfo(HttpServletResponse response,HttpServletRequest request) throws IOException {
        try {
            List<FileItem> lst= ImageUtil.getRequeat(request);
            String i=ImageUtil.upload(request,lst);
            logger.info("返回的String值是--"+i);
            Object msg=request.getAttribute("message");
            logger.info(msg+"");
            if(i=="error"){
                logger.info("上传失败");
            }else{
                logger.info("上传成功");
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

}
