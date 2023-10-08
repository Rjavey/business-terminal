package com.rjavey.production.controller;

import com.rjavey.common.model.command.AddProduct;
import com.rjavey.common.model.command.UpdateProduct;
import com.rjavey.common.model.query.production.ProductQuery;
import com.rjavey.common.model.vo.production.ProductVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;
import com.rjavey.production.biz.ProductBizService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author rjavey
 */
@Api(tags = "物料产品管理")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductBizService bizService;

    @ApiOperation(value = "分页查询物料", notes = "分页查询物料")
    @PostMapping("/page")
    public PageResult<ProductVo> get(@RequestBody ProductQuery query){
        return bizService.page(query);
    }

    @ApiOperation(value = "添加物料", notes = "添加物料")
    @PostMapping("/")
    public Result<ProductVo> add(@RequestBody @Valid AddProduct data) {
        return bizService.add(data);
    }

    @ApiOperation(value = "编辑物料", notes = "编辑物料")
    @PutMapping("/")
    public Result<ProductVo> edit(@RequestBody @Valid UpdateProduct data) {
        return bizService.edit(data);
    }

    @ApiOperation(value = "删除物料", notes = "删除物料")
    @DeleteMapping("/{id}")
    public Result<?> remove(@PathVariable Long id){
        return bizService.remove(id);
    }

    @ApiOperation(value = "查询物料详情", notes = "查询物料详情，包括物料上下级关系及可提供供应商")
    @GetMapping("/{id}")
    public Result<ProductVo> detail(){
        return Result.error("todo");
    }


}
