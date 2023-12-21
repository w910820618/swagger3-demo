package com.yj.swagger3.demo.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Daily Programmer
 * @since 2020-10-24 16:32
 **/
@Data
@ApiModel(value = "Parameters are added to the user information interface")
public class UserVO {

    @ApiModelProperty(value = "Primary key ID")
    private Long id;
    @ApiModelProperty(value = "Username")
    private String userName;
    @ApiModelProperty(value = "Telephone")
    private String phone;
    @ApiModelProperty(value = "Address")
    private String address;
}
