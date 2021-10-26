package com.jsjds.service;

import com.jsjds.utils.ResponseWrapper;

import java.util.List;
import java.util.Map;

/**
 * <p>创建时间：2021/4/26 16:55</p>
 * <p>主要功能：提供害虫ID，返回单张图片、多张不分类图片或分类图片</p>
 * <p> 单张图片用于首页每日一图、查询结果页的图片预览、害虫详情页的单张图片 </p>
 * <p> 多张不分类图片暂且不做 </p>
 * <p> 分类图片用于害虫详情图片页的展示 </p>
 * @author 太白
 */
public interface PestImageService {

    /**
     * 通过害虫ID得到 一 张图片的相对路径
     * @param speciesId 害虫ID
     * @return 相对路径
     */
    public ResponseWrapper getPestImageAbsolutePathBySpeciesId(String speciesId);

    /**
     * 通过害虫ID得到 多种分类的多张图片相对路径列表，
     * 害虫图片分类的名称规则同子文件夹名称，例如子文件夹有【生态图片】、【标本图片】、【幼虫】等，那么标题就应当是文件夹名称
     * @param speciesId
     * @return
     */
    public ResponseWrapper getPestClassifiedImageAbsolutePathBySpeciesId(String speciesId);

    /**
     * 通过害虫ID找到轮询六张图片，如果没有六张则找到最多的几张
     * @param speciesId 害虫ID
     * @return 六张图片的Base64码
     */
    public ResponseWrapper getPestIntroImagesBySpeciesId(String speciesId);

}
