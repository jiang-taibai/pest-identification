package com.jsjds.service;

import java.util.List;
import java.util.Map;

/**
 * @author Yang Jiabin
 * @time 2021/6/28 0:19
 * @desc
 */
public interface JsonService {

    /**
     * json转Map
     * @param jsonStr json数据
     * @return 解析出的Map对象
     */
    public Map<String, List<String>> jsonChangeMap(String jsonStr);

    /**
     * 读取json文件
     * @param jsonPath JSON文件目录
     * @return 文件内容
     */
    public String readJsonToString(String jsonPath);
}
