package com.jsjds.controller.userPart;

import com.jsjds.service.userPart.UserHistoryService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>创建时间：2021-07-01 01:34</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@RestController
@RequestMapping("/user-history")
public class UserHistoryController {

    @Autowired
    private UserHistoryService userHistoryService;

    /**
     * 获取当前用户所有浏览记录，注意，重复的昆虫仅显示最近访问的条目
     *
     * @param userId 账号ID
     * @return {@link java.util.List<String>} 害虫ID条目
     */
    @RequestMapping("/getAllHistoryPestIdList")
    public ResponseWrapper getAllHistoryPestIdList(String userId) {
        return userHistoryService.getAllHistoryPestIdList(userId);
    }


    /**
     * 标记该用户访问了这个昆虫，并删除（若存在）之前访问该昆虫的条目
     *
     * @param userId 用户ID
     * @param pestId 害虫ID
     * @return 是否标记成功
     */
    @RequestMapping("/markVisited")
    public ResponseWrapper markVisited(String userId, String pestId) {
        return userHistoryService.markVisited(userId, pestId);
    }

}
