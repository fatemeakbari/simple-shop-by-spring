package com.rasa.rest.simpleshopbyspring.controller;

import com.rasa.rest.simpleshopbyspring.repository.entity.Product;
import com.rasa.rest.simpleshopbyspring.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Product Api")
public class ProductContrroller
{
    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public void save(@RequestBody Product product)
    {
        productService.save(product);
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id)
    {
        return productService.findById(id);
    }

    @GetMapping("/products/name/{name}")
    public List<Product> findByName(@PathVariable String name)
    {
        return productService.findByName(name);
    }

    @GetMapping("/products")
    public List<Product> findAll()
    {
        return productService.findAll();
    }

    @PutMapping("/products")
    public void update(@RequestBody Product product)
    {
        productService.update(product);
    }

    @DeleteMapping("/products/{id]")
    public void deleteById(@PathVariable Long id)
    {
        productService.deleteById(id);
    }
}
