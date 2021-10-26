package com.jsjds.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Accessors(chain = true)
@Data
public class User implements Serializable {
    /**
     * uuid
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 用以登录
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 用户权限，指的是身份，分为普通用户与管理员
     */
    @Column(name = "user_authority")
    private String userAuthority;

    private static final long serialVersionUID = 1L;

    public User(String userId, String userPhone, String userPassword, String userAuthority) {
        this.userId = userId;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userAuthority = userAuthority;
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userAuthority=").append(userAuthority);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}