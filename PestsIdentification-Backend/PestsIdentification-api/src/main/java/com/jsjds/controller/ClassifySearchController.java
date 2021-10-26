package com.jsjds.controller;

import com.jsjds.service.PestGenusService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>创建时间：2021-07-01 02:09</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@RestController
@RequestMapping("/classify-search")
public class ClassifySearchController {

    @Autowired
    private PestGenusService pestGenusService;

    /**
     * 通过属ID查找该属ID下的所有害虫信息
     * @param genusId 属ID
     * @return {@link List <String>} 害虫ID列表
     */
    @RequestMapping("/getPestIdListByGenusId")
    public ResponseWrapper getPestIdListByGenusId(String genusId) {
        return pestGenusService.getPestIdListByGenusId(genusId);
    }

}
