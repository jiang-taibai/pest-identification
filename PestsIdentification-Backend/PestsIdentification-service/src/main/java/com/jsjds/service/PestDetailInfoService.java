package com.jsjds.service;

import com.jsjds.pojo.vo.PestDetailInfoVO;
import com.jsjds.utils.ResponseWrapper;

/**
 * <p>创建时间：2021/4/28 0:36</p>
 * <p>主要功能：提供害虫ID，返回害虫的所有详细信息</p>
 *
 * @author 太白
 */
public interface PestDetailInfoService {

    /**
     * 提供害虫ID，返回害虫的所有详细信息
     * @param speciesId 害虫ID
     * @return 所有相信信息
     */
    public ResponseWrapper getPestDetailInfo(String speciesId);

}
