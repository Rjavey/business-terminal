package com.rjavey.common.model.po.production;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rjavey.common.model.po.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 产品关系表
 *
 * @author rjavey
 * @TableName bt_erp_product_relation
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bt_erp_product_relation")
@Data
public class ProductRelation extends BaseEntity implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 子级id
     */
    private Long childId;
}