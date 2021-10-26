package com.jsjds.service.impl;

import com.jsjds.mapper.UserMapper;
import com.jsjds.pojo.User;
import com.jsjds.service.AccountService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>创建时间：2021/6/28 14:05</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录功能，返回账户JWT和失效时间
     *
     * @param phone    手机号
     * @param password 密码
     * @return 账户JWT和失效时间
     */
    @Override
    public ResponseWrapper login(String phone, String password) {
        User user = new User().setUserPhone(phone).setUserPassword(password);
        user = userMapper.selectOne(user);
        if (user == null) {
            return ResponseWrapper.markError();
        }
        Map<String, String> res = new HashMap<>();
        res.put("id", user.getUserId());
        res.put("authority", user.getUserAuthority());
        return ResponseWrapper.markSuccess(res);
    }


    /**
     * 修改密码
     *
     * @param id               账户ID
     * @param originalPassword 原始密码
     * @param newPassword      新密码
     * @return 是否修改成功，附带数据即消息
     */
    @Override
    public ResponseWrapper modifyPassword(String id, String originalPassword, String newPassword) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null || !user.getUserPassword().equals(originalPassword)) {
            return ResponseWrapper.markError("原密码不匹配！");
        }
        user.setUserPassword(newPassword);
        userMapper.updateByPrimaryKey(user);
        return ResponseWrapper.markSuccess("修改密码成功！");
    }

    /**
     * 注册功能，供以测试阶段尚未手机验证码功能
     *
     * @param phone    手机号
     * @param password 密码
     * @return 是否注册成功
     */
    @Override
    public ResponseWrapper registerAnyway(String phone, String password) {
        User user = new User().setUserPhone(phone);
        user = userMapper.selectOne(user);
        if(user == null) {
            // 若为空则可以注册
            String uuid = UUID.randomUUID().toString();
            user = new User()
                    .setUserId(uuid)
                    .setUserPhone(phone)
                    .setUserPassword(password)
                    .setUserAuthority("user");
            userMapper.insert(user);
            return ResponseWrapper.markSuccess("注册成功");
        } else {
            return ResponseWrapper.markError("账户已存在！");
        }
    }
}
