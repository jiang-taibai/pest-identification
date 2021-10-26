package com.jsjds.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "user_history")
public class UserHistory implements Serializable {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Id
    @Column(name = "species_id")
    private String speciesId;

    /**
     * 浏览的时间
     */
    @Column(name = "browse_time")
    private Date browseTime;

    private static final long serialVersionUID = 1L;

    public UserHistory(String userId, String speciesId, Date browseTime) {
        this.userId = userId;
        this.speciesId = speciesId;
        this.browseTime = browseTime;
    }

    public UserHistory() {
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
     * 获取浏览的时间
     *
     * @return browse_time - 浏览的时间
     */
    public Date getBrowseTime() {
        return browseTime;
    }

    /**
     * 设置浏览的时间
     *
     * @param browseTime 浏览的时间
     */
    public void setBrowseTime(Date browseTime) {
        this.browseTime = browseTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", speciesId=").append(speciesId);
        sb.append(", browseTime=").append(browseTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}