package com.jsjds.utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;
//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
//import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.commons.codec.binary.Base64;

/**
 * <p>Creation Time: 2021-07-07 22:58:32</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class ImageUtil {

    //定义一个正则表达式的筛选规则，为了获取图片的类型
    private static final Pattern pattern = Pattern.compile("data:image/(.*?);base64");

    public static File saveImg(String baseImg, String savePath, String fileName) {
        String type = getSubUtilSimple(baseImg);
        //去除base64图片的前缀
        baseImg = baseImg.replaceFirst("data:(.+?);base64,", "");
        byte[] b = null;
        byte[] bs;
        OutputStream os = null;
        //把图片转换成二进制
        try {
            b = Base64.decodeBase64(baseImg.replaceAll(" ", "+"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //随机生成图片的名字，同时根据类型结尾
        fileName = fileName + "." + type;
        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
        File imageFile = new File(savePath + File.separator + fileName);
        BASE64Decoder d = new BASE64Decoder();
        // 保存
        try {
            bs = d.decodeBuffer(Base64.encodeBase64String(b));
            os = new FileOutputStream(imageFile);
            os.write(bs);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.getLocalizedMessage();
                }
            }
        }
        return imageFile;
    }

    private static String getSubUtilSimple(String soap) {
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            return m.group(1);
        }
        return "";
    }
}
