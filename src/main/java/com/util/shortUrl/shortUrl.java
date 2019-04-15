package com.util.shortUrl;


import com.util.MD5Utils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

import javax.security.sasl.SaslException;

/**
 * 短链接生成器
 *
 * @author zdz8207
 * @version v1.0, 2017-01-11
 * @since v1.0
 */
public class shortUrl {


    /**
     * 生成短链接
     *
     * @param url 长链接
     * @return 四个短地址数组，取任意一个即可
     */
    public static String[] getShortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "zxcs";
        System.out.println("key="+key);
        // 要使用生成 URL 的字符
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z","0","1","2","3","4","5","6","7","8","9"
        };

        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult = getMD5(key + url);

        String hex = sMD5EncryptResult;
        String[] resUrl = new String[4];

        //生成4个短地址，8位一组
        for (int i = 0; i < 4; i++) {

            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);
            // 这里需要使用 long 型来转换，因为 Inteper.parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用
            // long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            String outChars = "";
            //生成6次-6位短地址
            for (int j = 0; j < 6; j++) {

                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;

                // 把取得的字符相加
                outChars += chars[(int) index];

                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;

            }

            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;

        }

        return resUrl;

    }

    /**
     * 根据短链接获得key值
     *
     * @param shortUrl 短链接
     * @return key值 String
     */
    public static String getShortKey(String shortUrl) {
        String key = shortUrl.substring(shortUrl.lastIndexOf("/") + 1, shortUrl.length());
        return key;
    }

    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     * @throws SaslException
     */
    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            System.out.println("MD5加密出现错误");
            return "";
        }
    }


    public static String getShortUrlx(){
        String randomcode = "";
        // 用字符数组的方式随机
        String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] m = model.toCharArray();
        for (int j = 0; j < 6; j++) {
            char c = m[(int) (Math.random() * 36)];
            // 保证六位随机数之间没有重复的
            if (randomcode.contains(String.valueOf(c))) {
                j--;
                continue;
            }
            randomcode = randomcode + c;
        }
        return randomcode;
    }








    }
