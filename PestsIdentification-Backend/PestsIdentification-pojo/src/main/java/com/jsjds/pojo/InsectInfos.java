package com.jsjds.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "insect_infos")
public class InsectInfos implements Serializable {
    /**
     * 昆虫ID，目科属种中的“种”
     */
    @Id
    @Column(name = "species_id")
    private String speciesId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "family_id")
    private String familyId;

    @Column(name = "genus_id")
    private String genusId;

    /**
     * 昆虫名称
     */
    @Column(name = "insect_name")
    private String insectName;

    private String victims;

    private String distribution;

    private String intro;

    /**
     * 害虫防治策略
     */
    private String countermeasure;

    private static final long serialVersionUID = 1L;

    public InsectInfos(String speciesId, String orderId, String familyId, String genusId, String insectName, String victims, String distribution, String intro, String countermeasure) {
        this.speciesId = speciesId;
        this.orderId = orderId;
        this.familyId = familyId;
        this.genusId = genusId;
        this.insectName = insectName;
        this.victims = victims;
        this.distribution = distribution;
        this.intro = intro;
        this.countermeasure = countermeasure;
    }

    public InsectInfos() {
        super();
    }

    /**
     * 获取昆虫ID，目科属种中的“种”
     *
     * @return species_id - 昆虫ID，目科属种中的“种”
     */
    public String getSpeciesId() {
        return speciesId;
    }

    /**
     * 设置昆虫ID，目科属种中的“种”
     *
     * @param speciesId 昆虫ID，目科属种中的“种”
     */
    public void setSpeciesId(String speciesId) {
        this.speciesId = speciesId;
    }

    /**
     * @return order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return family_id
     */
    public String getFamilyId() {
        return familyId;
    }

    /**
     * @param familyId
     */
    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    /**
     * @return genus_id
     */
    public String getGenusId() {
        return genusId;
    }

    /**
     * @param genusId
     */
    public void setGenusId(String genusId) {
        this.genusId = genusId;
    }

    /**
     * 获取昆虫名称
     *
     * @return insect_name - 昆虫名称
     */
    public String getInsectName() {
        return insectName;
    }

    /**
     * 设置昆虫名称
     *
     * @param insectName 昆虫名称
     */
    public void setInsectName(String insectName) {
        this.insectName = insectName;
    }

    /**
     * @return victims
     */
    public String getVictims() {
        return victims;
    }

    /**
     * @param victims
     */
    public void setVictims(String victims) {
        this.victims = victims;
    }

    /**
     * @return distribution
     */
    public String getDistribution() {
        return distribution;
    }

    /**
     * @param distribution
     */
    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    /**
     * @return intro
     */
    public String getIntro() {
        return intro;
    }

    /**
     * @param intro
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * 获取害虫防治策略
     *
     * @return countermeasure - 害虫防治策略
     */
    public String getCountermeasure() {
        return countermeasure;
    }

    /**
     * 设置害虫防治策略
     *
     * @param countermeasure 害虫防治策略
     */
    public void setCountermeasure(String countermeasure) {
        this.countermeasure = countermeasure;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", speciesId=").append(speciesId);
        sb.append(", orderId=").append(orderId);
        sb.append(", familyId=").append(familyId);
        sb.append(", genusId=").append(genusId);
        sb.append(", insectName=").append(insectName);
        sb.append(", victims=").append(victims);
        sb.append(", distribution=").append(distribution);
        sb.append(", intro=").append(intro);
        sb.append(", countermeasure=").append(countermeasure);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}