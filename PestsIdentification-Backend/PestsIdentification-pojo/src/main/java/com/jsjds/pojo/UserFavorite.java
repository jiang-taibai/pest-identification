package com.jsjds.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "user_favorite")
public class UserFavorite implements Serializable {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Id
    @Column(name = "species_id")
    private String speciesId;

    /**
     * 添加收藏的时间
     */
    @Column(name = "favorite_time")
    private Date favoriteTime;

    private static final long serialVersionUID = 1L;

    public UserFavorite(String userId, String speciesId, Date favoriteTime) {
        this.userId = userId;
        this.speciesId = speciesId;
        this.favoriteTime = favoriteTime;
    }

    public UserFavorite() {
        super();
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return species_id
     */
    public String getSpeciesId() {
        return speciesId;
    }

    /**
     * @param speciesId
     */
    public void setSpeciesId(String speciesId) {
        this.speciesId = speciesId;
    }

    /**
     * 获取添加收藏的时间
     *
     * @return favorite_time - 添加收藏的时间
     */
    public Date getFavoriteTime() {
        return favoriteTime;
    }

    /**
     * 设置添加收藏的时间
     *
     * @param favoriteTime 添加收藏的时间
     */
    public void setFavoriteTime(Date favoriteTime) {
        this.favoriteTime = favoriteTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", speciesId=").append(speciesId);
        sb.append(", favoriteTime=").append(favoriteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}