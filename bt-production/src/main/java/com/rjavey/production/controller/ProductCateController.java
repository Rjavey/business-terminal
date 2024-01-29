package com.rjavey.production.controller;

import com.rjavey.common.model.command.production.AddProductCate;
import com.rjavey.common.model.command.production.AddProductCateRel;
import com.rjavey.common.model.command.production.ModifyProductCate;
import com.rjavey.common.result.Result;
import com.rjavey.production.service.ProductCateRelationService;
import com.rjavey.production.service.ProductCateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Rjavey
 * @create: 2024-01-29 22:41:55
 **/
@Api(tags = "产品分类管理")
@RestController
@RequestMapping("/product/cate")
@AllArgsConstructor(onConstructor_ = {@Lazy})
public class ProductCateController {


    private final ProductCateService productCateService;
    private final ProductCateRelationService productCateRelationService;

    @ApiOperation("设置产品分类")
    @PostMapping("/set_product")
    public Result setProductCate(@RequestBody @Validated AddProductCateRel addProductCate) {
        return null;
    }

    @ApiOperation("新增产品分类")
    @PostMapping("/product")
    public Result addProductCate(@RequestBody @Validated AddProductCate addProductCate) {
        return null;
    }

    @ApiOperation("编辑产品分类")
    @PutMapping("/product")
    public Result modifyProductCate(@RequestBody @Validated ModifyProductCate modifyProductCate) {
        return null;
    }

    @ApiOperation("删除产品分类")
    @DeleteMapping("/{cateId}")
    public Result removeProductCate(@PathVariable Long cateId) {
        return null;
    }

    @ApiOperation("查询产品分类")
    @GetMapping("/product")
    public Result queryProductCateList() {
        return null;
    }


}
