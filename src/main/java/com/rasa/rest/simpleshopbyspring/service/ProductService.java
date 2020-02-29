package com.rasa.rest.simpleshopbyspring.service;

import com.rasa.rest.simpleshopbyspring.dto.response.ProductPagedListResponse;
import com.rasa.rest.simpleshopbyspring.repository.ProductRepository;
import com.rasa.rest.simpleshopbyspring.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class ProductService
{

    public Date getDate(){ return new java.sql.Timestamp(new java.util.Date().getTime());}
    @Autowired
    ProductRepository productRepository;

    public void save(Product product)
    {
        product.setCreateDate(getDate());
        product.setUpdateDate(getDate());
        productRepository.save(product);
    }
    public Product findById(Long id)
    {
        return new Product(1L);
    }
    public List<Product> findByName(String name)
    {
        return productRepository.findByNameContaining(name);
    }
    public List<Product> findByCategory(int category)
    {
        return productRepository.findByCategory(category);
    }
    public ProductPagedListResponse findAll(Pageable pageable)
    {

        ProductPagedListResponse pplr = new ProductPagedListResponse(
                productRepository.findAll(pageable),
                pageable, (int) productRepository.count());
        return pplr;
    }

    public void update(Product product)
    {
        product.setUpdateDate(getDate());
        productRepository.save(product);
    }

    public void deleteById(Long id)
    {
        productRepository.deleteById(id);
    }
}
