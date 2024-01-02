package com.rjavey.common.model.command.production;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author rjavey
 */
@Data
public class AddSupplier {

    /**
     * 供应商编码
     */
    @ApiModelProperty("供应商编码")
    private String code;

    /**
     * 供应商名称
     */
    @ApiModelProperty("供应商名称")
    @NotBlank(message = "供应商名称不可为空")
    private String supplierName;

    /**
     * 供应商状态
     */
    @ApiModelProperty("供应商状态")
    private String status;

    /**
     * 关联行业
     */
    @ApiModelProperty("关联行业")
    @NotNull(message = "供应商关联行业不可为空")
    private Long tradeId;

    /**
     * 供应商详细地址
     */
    @ApiModelProperty("供应商详细地址")
    private String address;

    /**
     * 联系电话（手机/座机/传真）
     */
    @ApiModelProperty("联系电话（手机/座机/传真）")
    private String contactNumber;

    /**
     * 联系人名称
     */
    @ApiModelProperty("联系人名称")
    private String contactName;

    /**
     * 省
     */
    @ApiModelProperty("省")
    private Long province;

    /**
     * 市
     */
    @ApiModelProperty("市")
    private Long city;

    /**
     * 区/县
     */
    @ApiModelProperty("区/县")
    private Long area;

}
