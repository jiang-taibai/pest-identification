package com.jsjds.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>创建时间：2021/4/26 16:47</p>
 * <p>主要功能：给予前端显示简要信息，包括害虫的名称、种编号、以及简介，图片的获取应当需要使用另一个接口异步获取</p>
 *
 * @author 太白
 */
@Data
@Accessors(chain = true)
public class PestBriefInfosVO {

    public String pestName;
    public String speciesId;
    public String intro;

}
