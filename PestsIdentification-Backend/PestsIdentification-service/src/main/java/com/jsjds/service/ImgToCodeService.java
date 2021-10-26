package com.jsjds.service;

import com.jsjds.utils.ResponseWrapper;

/**
 * @author Yang Jiabin
 * @time 2021/6/28 14:21
 * @desc
 */
public interface ImgToCodeService {
    /**
     * 根据路径获取图片base64
     * @param imgPath 图片绝对路径
     * @return Base64码的图片
     */
    public String getFileBase64ByAbsolutePath(String imgPath);

    /**
     * 根据相对路径获得图片base64
     * @param imgRelativePath 图片相对路径
     * @return Base64码的图片
     */
    public ResponseWrapper getFileBase64ByRelativePath(String imgRelativePath);
}
