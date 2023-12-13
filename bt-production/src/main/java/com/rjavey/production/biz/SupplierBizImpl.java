package com.rjavey.production.biz;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rjavey.common.exception.ServiceException;
import com.rjavey.common.model.command.AddSupplier;
import com.rjavey.common.model.command.UpdateSupplier;
import com.rjavey.common.model.po.production.Product;
import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.common.model.query.production.SupplierQuery;
import com.rjavey.common.model.vo.production.ProductVo;
import com.rjavey.common.model.vo.production.SupplierDetailVo;
import com.rjavey.common.model.vo.production.SupplierVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;
import com.rjavey.common.utils.SnowflakeUtil;
import com.rjavey.common.utils.StringUtil;
import com.rjavey.common.utils.ThreadIdentityUtil;
import com.rjavey.production.service.ProductService;
import com.rjavey.production.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author rjavey
 */
@Service
public class SupplierBizImpl implements SupplierBizService {

    @Resource
    private SupplierService supplierService;

    @Resource
    private ProductService productService;

    @Override
    public Result<SupplierVo> add(AddSupplier addSupplier) {

        Supplier data = BeanUtil.copyProperties(addSupplier, Supplier.class);
        // todo 注入用户租户相关信息
        data.setId(SnowflakeUtil.getInstance().nextId());
        data.setTenantId(ThreadIdentityUtil.get().getTenantId());
        data.setCreateAt(ThreadIdentityUtil.get().getId());
        data.setUpdateAt(ThreadIdentityUtil.get().getId());
        data.setGmtCreate(LocalDateTime.now());
        data.setGmtUpdate(LocalDateTime.now());
        supplierService.save(data);
        SupplierVo vo = BeanUtil.copyProperties(data, SupplierVo.class);
        return Result.success(vo);
    }

    @Override
    public PageResult<SupplierVo> page(SupplierQuery query){

        // todo 获取用户租户id
//        var tenantId = 1L;
        LambdaQueryWrapper<Supplier> queryWrapper = new LambdaQueryWrapper<Supplier>()
                //                .eq(Supplier::getTenantId,1L)
                .eq(StringUtil.isNotBlank(query.getStatus()),Supplier::getStatus,query.getStatus())
                .eq(query.getProvince() != null,Supplier::getProvince,query.getProvince())
                .eq(query.getCity() != null,Supplier::getCity,query.getCity())
                .eq(query.getArea() != null,Supplier::getArea,query.getArea())
                .like(StringUtil.isNotBlank(query.getKeyword()),Supplier::getSupplierName,query.getKeyword());
        supplierService.page(query,queryWrapper);
        return PageResult.ok(query);
    }


    @Override
    public Result<SupplierVo> edit(UpdateSupplier data) {
        Supplier supplier = getTenantSupplier(data.getId());
        if (supplier == null) {
            return Result.error("");
        }

        BeanUtil.copyProperties(data, supplier);
        supplierService.updateById(supplier);
        return Result.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> remove(List<Long> supplierIds) {

        supplierIds.parallelStream().forEachOrdered(supplierId -> {
            Supplier supplier = getTenantSupplier(supplierId);
            if (supplier == null) {
                throw new ServiceException("参数错误");
            }
            supplier.setStatus("delete");
            supplierService.updateById(supplier);
        });

        return Result.ok();
    }

    @Override
    public Result<SupplierDetailVo> detail(Long supplierId) {

        // 查询供应商
        Supplier supplier = getTenantSupplier(supplierId);
        if (supplier == null){
            return Result.error("");
        }

        SupplierDetailVo detail = BeanUtil.copyProperties(supplier,SupplierDetailVo.class);
        List<Product> products = productService.productDetailBySupplier(supplierId);
        detail.setProducts(BeanUtil.copyToList(products, ProductVo.class));

        return Result.success(detail);
    }

    /**
     * 根据id查询租户供应商
     *
     * @param supplierId
     * @return
     */
    private Supplier getTenantSupplier(Long supplierId) {
        return supplierService.getOne(new LambdaQueryWrapper<Supplier>()
                .eq(Supplier::getId, supplierId)
                .eq(Supplier::getTenantId, ThreadIdentityUtil.get().getTenantId()));
    }
}
