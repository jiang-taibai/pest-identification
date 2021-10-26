package com.jsjds.service.adminPart.impl;

import com.jsjds.mapper.InsectImagesMapper;
import com.jsjds.mapper.InsectInfosMapper;
import com.jsjds.pojo.InsectImages;
import com.jsjds.pojo.InsectInfos;
import com.jsjds.pojo.vo.PestDetailInfoVO;
import com.jsjds.service.adminPart.PestInfoAdminService;
import com.jsjds.utils.FileUtil;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * <p>创建时间：2021-07-01 14:58</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@Service
public class PestInfoAdminServiceImpl implements PestInfoAdminService {

    @Autowired
    private InsectInfosMapper insectInfosMapper;

    @Autowired
    private InsectImagesMapper insectImagesMapper;

    @Value("${pest-image-path.prefix}")
    public String prefixPath;

    /**
     * 根据害虫ID更新害虫信息
     *
     * @param oldSpeciesId 害虫信息
     * @param newInfo   封装
     * @return 是否更新成功
     */
    @Override
    public ResponseWrapper changePestInfoBySpeciesId(String oldSpeciesId, PestDetailInfoVO newInfo) {
        InsectInfos insectInfos = insectInfosMapper.selectByPrimaryKey(oldSpeciesId);
        insectInfos.setIntro(newInfo.getIntro());
        insectInfos.setInsectName(newInfo.getInsectName());
        insectInfos.setVictims(newInfo.getVictims());
        insectInfos.setCountermeasure(newInfo.getCountermeasure());
        if(!newInfo.getSpeciesId().equals(oldSpeciesId)) {
            // 如果修改了主键，那么还得检测一下主键是否已存在
            if(insectInfosMapper.existsWithPrimaryKey(newInfo.getSpeciesId())) {
                return ResponseWrapper.markError("已存在该昆虫ID，无法修改！");
            }
            InsectImages insectImages = insectImagesMapper.selectByPrimaryKey(oldSpeciesId);
            String albumPath = insectImages.getImgPath();
            File newFile = FileUtil.rename(prefixPath + File.separator + albumPath, newInfo.getSpeciesId());
            if(newFile == null) {
                return ResponseWrapper.markError("服务器错误！修改失败");
            }
            String relativePath = FileUtil.getRelativeFileName(new File(prefixPath), newFile);
            insectImages.setImgPath(relativePath);
            insectImagesMapper.updateByPrimaryKey(insectImages);    // 先修改的图片资源路径
            insectInfosMapper.updateSpeciesId(oldSpeciesId, newInfo.getSpeciesId());    // 再更新全局的ID
        }
        insectInfosMapper.updateByPrimaryKey(insectInfos);  // 最后更新其他信息
        return ResponseWrapper.markSuccess("更新成功");
    }

    /**
     * 通过害虫钟ID获得PestDetailInfoVO对象，后期应当加上科目属信息
     *
     * @param speciesId 害虫ID
     * @return 封装了 {@link PestDetailInfoVO} 对象
     */
    @Override
    public ResponseWrapper getPestInfoBySpeciesId(String speciesId) {
        InsectInfos insectInfos = insectInfosMapper.selectByPrimaryKey(speciesId.toUpperCase());
        if(insectInfos == null) {
            return ResponseWrapper.markError("无匹配内容");
        }
        PestDetailInfoVO vo = new PestDetailInfoVO()
                .setSpeciesId(insectInfos.getSpeciesId())
                .setIntro(insectInfos.getIntro())
                .setInsectName(insectInfos.getInsectName())
                .setVictims(insectInfos.getVictims())
                .setDistribution(insectInfos.getDistribution())
                .setCountermeasure(insectInfos.getCountermeasure());
        return ResponseWrapper.markSuccess(vo);
    }
}
