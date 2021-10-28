package com.swagger.enhance.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "工单实体", description = "orderId 不可以为空")
public class OrderInfo implements Serializable {


    @ApiModelProperty(value = "工单ID")
    private String orderId;

    @ApiModelProperty(value = "工单编号" )
    private String orderNo;

    @ApiModelProperty("备注")
    private String remark;
}
