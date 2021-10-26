package com.jsjds.controller.adminPart;

import com.jsjds.service.FileOperationService;
import com.jsjds.service.adminPart.PestAlbumAdminService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

/**
 * <p>创建时间：2021-07-01 14:41</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@RestController
@RequestMapping("/admin-pestAlbum")
public class PestAlbumAdminController {

    @Autowired
    private PestAlbumAdminService pestAlbumAdminService;

    /**
     * 根据状态数组更新系统内部文件夹与文件位置
     *
     * @param stateMap 存储状态
     * @return 返回是否移动成功
     */
    @RequestMapping(method = RequestMethod.POST, value = "/updateFolderByStateMap", produces = "application/json")
    public ResponseWrapper updateFolderByStateMap(String stateMap, String speciesId) throws UnsupportedEncodingException {
        stateMap = URLDecoder.decode(stateMap, "UTF-8");
        System.out.println(stateMap);
        return pestAlbumAdminService.changeAlbumImage(stateMap, speciesId);
    }

    /**
     * 根据物种ID获得一个分类相册的Map，Map以文件夹为名称，以该文件夹下的文件的相对路径为链表value
     *
     * @param speciesId 物种ID
     * @return Map<String, List < String>> Map以文件夹为名称，以该文件夹下的文件的相对路径为链表value
     */
    @RequestMapping("/getAlbumImagesRelativePath")
    public ResponseWrapper getAlbumImagesRelativePath(String speciesId) {
        return pestAlbumAdminService.getAlbumImagesRelativePath(speciesId);
    }

    /**
     * 管理员上传图片
     *
     * @param map 前端传来的数据，放到Body请求体中
     * @return 是否上传成功以及相对路径
     */
    @PostMapping("/uploadImage")
    public ResponseWrapper uploadImage(@RequestBody Map<String, Object> map) {
        String speciesId = (String) map.get("speciesId");
        String imgBase64Data = (String) map.get("imgBase64Data");
        System.out.println("speciesId = " + speciesId);
        System.out.println("imgBase64Data = " + imgBase64Data);
        try {
            imgBase64Data = URLDecoder.decode(imgBase64Data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return pestAlbumAdminService.uploadImage(speciesId, imgBase64Data);
    }

}
