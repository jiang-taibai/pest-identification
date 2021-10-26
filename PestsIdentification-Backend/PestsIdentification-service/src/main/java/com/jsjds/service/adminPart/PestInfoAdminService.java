package com.jsjds.service.adminPart;

import com.jsjds.pojo.vo.PestDetailInfoVO;
import com.jsjds.utils.ResponseWrapper;

/**
 * <p>创建时间：2021-07-01 14:50</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public interface PestInfoAdminService {

    /**
     * 根据害虫ID更新害虫信息
     * @param oldSpeciesId 旧的害虫ID
     * @param newInfo 封装
     * @return 是否更新成功
     */
    public ResponseWrapper changePestInfoBySpeciesId(String oldSpeciesId, PestDetailInfoVO newInfo);

    /**
     * 通过害虫钟ID获得PestDetailInfoVO对象，后期应当加上科目属信息
     * @param speciesId 害虫ID
     * @return 封装了 {@link PestDetailInfoVO} 对象
     */
    public ResponseWrapper getPestInfoBySpeciesId(String speciesId);

}
