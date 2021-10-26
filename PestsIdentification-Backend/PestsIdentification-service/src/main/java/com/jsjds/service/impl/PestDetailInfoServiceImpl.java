package com.jsjds.service.impl;

import com.jsjds.mapper.PestSelectMapper;
import com.jsjds.pojo.vo.PestDetailInfoVO;
import com.jsjds.service.PestDetailInfoService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>创建时间：2021/4/28 0:49</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@Service
public class PestDetailInfoServiceImpl implements PestDetailInfoService {

    @Autowired
    public PestSelectMapper pestSelectMapper;

    /**
     * 提供害虫ID，返回害虫的所有详细信息
     *
     * @param speciesId 害虫ID
     * @return 对应害虫的所有详细信息
     */
    @Override
    public ResponseWrapper getPestDetailInfo(String speciesId) {
        PestDetailInfoVO data = pestSelectMapper.queryPestsDetailInfoBySpeciesId(speciesId);
        return ResponseWrapper.markSuccess(data);
    }
}
