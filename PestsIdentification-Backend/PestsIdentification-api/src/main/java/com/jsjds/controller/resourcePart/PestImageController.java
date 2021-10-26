package com.jsjds.controller.resourcePart;

import com.jsjds.service.ImgToCodeService;
import com.jsjds.service.PestImageService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Map;

/**
 * <p>创建时间：2021/4/26 19:11</p>
 * <p>主要功能：害虫图片控制器</p>
 *
 * @author 太白
 */
@CrossOrigin
@RestController
@RequestMapping("/resource/img")
public class PestImageController {

    @Autowired
    PestImageService pestImageService;

    @Autowired
    private ImgToCodeService imgToCodeService;

    /**
     * 通过害虫ID得到 一 张图片的JSON数据
     *
     * @param speciesId 害虫ID
     * @return JSON数据
     */
    @RequestMapping("/preview")
    public ResponseWrapper getPestImageAbsolutePathBySpeciesId(@RequestParam String speciesId) {
        return pestImageService.getPestImageAbsolutePathBySpeciesId(speciesId);
    }


    /**
     * 通过害虫ID得到 多种分类的多张图片相对路径列表，
     * 害虫图片分类的名称规则同子文件夹名称，例如子文件夹有【生态图片】、【标本图片】、【幼虫】等，那么标题就应当是文件夹名称
     *
     * @param speciesId 害虫ID
     * @return 【生态图片】、【标本图片】、【幼虫】等，那么标题就应当是文件夹名称
     */
    @RequestMapping("/classified")
    public ResponseWrapper getPestClassifiedImageAbsolutePathBySpeciesId(@RequestParam String speciesId) {
        return pestImageService.getPestClassifiedImageAbsolutePathBySpeciesId(speciesId);
    }

    @RequestMapping("/album-preview")
    public ResponseWrapper getPestIntroImagesBySpeciesId(String speciesId) {
        return pestImageService.getPestIntroImagesBySpeciesId(speciesId);
    }

    @RequestMapping("/getFileBase64ByRelativePath")
    public ResponseWrapper getFileBase64ByRelativePath(String imgRelativePath) {
        return imgToCodeService.getFileBase64ByRelativePath(imgRelativePath);
    }



}
