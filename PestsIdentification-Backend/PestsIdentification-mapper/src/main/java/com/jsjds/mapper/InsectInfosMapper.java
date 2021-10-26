package com.jsjds.mapper;


import com.jsjds.my.mapper.MyMapper;
import com.jsjds.pojo.InsectInfos;
import org.springframework.stereotype.Component;

@Component
public interface InsectInfosMapper extends MyMapper<InsectInfos> {

    /**
     * 更新害虫ID
     * @param oldSpeciesId 旧ID
     * @param newSpeciesId 新ID
     */
    public void updateSpeciesId(String oldSpeciesId, String newSpeciesId);

}