package com.rjavey.common.model.vo.production;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 物料产品表
 *
 * @author rjavey
 */
@Data
@ApiModel("供应商信息vo")
public class ProductVo {

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
}