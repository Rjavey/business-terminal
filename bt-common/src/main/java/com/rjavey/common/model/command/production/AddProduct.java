package com.rjavey.common.model.command.production;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author rjavey
 */
@Data
public class AddProduct {

    private Long id;

    /**
     * 成品半成品名称
     */
    @ApiModelProperty("成品半成品名称")
    private String productName;
    /**
     * 类型 成品finished 半成品half-finished
     */
    @ApiModelProperty(value = "类型", notes = "成品finished 半成品half-finished")
    private String productType;
    /**
     * 单位 只 个 件 箱
     */
    @ApiModelProperty(value = "单位", notes = "只 个 件 箱")
    private String unit;
    /**
     * 物料流转编码
     */
    @ApiModelProperty("物料流转编码")
    private String productCode;
    /**
     * 产品型号
     */
    @ApiModelProperty("产品型号")
    private String productModel;
    /**
     * 产品规格
     */
    @ApiModelProperty("产品规格")
    private String specification;
    /**
     * 产品颜色
     */
    @ApiModelProperty("产品颜色")
    private String color;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
    /**
     * 成品来源
     * outsourcing 外购/外协
     * self 自制
     */
    @ApiModelProperty(value = "成品来源", notes = "outsourcing 外购/外协 self 自制")
    private String productFrom;

    @ApiModelProperty("可提供供应商ID")
    private List<Long> supplierIds;

    @ApiModelProperty("可生产产品id")
    private List<Long> parentIds;

    @ApiModelProperty("需提供产品id")
    private List<Long> childIds;

}
