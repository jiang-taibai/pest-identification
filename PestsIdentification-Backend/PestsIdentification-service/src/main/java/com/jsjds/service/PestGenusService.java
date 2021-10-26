package com.jsjds.service;

import com.jsjds.pojo.vo.PestImgIntroInfoVo;
import com.jsjds.utils.ResponseWrapper;

import java.util.List;

/**
 * @author Yang Jiabin
 * @time 2021/6/27 10:37
 * @desc 通过属ID查询信息
 */
public interface PestGenusService {

    /**
     * 通过属ID查找该属ID下的所有害虫信息
     * @param genusId 属ID
     * @return {@link List<String>} 害虫ID列表
     */
    public ResponseWrapper getPestIdListByGenusId(String genusId);

}
