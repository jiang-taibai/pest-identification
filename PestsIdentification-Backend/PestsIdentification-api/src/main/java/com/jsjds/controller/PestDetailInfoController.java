package com.jsjds.controller;

import com.jsjds.pojo.vo.PestDetailInfoVO;
import com.jsjds.service.PestDetailInfoService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>创建时间：2021/4/28 16:30</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@CrossOrigin
@RestController
@RequestMapping("/pestDetailInfo")
public class PestDetailInfoController {

    @Autowired
    public PestDetailInfoService pestDetailInfoService;

    /**
     * 提供害虫ID，返回害虫的所有详细信息
     *
     * @param speciesId 害虫ID
     * @return 害虫的所有详细信息
     */
    @RequestMapping("/searchBySpeciesId")
        public ResponseWrapper getPestsDetailInfoBySpeciesId(@RequestParam("speciesId") String speciesId) {
        return pestDetailInfoService.getPestDetailInfo(speciesId);
    }

}
