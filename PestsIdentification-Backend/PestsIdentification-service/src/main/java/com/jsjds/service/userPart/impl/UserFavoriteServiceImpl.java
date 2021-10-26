package com.jsjds.service.userPart.impl;

import com.jsjds.mapper.UserFavoriteMapper;
import com.jsjds.pojo.UserFavorite;
import com.jsjds.service.userPart.UserFavoriteService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>创建时间：2021-06-30 23:52</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@Service
public class UserFavoriteServiceImpl implements UserFavoriteService {

    @Autowired
    private UserFavoriteMapper userFavoriteMapper;

    /**
     * 获得ID用户的所有收藏的列表
     *
     * @param userId 用户ID
     * @return 封装了 List<String> 的返回类
     */
    @Override
    public ResponseWrapper getFavoriteList(String userId) {
        UserFavorite temp = new UserFavorite();
        temp.setUserId(userId);
        List<UserFavorite> list = userFavoriteMapper.select(temp);
        List<String> data = new ArrayList<>();
        list.forEach(e -> data.add(e.getSpeciesId()));
        return ResponseWrapper.markSuccess(data);
    }

    /**
     * 用户点击收藏图标时，将切换收藏状态
     *
     * @param userId 用户ID
     * @param pestId 害虫ID
     * @return 是否切换成功
     */
    @Override
    public ResponseWrapper switchFavoriteState(String userId, String pestId) {
        UserFavorite userFavorite = new UserFavorite();
        userFavorite.setUserId(userId);
        userFavorite.setSpeciesId(pestId);
        UserFavorite temp = userFavoriteMapper.selectOne(userFavorite);
        if(temp == null) {
            // 若没有找到，就说明不存在这个收藏，所以此时收藏即可
            userFavorite.setFavoriteTime(new Date());
            userFavoriteMapper.insert(userFavorite);
            return ResponseWrapper.markSuccess("收藏成功");
        } else {
            userFavoriteMapper.delete(temp);
            return ResponseWrapper.markSuccess("取消收藏成功");
        }
    }

    /**
     * 查询用户是否收藏了该害虫
     *
     * @param userId 用户ID
     * @param pestId 害虫ID
     * @return 若收藏了，则返回true
     */
    @Override
    public ResponseWrapper isFavorite(String userId, String pestId) {
        UserFavorite userFavorite = new UserFavorite();
        userFavorite.setUserId(userId);
        userFavorite.setSpeciesId(pestId);
        UserFavorite temp = userFavoriteMapper.selectOne(userFavorite);
        // 如果不为null则true -> 已收藏
        return ResponseWrapper.markSuccess(temp != null);
    }
}
