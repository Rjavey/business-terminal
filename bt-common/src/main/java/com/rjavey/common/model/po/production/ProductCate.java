package com.rjavey.common.model.po.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rjavey.common.model.po.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 产品分类表
 *
 * @TableName bt_erp_product_cate
 */
@TableName(value = "bt_erp_product_cate")
@Data
public class ProductCate extends BaseEntity implements Serializable {


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 分类名称
     */
    private String cateName;
    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 父子链
     */
    private String parentLink;
    /**
     * 租户id
     */
    private Long tenantId;
    private Long createAt;
    private Long updateAt;
}