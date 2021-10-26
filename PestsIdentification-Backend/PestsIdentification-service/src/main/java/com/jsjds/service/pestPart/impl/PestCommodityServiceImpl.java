package com.jsjds.service.pestPart.impl;

import com.jsjds.mapper.CommodityMapper;
import com.jsjds.mapper.InsectCommodityMapper;
import com.jsjds.pojo.Commodity;
import com.jsjds.pojo.InsectCommodity;
import com.jsjds.service.pestPart.PestCommodityService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Creation Time: 2021-08-03 16:30:35</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
@Service
public class PestCommodityServiceImpl implements PestCommodityService {

    @Autowired
    private InsectCommodityMapper insectCommodityMapper;
    @Autowired
    private CommodityMapper commodityMapper;


    /**
     * 通过害虫种ID获得相对应的商品列表，返回一个包含仅所有商品ID的列表
     *
     * @param speciesId 害虫种ID
     * @return 返回一个包含仅所有商品ID的列表
     */
    @Override
    public ResponseWrapper getCommodityListBySpeciesId(String speciesId) {
        InsectCommodity record = new InsectCommodity();
        record.setSpeciesId(speciesId);
        List<InsectCommodity> insectCommodityList = insectCommodityMapper.select(record);
        List<Integer> allCommodityId = new ArrayList<>();
        insectCommodityList.forEach(e -> allCommodityId.add(e.getCommodityId()));
        return ResponseWrapper.markSuccess(allCommodityId);
    }

    /**
     * 通过商品ID获得该商品的信息，图片以相对路径的方式返回
     *
     * @param commodityId 商品ID
     * @return 商品详细信息
     */
    @Override
    public ResponseWrapper getCommodityDetailById(Integer commodityId) {
        Commodity commodity = commodityMapper.selectByPrimaryKey(commodityId);
        if (commodity == null) {
            return ResponseWrapper.markError("无此商品信息");
        }
        return ResponseWrapper.markSuccess(commodity);
    }
}
