package com.jsjds.controller;

import com.jsjds.service.AccountService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>创建时间：2021/6/28 14:46</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 登录功能，返回账户JWT和失效时间
     * @param phone 手机号
     * @param password 密码
     * @return 账户JWT和失效时间
     */
    @RequestMapping("/login")
    public ResponseWrapper login(String phone, String password) {
        return accountService.login(phone, password);
    }

    /**
     * 修改密码
     * @param id 账户ID
     * @param originalPassword 原始密码
     * @param newPassword 新密码
     * @return 是否修改成功，附带数据即消息
     */
    @RequestMapping("/modifyPassword")
    public ResponseWrapper modifyPassword(String id, String originalPassword, String newPassword) {
        return accountService.modifyPassword(id, originalPassword, newPassword);
    }

    @RequestMapping("/registerAnyway")
    public ResponseWrapper registerAnyway(String phone, String password) {
        return accountService.registerAnyway(phone, password);
    }

}
