package com.rjavey.production.controller;

import com.rjavey.common.model.command.AddSupplier;
import com.rjavey.common.model.vo.producton.SupplierVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;
import com.rjavey.production.biz.SupplierBizService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author rjavey
 */
@Api(tags = "供应商管理")
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Resource
    private SupplierBizService bizService;

    @ApiOperation(value = "分页查询供应商", notes = "分页查询供应商")
    @GetMapping("/")
    public PageResult<SupplierVo> get(){
        return PageResult.ok(null, null);
    }

    @ApiOperation(value = "添加供应商", notes = "添加供应商")
    @PostMapping("/")
    public Result<SupplierVo> add(@RequestBody @Valid AddSupplier addSupplier) {
        return bizService.add(addSupplier);
    }

    @ApiOperation(value = "编辑供应商", notes = "编辑供应商")
    @PutMapping("/")
    public Result<SupplierVo> edit(){
        return Result.ok(null);
    }

    @ApiOperation(value = "删除供应商", notes = "删除供应商")
    @DeleteMapping("/")
    public Result<?> remove(){
        return Result.ok("todo");
    }
}
