package com.jsjds.service.impl;

import com.jsjds.service.ImgToCodeService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Objects;

/**
 * @author Yang Jiabin
 * @time 2021/6/28 14:22
 * @desc
 */
@Service
public class ImgToCodeServiceImpl implements ImgToCodeService {

    @Value("${pest-image-path.prefix}")
    private String topDirPath;

    @Override
    public String getFileBase64ByAbsolutePath(String imgPath) {
        byte[] data = null;
        String result = null;
        File imgFile = new File(imgPath);
        if (!imgFile.exists()){
            System.out.println("找不到路径为" + imgPath + "的文件");
            return result;
        }
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        // 返回Base64编码过的字节数组字符串
        result = encoder.encode(Objects.requireNonNull(data));
//        System.out.println("本地图片转换Base64:");
//        System.out.println(result);

        return result;
    }

    /**
     * 根据相对路径获得图片base64
     *
     * @param imgRelativePath 图片相对路径
     * @return Base64码的图片
     */
    @Override
    public ResponseWrapper getFileBase64ByRelativePath(String imgRelativePath) {
        String res = getFileBase64ByAbsolutePath(topDirPath + File.separator + imgRelativePath);
        return ResponseWrapper.markSuccess(res);
    }
}
