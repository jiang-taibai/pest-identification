package com.jsjds.controller.adminPart;

import com.jsjds.pojo.vo.PestDetailInfoVO;
import com.jsjds.service.adminPart.PestInfoAdminService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>创建时间：2021-07-01 14:49</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@RestController
@RequestMapping("/admin-pestInfo")
public class PestInfoAdminController {

    @Autowired
    private PestInfoAdminService pestInfoAdminService;

    /**
     * 根据害虫ID更新害虫信息
     * @param oldSpeciesId 害虫信息
     * @param newInfo 封装
     * @return 是否更新成功
     */
    @RequestMapping("/changePestInfoBySpeciesId")
    public ResponseWrapper changePestInfoBySpeciesId(String oldSpeciesId, PestDetailInfoVO newInfo) {
        return pestInfoAdminService.changePestInfoBySpeciesId(oldSpeciesId, newInfo);
    }


    /**
     * 通过害虫钟ID获得PestDetailInfoVO对象，后期应当加上科目属信息
     * @param speciesId 害虫ID
     * @return 封装了 {@link PestDetailInfoVO} 对象
     */
    @RequestMapping("/getPestInfoBySpeciesId")
    public ResponseWrapper getPestInfoBySpeciesId(String speciesId) {
        return pestInfoAdminService.getPestInfoBySpeciesId(speciesId);
    }

}
