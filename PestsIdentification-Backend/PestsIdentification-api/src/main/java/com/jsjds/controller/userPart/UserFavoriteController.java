package com.jsjds.controller.userPart;

import com.jsjds.service.userPart.UserFavoriteService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>创建时间：2021-07-01 00:05</p>
 * <p>主要功能：获得用户我的收藏列表、添加收藏与取消收藏</p>
 *
 * @author 太白
 */
@RestController
@RequestMapping("/user-favorite")
public class UserFavoriteController {

    @Autowired
    private UserFavoriteService userFavoriteService;

    /**
     * 获得ID用户的所有收藏的列表
     *
     * @param userId 用户ID
     * @return 封装了 List<String> 的返回类
     */
    @RequestMapping("/getFavoriteList")
    public ResponseWrapper getFavoriteList(String userId) {
        return userFavoriteService.getFavoriteList(userId);
    }

    /**
     * 用户点击收藏图标时，将切换收藏状态
     *
     * @param userId 用户ID
     * @param pestId 害虫ID
     * @return 是否切换成功
     */
    @RequestMapping("/switchFavoriteState")
    public ResponseWrapper switchFavoriteState(String userId, String pestId) {
        return userFavoriteService.switchFavoriteState(userId, pestId);
    }

    /**
     * 查询用户是否收藏了该害虫
     * @param userId 用户ID
     * @param pestId 害虫ID
     * @return 若收藏了，则返回true
     */
    @RequestMapping("/isFavorite")
    public ResponseWrapper isFavorite(String userId, String pestId) {
        return userFavoriteService.isFavorite(userId, pestId);
    }

}
