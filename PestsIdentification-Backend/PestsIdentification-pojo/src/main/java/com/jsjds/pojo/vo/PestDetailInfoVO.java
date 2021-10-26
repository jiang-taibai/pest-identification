package com.jsjds.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>创建时间：2021/4/28 0:42</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
@Data
@Accessors(chain = true)
public class PestDetailInfoVO {

    public String speciesId;
    public String insectName;
    public String intro;
    public String victims;
    public String distribution;
    public String countermeasure;   // 防治策略

}
