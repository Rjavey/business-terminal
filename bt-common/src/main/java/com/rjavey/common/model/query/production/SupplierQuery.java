package com.rjavey.common.model.query.production;

import com.rjavey.common.model.query.KeywordQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author rjavey
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SupplierQuery extends KeywordQuery {

    /**
     * 供应商状态
     */
    @ApiModelProperty("供应商状态")
    private String status;
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