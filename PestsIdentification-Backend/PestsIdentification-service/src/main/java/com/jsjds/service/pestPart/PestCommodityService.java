package com.jsjds.service.pestPart;

import com.jsjds.utils.ResponseWrapper;

/**
 * <p>Creation Time: 2021-08-03 16:24:32</p>
 * <p>Description: 与害虫商品信息有关的业务</p>
 *
 * @author 太白
 */
public interface PestCommodityService {

    /**
     * 通过害虫种ID获得相对应的商品列表，返回一个包含仅所有商品ID的列表
     * @param speciesId 害虫种ID
     * @return 返回一个包含仅所有商品ID的列表
     */
    public ResponseWrapper getCommodityListBySpeciesId(String speciesId);

    /**
     * 通过商品ID获得该商品的信息，图片以相对路径的方式返回
     * @param commodityId 商品ID
     * @return 商品详细信息
     */
    public ResponseWrapper getCommodityDetailById(Integer commodityId);

}
