package com.jsjds.service;

import com.jsjds.pojo.vo.PestBriefInfosVO;
import com.jsjds.utils.ResponseWrapper;

import java.util.List;

/**
 * <p>创建时间：2021/4/26 16:44</p>
 * <p>主要功能：通过昆虫ID、昆虫关键字获得相关害虫条目</p>
 *
 * @author 太白
 */
public interface PestBriefInfoService {

    /**
     * 通过昆虫关键字搜索昆虫，害虫简要条目应当为害虫ID、害虫名称以及害虫简介
     */
    public ResponseWrapper searchByKeyword(String keyword);

    /**
     * 随机获得一个简要信息，害虫简要条目应当为害虫ID、害虫名称以及害虫简介
     */
    public ResponseWrapper getRandomPestBriefInfo();

    /**
     * 通过害虫ID，获得害虫的简要信息，简要信息包括 名称、简介，即 com.jsjds.pojo.vo.PestBriefInfosVO 类
     * @param pestId 害虫ID
     * @return com.jsjds.pojo.vo.PestBriefInfosVO类
     */
    ResponseWrapper getBriefInfoByPestId(String pestId);

}
