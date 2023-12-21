package com.yj.swagger3.demo.web.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsAutoIncrement;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @TableName user
 */
@TableName(value = "user")
@Data
@Entity
@Accessors(chain = true)
@ApiModel("The user interface returns the formation")
public class User implements Serializable {

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnType(MySqlTypeConstant.INT)
    @IsAutoIncrement
    @ApiModelProperty(value = "Primary key ID")
    private Integer id;

    /**
     * username
     */
    @Column(name = "username", type = MySqlTypeConstant.VARCHAR, length = 255)
    @ApiModelProperty(value = "username")
    private String username;

    /**
     * telephone
     */
    @Column(name = "telephone", type = MySqlTypeConstant.VARCHAR, length = 255)
    @ApiModelProperty(value = "telephone")
    private String telephone;

    /**
     * address
     */
    @Column(name = "address", type = MySqlTypeConstant.VARCHAR, length = 255)
    @ApiModelProperty(value = "address")
    private String address;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * username
     */
    public String getUsername() {
        return username;
    }

    /**
     * username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * address
     */
    public String getAddress() {
        return address;
    }

    /**
     * address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername())) && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone())) && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", telephone=").append(telephone);
        sb.append(", address=").append(address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}