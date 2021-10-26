package com.jsjds.service.impl;

import com.jsjds.mapper.InsectInfosMapper;
import com.jsjds.mapper.PestSelectMapper;
import com.jsjds.pojo.InsectInfos;
import com.jsjds.pojo.vo.PestBriefInfosVO;
import com.jsjds.service.PestBriefInfoService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>创建时间：2021/4/27 0:58</p>
 * <p>主要功能：通过昆虫ID、昆虫关键字获得相关害虫条目</p>
 *
 * @author 太白
 */
@Service
public class PestBriefInfoServiceImpl implements PestBriefInfoService {

    @Autowired
    public PestSelectMapper pestSelectMapper;

    @Autowired
    public InsectInfosMapper insectInfosMapper;

    /**
     * 通过昆虫关键字搜索昆虫，害虫简要条目应当为害虫ID、害虫名称以及害虫简介
     *
     * @param keyword
     */
    @Override
    public ResponseWrapper searchByKeyword(String keyword) {
        List<PestBriefInfosVO> data = pestSelectMapper.queryPestsByKeyword(keyword);
        return ResponseWrapper.markSuccess(data);
    }

    /**
     * 随机获得一个简要信息，害虫简要条目应当为害虫ID、害虫名称以及害虫简介
     * PestBriefInfosVO
     */
    @Override
    public ResponseWrapper getRandomPestBriefInfo() {
        List<InsectInfos> insectInfos = insectInfosMapper.selectAll();
        InsectInfos insectInfo = insectInfos.get((int) (Math.random() * insectInfos.size()));
        PestBriefInfosVO res = new PestBriefInfosVO();
        res.setSpeciesId(insectInfo.getSpeciesId());
        res.setPestName(insectInfo.getInsectName());
        res.setIntro(insectInfo.getIntro());
        return ResponseWrapper.markSuccess(res);
    }

    /**
     * 通过害虫ID，获得害虫的简要信息，简要信息包括 名称、简介，即 com.jsjds.pojo.vo.PestBriefInfosVO 类
     *
     * @param pestId 害虫ID
     * @return com.jsjds.pojo.vo.PestBriefInfosVO类
     */
    @Override
    public ResponseWrapper getBriefInfoByPestId(String pestId) {
        InsectInfos insectInfos = insectInfosMapper.selectByPrimaryKey(pestId);
        PestBriefInfosVO pestBriefInfosVO =
                new PestBriefInfosVO()
                        .setIntro(insectInfos.getIntro())
                        .setPestName(insectInfos.getInsectName())
                        .setSpeciesId(pestId);
        return ResponseWrapper.markSuccess(pestBriefInfosVO);
    }
}
