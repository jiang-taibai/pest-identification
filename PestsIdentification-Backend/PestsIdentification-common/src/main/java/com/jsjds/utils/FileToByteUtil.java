package com.jsjds.utils;


import java.io.*;

import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>创建时间：2021/4/26 20:21</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */

public class FileToByteUtil {

    /**
     * 把一个文件转化为byte字节数组。
     */
    public static byte[] fileConvertToByteArray(File file) {
        byte[] data = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            data = baos.toByteArray();
            fis.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
