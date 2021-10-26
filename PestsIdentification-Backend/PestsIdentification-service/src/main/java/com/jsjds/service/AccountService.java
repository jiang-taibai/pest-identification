package com.jsjds.service;

import com.jsjds.utils.ResponseWrapper;

/**
 * <p>创建时间：2021/6/28 11:25</p>
 * <p>主要功能：负责掌管登录注册发送验证码等业务，对接登录注册页</p>
 *
 * @author 太白
 */
public interface AccountService {

    /**
     * 登录功能，返回账户JWT和失效时间
     * @param phone 手机号
     * @param password 密码
     * @return 账户JWT和失效时间
     */
    ResponseWrapper login(String phone, String password);


    /**
     * 修改密码
     * @param id 账户ID
     * @param originalPassword 原始密码
     * @param newPassword 新密码
     * @return 是否修改成功，附带数据即消息
     */
    ResponseWrapper modifyPassword(String id, String originalPassword, String newPassword);

    /**
     * 注册功能，供以测试阶段尚未手机验证码功能
     * @param phone 手机号
     * @param password 密码
     * @return 是否注册成功
     */
    ResponseWrapper registerAnyway(String phone, String password);

}
