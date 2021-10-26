package com.jsjds.service.adminPart;

import com.jsjds.utils.ResponseWrapper;
//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

/**
 * <p>创建时间：2021-07-01 20:05</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public interface PestAlbumAdminService {

    /**
     * 根据物种ID获得一个分类相册的Map，Map以文件夹为名称，以该文件夹下的文件的相对路径为链表value
     * @param speciesId 物种ID
     * @return Map<String, List<String>> Map以文件夹为名称，以该文件夹下的文件的相对路径为链表value
     */
    public ResponseWrapper getAlbumImagesRelativePath(String speciesId);

    /**
     * 根据speciesId和传入的Map<String, List<String>>的Json数据，此Json数据格式与{@link PestAlbumAdminService}类的getAlbumImagesRelativePath方法返回的原理相同
     * @param stateJson 状态Json
     * @param speciesId 物种ID
     * @return 是否修改成功
     */
    public ResponseWrapper changeAlbumImage(String stateJson, String speciesId);

    /**
     * 管理员上传图片
     * @param speciesId 害虫ID，上传给那个害虫
     * @param imgBase64Data 图片的Base64码
     * @return 是否上传成功以及相对路径
     */
    public ResponseWrapper uploadImage(String speciesId, String imgBase64Data);

}
