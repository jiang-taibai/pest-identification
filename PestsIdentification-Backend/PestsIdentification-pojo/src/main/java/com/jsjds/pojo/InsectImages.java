package com.jsjds.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "insect_images")
public class InsectImages implements Serializable {
    /**
     * 昆虫ID
     */
    @Id
    @Column(name = "species_id")
    private String speciesId;

    /**
     * 图片路径，一般均是C:\src\Pests Identification\{insect_id}，该目录下均是该昆虫的图片，该文件夹下依旧有分类，分类标题不一定，需要后端妥善处理
     */
    @Column(name = "img_path")
    private String imgPath;

    private static final long serialVersionUID = 1L;

    public InsectImages(String speciesId, String imgPath) {
        this.speciesId = speciesId;
        this.imgPath = imgPath;
    }

    public InsectImages() {
        super();
    }

    /**
     * 获取昆虫ID
     *
     * @return species_id - 昆虫ID
     */
    public String getSpeciesId() {
        return speciesId;
    }

    /**
     * 设置昆虫ID
     *
     * @param speciesId 昆虫ID
     */
    public void setSpeciesId(String speciesId) {
        this.speciesId = speciesId;
    }

    /**
     * 获取图片路径，一般均是C:\src\Pests Identification\{insect_id}，该目录下均是该昆虫的图片，该文件夹下依旧有分类，分类标题不一定，需要后端妥善处理
     *
     * @return img_path - 图片路径，一般均是C:\src\Pests Identification\{insect_id}，该目录下均是该昆虫的图片，该文件夹下依旧有分类，分类标题不一定，需要后端妥善处理
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 设置图片路径，一般均是C:\src\Pests Identification\{insect_id}，该目录下均是该昆虫的图片，该文件夹下依旧有分类，分类标题不一定，需要后端妥善处理
     *
     * @param imgPath 图片路径，一般均是C:\src\Pests Identification\{insect_id}，该目录下均是该昆虫的图片，该文件夹下依旧有分类，分类标题不一定，需要后端妥善处理
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", speciesId=").append(speciesId);
        sb.append(", imgPath=").append(imgPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}