package com.util.SCaptchaUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 验证码生成器
 *
 */
public class SCaptcha {
//    // 图片的宽度。
//    private int width = 120;
//    // 图片的高度。
//    private int height = 40;
//    // 验证码字符个数
//    private int codeCount = 4;
//    // 验证码干扰线数
//    private int lineCount = 50;
//    // 验证码
//    private String code = null;
//    // 验证码图片Buffer
//    private BufferedImage buffImg = null;
//
//    private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'P', 'Q', 'R',
//            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
//    // 生成随机数
//    private Random random = new Random();
//
//    public SCaptcha() {
//        this.createCode();
//    }
//
//    /**
//     *
//     * @param width 图片宽
//     * @param height 图片高
//     */
//    public SCaptcha(int width, int height) {
//        this.width = width;
//        this.height = height;
//        this.createCode();
//    }
//
//    /**
//     *
//     * @param width 图片宽
//     * @param height 图片高
//     * @param codeCount 字符个数
//     * @param lineCount 干扰线条数
//     */
//    public SCaptcha(int width, int height, int codeCount, int lineCount) {
//        this.width = width;
//        this.height = height;
//        this.codeCount = codeCount;
//        this.lineCount = lineCount;
//        this.createCode();
//    }
//
//    public void createCode() {
//        int codeX = 0;
//        int fontHeight = 0;
//        fontHeight = height - 5;// 字体的高度
//        codeX = width / (codeCount + 3);// 每个字符的宽度
//
//        // 图像buffer
//        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        Graphics2D g = buffImg.createGraphics();
//
//        // 将图像填充为白色
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, width, height);
//
//        // 创建字体
//        ImgFontByte imgFont = new ImgFontByte();
//        Font font = imgFont.getFont(fontHeight);
//        g.setFont(font);
//
//        StringBuffer randomCode = new StringBuffer();
//        // 随机产生验证码字符
//        for (int i = 0; i < codeCount; i++) {
//            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
//            // 设置字体颜色
//            g.setColor(getRandomColor());
//            // 设置字体位置
//            g.drawString(strRand, (i + 1) * codeX, getRandomNumber(height / 2) + 25);
//            randomCode.append(strRand);
//        }
//        code = randomCode.toString();
//    }
//
//    /** 获取随机颜色 */
//    private Color getRandomColor() {
//        int r = getRandomNumber(255);
//        int g = getRandomNumber(255);
//        int b = getRandomNumber(255);
//        return new Color(r, g, b);
//    }
//
//    /** 获取随机数 */
//    private int getRandomNumber(int number) {
//        return random.nextInt(number);
//    }
//
//    public void write(String path) throws IOException {
//        OutputStream sos = new FileOutputStream(path);
//        this.write(sos);
//    }
//
//    public void write(OutputStream sos) throws IOException {
//        ImageIO.write(buffImg, "png", sos);
//        sos.close();
//    }
//
//    public BufferedImage getBuffImg() {
//        return buffImg;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    /** 字体样式类 */
//    class ImgFontByte {
//        public Font getFont(int fontHeight) {
//            try {
//                Font baseFont = Font.createFont(Font.HANGING_BASELINE, new ByteArrayInputStream(
//                        hex2byte(getFontByteStr())));
//                return baseFont.deriveFont(Font.PLAIN, fontHeight);
//            } catch (Exception e) {
//                return new Font("Arial", Font.PLAIN, fontHeight);
//            }
//        }
//
//        private byte[] hex2byte(String str) {
//            if (str == null)
//                return null;
//            str = str.trim();
//            int len = str.length();
//            if (len == 0 || len % 2 == 1)
//                return null;
//
//            byte[] b = new byte[len / 2];
//            try {
//                for (int i = 0; i < str.length(); i += 2) {
//                    b[i / 2] = (byte) Integer.decode("0x" + str.substring(i, i + 2)).intValue();
//                }
//                return b;
//            } catch (Exception e) {
//                return null;
//            }
//        }
//
//        // 字体文件的十六进制字符串
//        private String getFontByteStr() {
//            //防止报字符串长度过长错误，改为从配置文件读取
//            return ReadFontByteProperties.getFontByteStr();
//        }
//    }
//--------------------------------------------------------------------------生成图形验证码第二种方法--------------------------------------------------------------------------------------------------------
private static char mapTable[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static Map<String, Object> getImageCode(int width, int height, OutputStream os) {
        Map<String,Object> returnMap = new HashMap<String, Object>();
        if (width <= 0) width = 60;
        if (height <= 0) height = 20;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        //生成随机类
        Random random = new Random();
        // 设定背景色
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        //设定字体
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        // 随机产生168条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 168; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        //取随机产生的码
        String strEnsure = "";
        //4代表4位验证码,如果要生成更多位的认证码,则加大数值
        for (int i = 0; i < 4; ++i) {
            strEnsure += mapTable[(int) (mapTable.length * Math.random())];
            // 将认证码显示到图象中
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            // 直接生成
            String str = strEnsure.substring(i, i + 1);
            // 设置随便码在背景图图片上的位置
            g.drawString(str, 13 * i + 20, 25);
        }
        // 释放图形上下文
        g.dispose();
        returnMap.put("image",image);
        returnMap.put("strEnsure",strEnsure);
        return returnMap;
    }
    //给定范围获得随机颜色
    static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

}
