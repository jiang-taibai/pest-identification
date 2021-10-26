package com.jsjds.service.userPart;

import com.jsjds.utils.ResponseWrapper;

/**
 * <p>创建时间：2021-06-30 23:46</p>
 * <p>主要功能：获得用户我的收藏列表、添加收藏与取消收藏</p>
 *
 * @author 太白
 */
public interface UserFavoriteService {

    /**
     * 获得ID用户的所有收藏的列表
     * @param userId 用户ID
     * @return 封装了 List<String> 的返回类
     */
    ResponseWrapper getFavoriteList(String userId);

    /**
     * 用户点击收藏图标时，将切换收藏状态
     * @param userId 用户ID
     * @param pestId 害虫ID
     * @return 是否切换成功
     */
    ResponseWrapper switchFavoriteState(String userId, String pestId);


    /**
     * 查询用户是否收藏了该害虫
     * @param userId 用户ID
     * @param pestId 害虫ID
     * @return 若收藏了，则返回true
     */
    ResponseWrapper isFavorite(String userId, String pestId);

}
