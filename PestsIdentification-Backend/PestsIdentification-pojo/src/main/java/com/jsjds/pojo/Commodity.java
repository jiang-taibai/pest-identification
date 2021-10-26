package com.jsjds.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class Commodity implements Serializable {
    /**
     * 商品ID
     */
    @Id
    @Column(name = "commodity_id")
    private Integer commodityId;

    /**
     * 商品标题
     */
    @Column(name = "commodity_title")
    private String commodityTitle;

    /**
     * 商品标签
     */
    @Column(name = "commodity_tag")
    private String commodityTag;

    /**
     * 商品价格
     */
    @Column(name = "commodity_price")
    private String commodityPrice;

    /**
     * 商品链接
     */
    @Column(name = "commodity_url")
    private String commodityUrl;

    /**
     * 商品缩略图
     */
    @Column(name = "commodity_img")
    private String commodityImg;

    private static final long serialVersionUID = 1L;

    public Commodity(Integer commodityId, String commodityTitle, String commodityTag, String commodityPrice, String commodityUrl, String commodityImg) {
        this.commodityId = commodityId;
        this.commodityTitle = commodityTitle;
        this.commodityTag = commodityTag;
        this.commodityPrice = commodityPrice;
        this.commodityUrl = commodityUrl;
        this.commodityImg = commodityImg;
    }

    public Commodity() {
        super();
    }

    /**
     * 获取商品ID
     *
     * @return commodity_id - 商品ID
     */
    public Integer getCommodityId() {
        return commodityId;
    }

    /**
     * 设置商品ID
     *
     * @param commodityId 商品ID
     */
    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * 获取商品标题
     *
     * @return commodity_title - 商品标题
     */
    public String getCommodityTitle() {
        return commodityTitle;
    }

    /**
     * 设置商品标题
     *
     * @param commodityTitle 商品标题
     */
    public void setCommodityTitle(String commodityTitle) {
        this.commodityTitle = commodityTitle;
    }

    /**
     * 获取商品标签
     *
     * @return commodity_tag - 商品标签
     */
    public String getCommodityTag() {
        return commodityTag;
    }

    /**
     * 设置商品标签
     *
     * @param commodityTag 商品标签
     */
    public void setCommodityTag(String commodityTag) {
        this.commodityTag = commodityTag;
    }

    /**
     * 获取商品价格
     *
     * @return commodity_price - 商品价格
     */
    public String getCommodityPrice() {
        return commodityPrice;
    }

    /**
     * 设置商品价格
     *
     * @param commodityPrice 商品价格
     */
    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    /**
     * 获取商品链接
     *
     * @return commodity_url - 商品链接
     */
    public String getCommodityUrl() {
        return commodityUrl;
    }

    /**
     * 设置商品链接
     *
     * @param commodityUrl 商品链接
     */
    public void setCommodityUrl(String commodityUrl) {
        this.commodityUrl = commodityUrl;
    }

    /**
     * 获取商品缩略图
     *
     * @return commodity_img - 商品缩略图
     */
    public String getCommodityImg() {
        return commodityImg;
    }

    /**
     * 设置商品缩略图
     *
     * @param commodityImg 商品缩略图
     */
    public void setCommodityImg(String commodityImg) {
        this.commodityImg = commodityImg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commodityId=").append(commodityId);
        sb.append(", commodityTitle=").append(commodityTitle);
        sb.append(", commodityTag=").append(commodityTag);
        sb.append(", commodityPrice=").append(commodityPrice);
        sb.append(", commodityUrl=").append(commodityUrl);
        sb.append(", commodityImg=").append(commodityImg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}