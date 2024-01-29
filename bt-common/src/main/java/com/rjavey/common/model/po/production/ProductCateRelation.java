package com.rjavey.common.model.po.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 产品分类关系表
 *
 * @TableName bt_erp_product_cate_relation
 */
@TableName(value = "bt_erp_product_cate_relation")
@Data
public class ProductCateRelation implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId
    private Long id;
    /**
     * 分类id
     */
    private Long cateId;
    /**
     * 产品id
     */
    private Long productId;
}