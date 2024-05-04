package com.fpt.watch.controller;

import com.fpt.watch.dto.ResponseDTO;
import com.fpt.watch.entity.Product;
import com.fpt.watch.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author watch
 * @since 5/4/2024
 */

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("/all")
    public ResponseDTO findAll(){
        return this.productService.findAll();
    }

    @PostMapping
    public ResponseDTO add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO delete(@PathVariable Integer id) {
        return this.productService.deleteById(id);
    }

    @DeleteMapping("/batch/{ids}")
    public ResponseDTO deleteBatch(@PathVariable List<Integer> ids) {
        return this.productService.deleteBatch(ids);
    }

    @PutMapping
    public ResponseDTO edit(@RequestBody Product product) {
        return this.productService.edit(product);
    }

    @GetMapping("/{id}")
    public ResponseDTO findById(@PathVariable Integer id) {
        return this.productService.findById(id);
    }

    @GetMapping
    public ResponseDTO list(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size, String name) {
        return this.productService.list(current, size, name);
    }
}
