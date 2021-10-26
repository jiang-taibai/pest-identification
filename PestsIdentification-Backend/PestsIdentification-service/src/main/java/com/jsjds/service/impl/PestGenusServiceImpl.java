package com.jsjds.service.impl;

import com.jsjds.mapper.InsectInfosMapper;
import com.jsjds.mapper.PestSelectMapper;
import com.jsjds.pojo.InsectInfos;
import com.jsjds.pojo.vo.PestImgIntroInfoVo;
import com.jsjds.service.PestGenusService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang Jiabin
 * @time 2021/6/7 16:28
 * @desc
 */
@Service
public class PestGenusServiceImpl implements PestGenusService {

    //    @Autowired
//    public PestSelectMapper pestSelectMapper;
    @Autowired
    private InsectInfosMapper insectInfosMapper;

    @Override
    public ResponseWrapper getPestIdListByGenusId(String genusId) {
        InsectInfos insectInfos = new InsectInfos();
        insectInfos.setGenusId(genusId);
        List<InsectInfos> list = insectInfosMapper.select(insectInfos);
        List<String> res = new ArrayList<>();
        list.forEach(e -> res.add(e.getSpeciesId()));
        return ResponseWrapper.markSuccess(res);
    }


}
