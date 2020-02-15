package com.rasa.rest.simpleshopbyspring.service;

import com.rasa.rest.simpleshopbyspring.repository.ProductRepository;
import com.rasa.rest.simpleshopbyspring.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
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
        return productRepository.getOne(id);
    }
    public List<Product> findByName(String name)
    {
        return productRepository.findByNameContaining(name);
    }
    public List<Product> findByCategory(int category)
    {
        return productRepository.findByCategory(category);
    }
    public List<Product> findAll()
    {
        return productRepository.findAll();
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
