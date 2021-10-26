package com.jsjds.mapper;

import com.jsjds.pojo.vo.PestBriefInfosVO;
import com.jsjds.pojo.vo.PestDetailInfoVO;
import com.jsjds.pojo.vo.PestImgIntroInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>创建时间：2021/4/27 1:19</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@Component
public interface PestSelectMapper {

    /**
     * 按关键字查询昆虫
     * @param keyword 关键字
     * @return 昆虫简要信息列表
     */
    public List<PestBriefInfosVO> queryPestsByKeyword(@Param("keyword") String keyword);

    /**
     * 提供害虫ID，返回害虫的所有详细信息
     * @param speciesId 害虫ID
     * @return 害虫的详细信息
     */
    public PestDetailInfoVO queryPestsDetailInfoBySpeciesId(@Param("speciesId") String speciesId);

    /**
     * 通过属ID查找该属ID下的害虫信息
     * @param genusId 属ID
     * @return 害虫信息列表
     */
    public List<PestImgIntroInfoVo> queryPestImgIntroInfoVoByGenusId(@Param("genusId") String genusId);

}
