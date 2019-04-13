package com.util.qiniuUtil;

import com.google.gson.Gson;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.LoggerFactory;

import java.io.IOException;
/**
 * @ClassName QiniuTest
 * @Description:
 * @Author by
 * @Date: 2019/4/12 18:03
 **/
public class QiniuTest {
    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


    //设置好账号的ACCESS_KEY和SECRET_KEY
    final String ACCESS_KEY = "NC4as--LqlUuntfMzbaG4ERR6WkMIi5_oF3W44Gq";
    final String SECRET_KEY = "bR8kmDHsqhD5-gzIYsyb8ODKL9ovSB4CQQk48npX";
    //要上传的空间名称
    final String BUCKET_NAME = "generalize-app";

    public static Zone zonehd() {
        return (new Zone.Builder()).upHttp("http://up.qiniup.com").upHttps("https://up.qiniup.com").upBackupHttp("http://upload.qiniup.com").upBackupHttps("https://upload.qiniup.com").iovipHttp("http://iovip.qbox.me").iovipHttps("https://iovip.qbox.me").rsHttp("http://rs.qiniu.com").rsHttps("https://rs.qbox.me").rsfHttp("http://rsf.qiniu.com").rsfHttps("https://rsf.qbox.me").apiHttp("http://api.qiniu.com").apiHttps("https://api.qiniu.com").build();
    }
    /**
     * 七牛云上传图片
     * @param localFilePath
     * @return
     */
    public void uoloapQiniu (String localFilePath){
        logger.info("{七牛图片上传图片 。。。。开始}");
        String result = null;
        try {
            //构造一个带指定Zone对象的配置类
            Configuration cfg;
            //测试
            cfg = new Configuration(zonehd());
            //...其他参数参考类注释
            UploadManager uploadManager = new UploadManager(cfg);
            //...生成上传凭证，然后准备上传
            String accessKey = ACCESS_KEY;
            String secretKey = SECRET_KEY;
            String bucket = BUCKET_NAME;
            //设置上传后的文件名称
            String key = "tcweb" + System.currentTimeMillis() + ".jpg";
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                logger.info("{七牛图片上传图片文件:" + localFilePath + "}");
                Response response = uploadManager.put(localFilePath, key, upToken);//localFilePath
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                logger.info("{七牛图片上传key: " + putRet.key + ",七牛图片上传hash: " + putRet.hash + "}");
                logger.info(response.statusCode+"");//200为上传成功
                return ;

            } catch (QiniuException ex) {
                ex.printStackTrace();
                Response r = ex.response;

                System.err.println(r.toString());
                logger.info("{QiniuException上传图片异常: " + ex.error() + ":" + ex.code() + "}");

                result = null;
            }
        }catch (Exception e){
            logger.info("e--------"+e.toString());
            logger.info("{Exception上传图片异常2: " + e.getMessage()+"" +e.getLocalizedMessage() + "}");
        }
    }


    public static void main(String args[]) throws IOException {
        String path = "/Users/mini/Downloads/qiniu_test22.jpg";
        new QiniuTest().uoloapQiniu(path);
    }
}
