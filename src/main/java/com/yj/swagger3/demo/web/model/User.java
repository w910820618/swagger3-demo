package com.yj.swagger3.demo.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * User
 *
 * @author Daily Programmer
 * @since 2020-10-24 16:19
 **/
@Data
@Accessors(chain = true)
@ApiModel("The user interface returns the formation")
public class User implements Serializable {

    private static final long serialVersionUID = -6184820859988580981L;

    @ApiModelProperty(value = "Primary key ID")
    private Long id;
    @ApiModelProperty(value = "Username")
    private String userName;
    @ApiModelProperty(value = "Telephone")
    private String phone;
    @ApiModelProperty(value = "Address")
    private String address;
}
