package com.rjavey.common.model.po.production;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rjavey.common.model.po.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 供应商表
 *
 * @author rjavey
 * @TableName bt_erp_supplier
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("供应商实体")
@TableName("bt_erp_supplier")
public class Supplier extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 1L;
    /**
     * 供应商编码
     */
    @ApiModelProperty("供应商编码")
    private String code;
    /**
     * 供应商所属租户
     */
    @ApiModelProperty("供应商所属租户")
    private Long tenantId;
    /**
     * 供应商名称
     */
    @ApiModelProperty("供应商名称")
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
    /**
     * 创建人id
     */
    @ApiModelProperty("创建人id")
    private Long createAt;
    /**
     * 更新人id
     */
    @ApiModelProperty("更新人id")
    private Long updateAt;
}