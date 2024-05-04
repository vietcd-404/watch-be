package com.fpt.watch.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fpt.watch.dto.Response;
import com.fpt.watch.dto.ResponseDTO;
import com.fpt.watch.entity.Product;
import com.fpt.watch.mapper.ProductMapper;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author watch
 * @since 5/3/2024
 */
@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> {

    @Resource
    private ProductMapper productMapper;

    public ResponseDTO findAll() {
        List<Product> list = list();
        return Response.success(list);
    }

    public ResponseDTO add(Product product) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper();
        queryWrapper.eq("lower(name)", product.getName().toLowerCase());
        Long nameCount = count(queryWrapper);
        if(nameCount<=0) {
            if (save(product)) {
                return Response.success();
            }
        }
        else{
            return Response.error("Thêm mới không thành công! Tên sản phẩm đã tồn tại");
        }
        return Response.error();
    }

    public ResponseDTO deleteById(Integer id) {
        if (removeById(id)) {
            return Response.success();
        }
        return Response.error();
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO deleteBatch(List<Integer> ids) {
        if (removeBatchByIds(ids)) {
            return Response.success();
        }
        return Response.error();
    }


    public ResponseDTO edit(Product product) {
        QueryWrapper<Product> nameWrapperExisted = new QueryWrapper();
        nameWrapperExisted.eq("lower(name)", product.getName().toLowerCase());
        nameWrapperExisted.ne("id", product.getId());
        Long nameCount = count(nameWrapperExisted);
        if(nameCount<=0) {
            if (updateById(product)) {
                return Response.success();
            }
        }
        else{
            return Response.error("Chỉnh sửa không thành công! Tên cơ quan bảo hiểm đã tồn tại");
        }
        return Response.error();
    }


    public ResponseDTO findById(Integer id) {
        Product product = getById(id);
        if (product != null) {
            return Response.success(product);
        }
        return Response.error();
    }

    public ResponseDTO list(Integer current, Integer size, String name) {
        IPage<Product> config = new Page<>(current, size);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        if (name != "" && name != null) {
            wrapper = new QueryWrapper<>();
//            wrapper.like("lower(unaccent(name))", CommonUtil.removeUnicode(name.toLowerCase()));
            wrapper.like("lower(name)", name.toLowerCase());
        }
        wrapper.orderByDesc("create_time");
        IPage<Product> page = page(config, wrapper);
        Map map = new HashMap();
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("list", page.getRecords());
        return Response.success(map);
    }



}
