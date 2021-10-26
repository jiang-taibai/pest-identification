package com.jsjds.controller;

import com.jsjds.pojo.vo.PestBriefInfosVO;
import com.jsjds.service.PestBriefInfoService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>创建时间：2021/4/27 1:32</p>
 * <p>主要功能：害虫简要信息控制器</p>
 *
 * @author 太白
 */
@CrossOrigin
@RestController
@RequestMapping("/pestBriefInfos")
public class PestBriefInfosController {

    @Autowired
    public PestBriefInfoService pestBriefInfoService;

    /**
     * 通过昆虫关键字搜索昆虫，害虫简要条目应当为害虫ID、害虫名称以及害虫简介
     */
    @RequestMapping("/searchByKeyword")
    public ResponseWrapper searchByKeyword(@RequestParam String keyword) {
        return pestBriefInfoService.searchByKeyword(keyword);
    }

    /**
     * 随机获得一个简要信息，害虫简要条目应当为害虫ID、害虫名称以及害虫简介
     * {@link PestBriefInfosVO}
     */
    @RequestMapping("/getRandomPestBriefInfo")
    public ResponseWrapper getRandomPestBriefInfo() {
        return pestBriefInfoService.getRandomPestBriefInfo();
    }

    /**
     * 通过害虫ID，获得害虫的简要信息，简要信息包括 名称、简介，即 com.jsjds.pojo.vo.PestBriefInfosVO 类
     * @param pestId 害虫ID
     * @return com.jsjds.pojo.vo.PestBriefInfosVO类
     */
    @RequestMapping("/getBriefInfoByPestId")
    public ResponseWrapper getBriefInfoByPestId(String pestId) {
        return pestBriefInfoService.getBriefInfoByPestId(pestId);
    }

}
