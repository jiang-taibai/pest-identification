package com.jsjds.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.jsjds.utils.CodeUtil;
import com.jsjds.utils.ResponseWrapper;
import com.jsjds.utils.SmsTool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建时间：2021/6/28 9:37</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@RestController
@RequestMapping("/textMessage")
public class TextMessageController {

    /**
     * 发送短信
     *
     * @param phone
     * @param request
     * @return
     * @throws ClientException
     */
    @RequestMapping(value = "/send")
    public ResponseWrapper send(String phone) throws ClientException {
        Map<String, Object> map = new HashMap<>();
        // 验证码（指定长度的随机数）
        String code = CodeUtil.generateVerifyCode(6);
        String TemplateParam = "{\"code\":\"" + code + "\"}";
        // 短信模板id
        String TemplateCode = "SMS_218731981";
        SendSmsResponse response = SmsTool.sendSms(phone, TemplateParam, TemplateCode);
        map.put("verifyCode", code);
        map.put("phone", phone);
        if (response.getCode().equals("OK")) {
            map.put("isOk", "OK");
        }
        return ResponseWrapper.markSuccess(map);
    }

}
