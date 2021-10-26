package com.jsjds.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsjds.service.JsonService;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Service;

/**
 * @author Yang Jiabin
 * @time 2021/6/28 0:31
 * @desc
 */
@Service
public class JsonServiceImpl implements JsonService {

    @Override
    public Map<String, List<String>> jsonChangeMap(String jsonStr) {
        //解决无法解析/的问题
        jsonStr = jsonStr.replace("\\","\\\\");
        Map mapObj = JSONObject.parseObject(jsonStr,Map.class);
        Map<String,List<String>> maps = new HashMap<>();
        for (Object item : mapObj.entrySet()){
            String key = (String)((Map.Entry)item).getKey();
            JSONArray jsonArray = (JSONArray)((Map.Entry)item).getValue();
            List<String> list = JSONObject.parseArray(jsonArray.toJSONString(), String.class);
            for (String str:list){
                //换回来
                str = str.replace("\\\\","\\");
                System.out.println(str);
            }
            maps.put(key,list);
        }
        return maps;
    }

    @Override
    public String readJsonToString(String jsonPath) {
        String encoding = "UTF-8";
        File file = new File(jsonPath);
        Long fileLength = file.length();
        byte[] fileContent = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(fileContent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }
}
