package com.rjavey.production.biz;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rjavey.common.model.command.AddSupplier;
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
import com.rjavey.production.service.ProductService;
import com.rjavey.production.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rjavey
 */
@Service
public class SupplierBizImpl implements SupplierBizService {

    @Autowired
    private SupplierService supplierService;

    @Resource
    private ProductService productService;

    @Override
    public Result<SupplierVo> add(AddSupplier addSupplier) {

        Supplier data = BeanUtil.copyProperties(addSupplier, Supplier.class);
        // todo 注入用户租户相关信息
        data.setTenantId(SnowflakeUtil.getInstance().nextId());
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
    public Result<SupplierVo> edit(AddSupplier addSupplier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'edit'");
    }

    @Override
    public Result<?> remove(Long supplierId) {

        Supplier supplier = supplierService.getOne(new LambdaQueryWrapper<Supplier>()
                .eq(Supplier::getId,supplierId)
                .eq(Supplier::getTenantId,1L));
        if (supplier == null){
            return Result.error("");
        }
        supplierService.removeById(supplierId);
        return null;
    }

    @Override
    public Result<SupplierDetailVo> detail(Long supplierId) {

        // 查询供应商
        Supplier supplier = supplierService.getOne(new LambdaQueryWrapper<Supplier>()
                .eq(Supplier::getId,supplierId)
                .eq(Supplier::getTenantId,1L));
        if (supplier == null){
            return Result.error("");
        }

        SupplierDetailVo detail = BeanUtil.copyProperties(supplier,SupplierDetailVo.class);
        List<Product> products = productService.productDetailBySupplier(supplierId);
        detail.setProducts(BeanUtil.copyToList(products, ProductVo.class));

        return Result.success(detail);
    }
}
