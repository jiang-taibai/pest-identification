package com.jsjds.service.impl;

import com.alibaba.fastjson.JSON;
import com.jsjds.mapper.InsectImagesMapper;
import com.jsjds.pojo.InsectImages;
import com.jsjds.service.PestImageService;
import com.jsjds.utils.FileToByteUtil;
import com.jsjds.utils.FileUtil;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * <p>创建时间：2021/4/26 18:51</p>
 * <p>主要功能：提供害虫ID，返回单张图片、多张不分类图片或分类图片</p>
 * <p> 单张图片用于首页每日一图、查询结果页的图片预览、害虫详情页的单张图片 </p>
 * <p> 多张不分类图片暂且不做 </p>
 * <p> 分类图片用于害虫详情图片页的展示 </p>
 *
 * @author 太白
 */
@Service
public class PestImageServiceImpl implements PestImageService {

    @Autowired
    public InsectImagesMapper insectImagesMapper;

    @Value("${pest-image-path.prefix}")
    public String prefixPath;

    @Value("${pest-image-path.defaultAlbumName}")
    public String defaultAlbumName;

    /**
     * 通过害虫ID得到 一 张图片的相对路径
     *
     * @param speciesId 害虫ID
     * @return 通过害虫ID得到 一 张图片的相对路径
     */
    @Override
    public ResponseWrapper getPestImageAbsolutePathBySpeciesId(String speciesId) {
        File topFile = getTopFile(speciesId);
        File baseDir = new File(prefixPath);
        if (!topFile.exists()) {
            return ResponseWrapper.markSuccessButNoData();
        }
        File[] fileList = topFile.listFiles();
        List<File> allPics = new ArrayList<>();
        if(fileList == null || fileList.length == 0) {
            return ResponseWrapper.markError("尚无图片资源");
        }
        for (File dir : fileList) {
            File[] pics = dir.listFiles();
            if(pics == null) continue;
            allPics.addAll(Arrays.asList(pics));
        }
        if(allPics.size() == 0) {
            return ResponseWrapper.markError("尚无图片资源");
        } else {
            int subIndex = (int) (Math.random() * allPics.size());
            File targetFile = allPics.get(subIndex);
            String data = FileUtil.getRelativeFileName(baseDir, targetFile);
            return ResponseWrapper.markSuccess(data);
        }
    }

    /**
     * 通过害虫ID得到 多种分类的多张图片相对路径列表，
     * 害虫图片分类的名称规则同子文件夹名称，例如子文件夹有【生态图片】、【标本图片】、【幼虫】等，那么标题就应当是文件夹名称
     *
     * @param speciesId 害虫ID
     * @return 子文件夹有【生态图片】、【标本图片】、【幼虫】等，那么标题就应当是文件夹名称
     */
    @Override
    public ResponseWrapper getPestClassifiedImageAbsolutePathBySpeciesId(String speciesId) {
        File topFile = getTopFile(speciesId);
        File baseDir = new File(prefixPath);
        if (!topFile.exists()) {
            return ResponseWrapper.markSuccessButNoData();
        }
        File[] fileList = topFile.listFiles();
        Map<String, List<String>> res = new TreeMap<>();
        for (File file : fileList) {
            if (file.isDirectory()) {
                String typeName = file.getName();       // 该文件夹的名字
                if(typeName.equals(defaultAlbumName)) {
                    // 如果是未分类，不应该展示给用户观看
                    continue;
                }
                File[] typeImages = file.listFiles();   // 得到该文件夹下所有图片文件
                List<String> list = new ArrayList<>();
                // 约定该文件夹下不会再有文件夹，全部都是图片文件
                for (File typeImage : typeImages) {
                    if(typeImage.isFile()) {
                        list.add(FileUtil.getRelativeFileName(baseDir, typeImage));
                    }
                }
                res.put(typeName, list);
            }
        }
        return ResponseWrapper.markSuccess(res);
    }

    /**
     * 通过害虫ID找到轮询六张图片，如果没有六张则找到最多的几张
     *
     * @param speciesId 害虫ID
     * @return 六张图片的Base64码
     */
    @Override
    public ResponseWrapper getPestIntroImagesBySpeciesId(String speciesId) {
        File topFile = getTopFile(speciesId);
        File baseDir = new File(prefixPath);
        if (!topFile.exists()) {
            return ResponseWrapper.markSuccessButNoData();
        }
        File[] fileList = topFile.listFiles();
        List<List<File>> listDouble = new ArrayList<>();
        int maxSize = 0;
        for (File file : fileList) {
            if (file.isDirectory()) {
                File[] typeImages = file.listFiles();   // 得到该文件夹下所有图片文件
                // 约定该文件夹下不会再有文件夹，全部都是图片文件
                assert typeImages != null;
                List<File> list = new ArrayList<>(Arrays.asList(typeImages));
                listDouble.add(list);
                maxSize = Math.max(maxSize, list.size());
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            for (List<File> files : listDouble) {
                if (i < files.size()) {
//                    res.add(JSON.toJSONString(
//                            FileToByteUtil.fileConvertToByteArray(
//                                    files.get(i))));
                    res.add(FileUtil.getRelativeFileName(baseDir, files.get(i)));
                    if (res.size() >= 6) break;
                }
            }
            if (res.size() >= 6) break;
        }
        return ResponseWrapper.markSuccess(res);
    }

    private File getTopFile(String speciesId) {
        InsectImages insectImage = insectImagesMapper.selectByPrimaryKey(speciesId);
        String topPath_relative = insectImage.getImgPath();         // 相对路径
        String topPath_absolute = prefixPath + topPath_relative;    // 绝对路径
        File topFile = new File(topPath_absolute);
        return topFile;
    }
}
