package com.jsjds.controller.pestPart;

import com.jsjds.service.pestPart.PestCommodityService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Creation Time: 2021-08-03 16:50:14</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
@RestController
@RequestMapping("/commodity")
public class PestCommodityController {

    @Autowired
    private PestCommodityService pestCommodityService;

    /**
     * 通过害虫种ID获得相对应的商品列表，返回一个包含仅所有商品ID的列表
     *
     * @param speciesId 害虫种ID
     * @return 返回一个包含仅所有商品ID的列表
     */
    @GetMapping("/getCommodityListBySpeciesId")
    public ResponseWrapper getCommodityListBySpeciesId(String speciesId) {
        return pestCommodityService.getCommodityListBySpeciesId(speciesId);
    }

    /**
     * 通过商品ID获得该商品的信息，图片以相对路径的方式返回
     *
     * @param commodityId 商品ID
     * @return 商品详细信息
     */
    @GetMapping("/getCommodityDetailById")
    public ResponseWrapper getCommodityDetailById(Integer commodityId) {
        return pestCommodityService.getCommodityDetailById(commodityId);
    }

}
