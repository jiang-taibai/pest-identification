package com.jsjds.pojo;

import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Accessors(chain = true)
@Table(name = "insect_commodity")
public class InsectCommodity implements Serializable {
    @Id
    @Column(name = "species_id")
    private String speciesId;

    @Id
    @Column(name = "commodity_id")
    private Integer commodityId;

    private static final long serialVersionUID = 1L;

    public InsectCommodity(String speciesId, Integer commodityId) {
        this.speciesId = speciesId;
        this.commodityId = commodityId;
    }

    public InsectCommodity() {
        super();
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
     * @return commodity_id
     */
    public Integer getCommodityId() {
        return commodityId;
    }

    /**
     * @param commodityId
     */
    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", speciesId=").append(speciesId);
        sb.append(", commodityId=").append(commodityId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}