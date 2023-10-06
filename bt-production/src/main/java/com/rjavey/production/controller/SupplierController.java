package com.rjavey.production.controller;

import com.rjavey.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author rjavey
 */
@Api("供应商管理")
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @ApiOperation(value = "分页查询供应商", notes = "分页查询供应商")
    @GetMapping("/")
    public Result<?> get(){
        return Result.ok("todo");
    }

    @ApiOperation(value = "添加供应商", notes = "添加供应商")
    @PostMapping("/")
    public Result<?> add(){
        return Result.ok("todo");
    }

    @ApiOperation(value = "编辑供应商", notes = "编辑供应商")
    @PutMapping("/")
    public Result<?> edit(){
        return Result.ok("todo");
    }

    @ApiOperation(value = "删除供应商", notes = "删除供应商")
    @DeleteMapping("/")
    public Result<?> remove(){
        return Result.ok("todo");
    }
}
