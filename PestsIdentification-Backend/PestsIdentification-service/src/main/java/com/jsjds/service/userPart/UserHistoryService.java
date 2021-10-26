package com.jsjds.service.userPart;

import com.jsjds.utils.ResponseWrapper;

/**
 * <p>创建时间：2021-07-01 01:19</p>
 * <p>主要功能：实现添加用户的浏览记录</p>
 *
 * @author 太白
 */
public interface UserHistoryService {

    /**
     * 获取当前用户所有浏览记录，注意，重复的昆虫仅显示最近访问的条目
     * @param userId 账号ID
     * @return {@link java.util.List<String>} 害虫ID条目
     */
    public ResponseWrapper getAllHistoryPestIdList(String userId);


    /**
     * 标记该用户访问了这个昆虫，并删除（若存在）之前访问该昆虫的条目
     * @param userId 用户ID
     * @param pestId 害虫ID
     * @return 是否标记成功
     */
    public ResponseWrapper markVisited(String userId, String pestId);
}
