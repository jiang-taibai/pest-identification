package com.jsjds.service.userPart.impl;

import com.jsjds.mapper.UserHistoryMapper;
import com.jsjds.pojo.UserHistory;
import com.jsjds.service.userPart.UserHistoryService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>创建时间：2021-07-01 01:28</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@Service
public class UserHistoryServiceImpl implements UserHistoryService {

    @Autowired
    private UserHistoryMapper userHistoryMapper;

    /**
     * 获取当前用户所有浏览记录，注意，重复的昆虫仅显示最近访问的条目
     *
     * @param userId 账号ID
     * @return {@link List <String>} 害虫ID条目
     */
    @Override
    public ResponseWrapper getAllHistoryPestIdList(String userId) {
        List<String> res = new ArrayList<>();
        Set<String> vis = new HashSet<>();
        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(userId);
        List<UserHistory> list = userHistoryMapper.select(userHistory);
        list.sort((o1, o2) -> o2.getBrowseTime().compareTo(o1.getBrowseTime()));
        for (UserHistory history : list) {
            if (!vis.contains(history.getSpeciesId())) {
                vis.add(history.getSpeciesId());
                res.add(history.getSpeciesId());
            }
        }
        return ResponseWrapper.markSuccess(res);
    }

    /**
     * 标记该用户访问了这个昆虫，并删除（若存在）之前访问该昆虫的条目
     *
     * @param userId 用户ID
     * @param pestId 害虫ID
     * @return 是否标记成功
     */
    @Override
    public ResponseWrapper markVisited(String userId, String pestId) {
        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(userId);
        userHistory.setSpeciesId(pestId);
        userHistoryMapper.delete(userHistory);
        userHistory.setBrowseTime(new Date());
        userHistoryMapper.insert(userHistory);
        return ResponseWrapper.markSuccess(true);
    }
}
