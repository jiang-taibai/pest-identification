package com.jsjds.service.adminPart.impl;

import com.jsjds.mapper.InsectImagesMapper;
import com.jsjds.pojo.InsectImages;
import com.jsjds.service.FileOperationService;
import com.jsjds.service.JsonService;
import com.jsjds.service.adminPart.PestAlbumAdminService;
import com.jsjds.utils.FileUtil;
import com.jsjds.utils.ImageUtil;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>创建时间：2021-07-01 20:14</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@Service
public class PestAlbumAdminServiceImpl implements PestAlbumAdminService {

    @Autowired
    private InsectImagesMapper insectImagesMapper;

    @Value("${pest-image-path.prefix}")
    public String prefixPath;
    @Value("${pest-image-path.defaultAlbumName}")
    public String defaultAlbumName;

    @Autowired
    private JsonService jsonService;
    @Autowired
    private FileOperationService fileOperationService;

    /**
     * 根据物种ID获得一个分类相册的Map，Map以文件夹为名称，以该文件夹下的文件的相对路径为链表value
     *
     * @param speciesId 物种ID
     * @return Map<String, List < String>> Map以文件夹为名称，以该文件夹下的文件的相对路径为链表value
     */
    @Override
    public ResponseWrapper getAlbumImagesRelativePath(String speciesId) {
        File topDir = getSomePestImageTopDir(speciesId);
        File BaseDir = new File(prefixPath);
        if (!topDir.exists()) {
            return ResponseWrapper.markSuccessButNoData();
        }
        File[] fileList = topDir.listFiles();
        Map<String, List<String>> res = new TreeMap<>();
        res.put(defaultAlbumName, new ArrayList<>());
        for (File file : fileList) {
            if (file.isDirectory()) {
                String typeName = file.getName();       // 该文件夹的名字
                File[] typeImages = file.listFiles();   // 得到该文件夹下所有图片文件
                List<String> list = new ArrayList<>();
                // 约定该文件夹下不会再有文件夹，全部都是图片文件
                for (File typeImage : typeImages) {
                    list.add(FileUtil.getRelativeFileName(BaseDir, typeImage));
                }
                res.put(typeName, list);
            }
        }
        return ResponseWrapper.markSuccess(res);
    }

    /**
     * 根据speciesId和传入的Map<String, List<String>>的Json数据，此Json数据格式与{@link PestAlbumAdminService}类的getAlbumImagesRelativePath方法返回的原理相同
     *
     * @param stateJson 状态Json
     * @param speciesId 物种ID
     * @return 是否修改成功
     */
    @Override
    public ResponseWrapper changeAlbumImage(String stateJson, String speciesId) {
        Map<String, List<String>> map = jsonService.jsonChangeMap(stateJson);
        fileOperationService.updateFolderByStateMap(map, speciesId);
        return ResponseWrapper.markSuccessButNoData();
    }

    private File getSomePestImageTopDir(String speciesId) {
        InsectImages insectImage = insectImagesMapper.selectByPrimaryKey(speciesId);
        String topPath_relative = insectImage.getImgPath();         // 相对路径
        String topPath_absolute = prefixPath + File.separator + topPath_relative;    // 绝对路径
        File topFile = new File(topPath_absolute);
        return topFile;
    }

    /**
     * 管理员上传图片
     *
     * @param speciesId     害虫ID，上传给那个害虫
     * @param imgBase64Data 图片的Base64码
     * @return 是否上传成功以及相对路径
     */
    @Override
    public ResponseWrapper uploadImage(String speciesId, String imgBase64Data) {
        InsectImages insectImages = insectImagesMapper.selectByPrimaryKey(speciesId);
        String fileName = UUID.randomUUID().toString();
        File file = ImageUtil.saveImg(imgBase64Data,
                prefixPath + File.separator + insectImages.getImgPath() + File.separator + defaultAlbumName, fileName);
        if (!file.exists()) {
            return ResponseWrapper.markError("保存图片失败");
        }
        File BaseDir = new File(prefixPath);
        String fileRelativePath = FileUtil.getRelativeFileName(BaseDir, file);
        return ResponseWrapper.markSuccess(fileRelativePath);
    }

}
