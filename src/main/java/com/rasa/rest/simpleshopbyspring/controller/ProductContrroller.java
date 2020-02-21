package com.rasa.rest.simpleshopbyspring.controller;

import com.rasa.rest.simpleshopbyspring.repository.entity.Product;
import com.rasa.rest.simpleshopbyspring.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Api(tags = "Product Api")
@RestController

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

    @GetMapping("/products/category/{category}")
    public List<Product> findByCategory(@PathVariable int category)
    {
        return productService.findByCategory(category);
    }

    @GetMapping("/products")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),

            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
   public Page<Product> findAll(Pageable pageable)
    {
        return productService.findAll(pageable);
    }

    @PutMapping("/products")
    public void update(@RequestBody Product product)
    {
        productService.update(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable Long id)
    {
        productService.deleteById(id);
    }
}
