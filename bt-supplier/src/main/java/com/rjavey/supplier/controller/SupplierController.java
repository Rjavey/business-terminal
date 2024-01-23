package com.rjavey.supplier.controller;

import com.rjavey.common.model.command.production.AddSupplier;
import com.rjavey.common.model.command.production.DeleteIds;
import com.rjavey.common.model.command.production.UpdateSupplier;
import com.rjavey.common.model.query.production.SupplierQuery;
import com.rjavey.common.model.vo.production.SupplierDetailVo;
import com.rjavey.common.model.vo.production.SupplierVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;
import com.rjavey.supplier.biz.SupplierBizService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * @author rjavey
 */
@Api(tags = "供应商管理")
@RestController
@RequestMapping("/supplier")
@AllArgsConstructor
public class SupplierController {

    private final SupplierBizService bizService;

    @ApiOperation(value = "分页查询供应商", notes = "分页查询供应商")
    @PostMapping("/page")
    public PageResult<SupplierVo> get(@RequestBody SupplierQuery query){
        return bizService.page(query);
    }

    @ApiOperation(value = "添加供应商", notes = "添加供应商")
    @PostMapping("/")
    public Result<SupplierVo> add(@RequestBody @Valid AddSupplier addSupplier) {
        return bizService.add(addSupplier);
    }

    @ApiOperation(value = "编辑供应商", notes = "编辑供应商")
    @PutMapping("/")
    public Result<SupplierVo> edit(@RequestBody @Valid UpdateSupplier addSupplier) {
        return bizService.edit(addSupplier);
    }

    @ApiOperation(value = "删除供应商", notes = "删除供应商")
    @DeleteMapping("/{id}")
    public Result<?> remove(@RequestBody @Valid DeleteIds ids) {
        return bizService.remove(ids.getIds());
    }

    @ApiOperation(value = "查询供应商详情", notes = "查询供应商详情，包括供应商提供物料信息")
    @GetMapping("/{id}")
    public Result<SupplierDetailVo> detail(@PathVariable Long id) {
        return bizService.detail(id);
    }


}
