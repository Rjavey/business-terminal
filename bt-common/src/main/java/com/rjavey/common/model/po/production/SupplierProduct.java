package com.rjavey.common.model.po.production;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 供应商产品表
 *
 * @TableName bt_erp_supplier_product
 */
@TableName("bt_erp_supplier_product")
@Data
public class SupplierProduct implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     * 供应商id
     */
    private Long supplierId;

    /**
     * 物料产品id
     */
    private Long productId;

}