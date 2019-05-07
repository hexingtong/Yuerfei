package com.util.qiniuUtil;

import java.io.File;
import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;


/**
 * @ClassName SimpleUpload
 * @Description:
 * @Author by
 * @Date: 2019/4/12 17:24
 **/
public class SimpleUpload {
    Auth auth = Auth.create(AccountMgr.ACCESS_KEY, AccountMgr.SECRET_KEY);
    Configuration cfg = new Configuration(Zone.zone0());
    StringMap policy = new StringMap();
    UploadManager uploadManager = new UploadManager(cfg);

    /**
     * 获取凭证
     *
     * @param bucketName 空间名称
     * @param key        如果需要覆盖上传则设置此参数
     * @return
     */
    public String getUpToken(String bucketName, String key) {
        return auth.uploadToken(bucketName);
    }

    /**
     * 上传方法1
     *
     * @param filePath   文件路径  （也可以是字节数组、或者File对象）
     * @param key        上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     * @param bucketName 空间名称  （这里是为了获取上传凭证）
     */
    public void upload(String filePath, String key, String bucketName) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(filePath, key, getUpToken(bucketName, key));
            // 打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                // ignore
            }
        }
    }

    /**
     * 上传方法2
     *
     * @param file       文件
     * @param key        上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     * @param bucketName 空间名称  （这里是为了获取上传凭证）
     */
    public void upload(File file, String key, String bucketName) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(file, key, getUpToken(bucketName, key));
            // 打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                // ignore
            }
        }
    }

    /**
     * 上传方法3 覆盖上传
     *
     * @param path       上传文件路径
     * @param bucketName 空间名
     * @param key        文件名
     */
    public void overrideUpload(String path, String key, String bucketName) {
        try {
            String token = getUpToken(bucketName, key);//获取 token
            Response response = uploadManager.put(path, key, token);//执行上传，通过token来识别 该上传是“覆盖上传”
            System.out.println(response.toString());
        } catch (QiniuException e) {
            System.out.println(e.response.statusCode);
            e.printStackTrace();
        }
    }

    public static String getUpTokenCover(String key, String bucket) {
        String accessKey = AccountMgr.ACCESS_KEY;
        String secretKey = AccountMgr.SECRET_KEY;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key);

        System.out.println(upToken);
        return upToken;

    }

    /**
     * Description：删除单个文件
     *
     * @param
     * @return
     * @author boyang bucketManager.delete(bucket, key);
     * @date 2019/4/27 10:15
     */
    public void deleteUpTokenCover(String key, String bucket) throws QiniuException {
        BucketManager bucketManager = new BucketManager(auth, cfg);
        bucketManager.delete(bucket, key);
    }

    /**
     * Description：自定义覆盖上传
     *
     * @param
     * @return
     * @author boyang
     * @date 2019/4/27 9:34
     */

    public String getUpTokens(String bucketname, String key) {
        //<bucket>:<key>，表示只允许用户上传指定key的文件。在这种格式下文件默认允许“修改”，已存在同名资源则会被本次覆盖。
        //如果希望只能上传指定key的文件，并且不允许修改，那么可以将下面的 insertOnly 属性值设为 1。
        //第三个参数是token的过期时间
        return auth.uploadToken(bucketname, key, 3600, new StringMap().put("insertOnly", 0));
    }

    public void uploads(String filePath, String key, String bucketname) throws IOException {
        try {
            //调用put方法上传，这里指定的key和上传策略中的key要一致
            Response res = uploadManager.put(filePath, key, getUpTokens(bucketname, key));
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore

            }
        }
    }
    /**
     * 主函数：程序入口，测试功能
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        SimpleUpload se = new SimpleUpload();
        //  se.uploads("D:\\an.png","tcweb1556260578679","generalize-app");
        se.deleteUpTokenCover("tcweb1556260578679.jpg", "generalize-app");

    }

}
