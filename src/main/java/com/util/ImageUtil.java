package com.util;

import com.springmvc.service.impl.kn_goodsServiceimpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

public class ImageUtil {
    /**
     *
     * @title:getRequeat
     * @description：获取前端数据
     * @return:List<FileItem>
     * @author:
     * @param request
     * @return
     * @throws
     * @throws UnsupportedEncodingException
     * @creatTime：2017年9月1日下午2:16:17
     */


    public static List<FileItem> getRequeat(HttpServletRequest request) throws FileUploadException, UnsupportedEncodingException{

        //使用Apache文件上传组件处理文件上传步骤：
        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8");
        //3、判断提交上来的数据是否是上传表单的数据
        //		if(!ServletFileUpload.isMultipartContent(request)){
        //		//按照传统方式获取数据
        //		return "nu";
        //		}
        //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
        List<FileItem> list = upload.parseRequest(request);

        return list;
    }
    /**
     *
     * @title:upload
     * @description：上传文件
     * @return:String
     * @author:
     * @param request
     * @return
     * @creatTime：2017年9月1日下午2:15:50
     */
    public static String upload(HttpServletRequest request,List<FileItem> list){
        String savePath = request.getServletContext().getRealPath(System.getProperty("file.separator")+"img");
//		String savePath = "D:\\workspace\\WoniuxyLearn\\WebRoot\\page\\image";
//		String savePath = "\\usr\\local\\tomcat\\webapps\\WoniuxyLearn\\page\\image";
        System.out.println(savePath);
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"目录不存在，需要创建");
            //创建目录
            file.mkdir();
            //System.out.println("-----MK DIR----"+file.mkdir());
        }
        System.out.println("文件大小是"+file.length());
        //消息提示
        String message = "";
        try{
            for(FileItem item : list){
                //如果fileitem中封装的是普通输入项的数据
                if(!item.isFormField()){//如果fileitem中封装的是上传文件
                    //得到上传的文件名称,
                    String filename = item.getName();
                    System.out.println(filename);
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如： c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf(System.getProperty("file.separator"))+1);
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    int st=(int)(Math.random()*9999)+100000;
                    String newpath = savePath + System.getProperty("file.separator")+DateUtil.getDateString() +st + filename;
                    FileOutputStream out = new FileOutputStream(newpath);
                    String type=pageUtils.getPicType(new FileInputStream(new File(newpath)));
                    if(pageUtils.checkSuffix(newpath)==true){
                        System.out.println("格式是对的");
                    }else {
                        System.out.println("格式不正确");
                    }
                    System.out.println(type);
//                    if(type.equals("jpg")||type.equals("gif")||type.equals("png")){
                        //创建一个缓冲区
                        byte buffer[] = new byte[1024];
                        //判断输入流中的数据是否已经读完的标识
                        int len = 0;
                        //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                        while((len=in.read(buffer))>0){
                            //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                            out.write(buffer, 0, len);
                        }
                        //关闭输入流
                        in.close();
                        //关闭输出流
                        out.close();
                        //删除处理文件上传时生成的临时文件
                        item.delete();
                        message = "文件上传成功！";
                        System.out.println(newpath+"------------========>");
                        System.out.println("判断的图片格式是******"+type);
                        int begin=newpath.indexOf("img");
                        int last=newpath.length();
                        String i=newpath.substring(begin,last).replace(System.getProperty("file.separator"),"/");
                        return i;
//                    }else{
//                        return "error";
//                    }


                }
            }
        }catch (Exception e) {
            message= "文件上传失败！";
            e.printStackTrace();
        }
        request.setAttribute("message",message);
        return null;
    }


}
