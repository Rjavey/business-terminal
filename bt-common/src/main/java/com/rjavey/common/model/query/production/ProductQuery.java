package com.rjavey.common.model.query.production;

import com.rjavey.common.model.query.KeywordQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author rjavey
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductQuery extends KeywordQuery {

    /**
     * 产品规格
     */
    @ApiModelProperty("产品规格")
    private String specification;
    /**
     * 成品来源
     * outsourcing 外购/外协
     * self 自制
     */
    @ApiModelProperty(value = "成品来源", notes = "outsourcing 外购/外协 self 自制")
    private String productFrom;
    /**
     * 类型 成品finished 半成品half-finished
     */
    @ApiModelProperty(value = "类型", notes = "成品finished 半成品half-finished")
    private String productType;

    @ApiModelProperty("供应商id")
    private Long supplierId;

    
}