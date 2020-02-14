package com.rasa.rest.simpleshopbyspring.service;

import com.rasa.rest.simpleshopbyspring.repository.ProductRepository;
import com.rasa.rest.simpleshopbyspring.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ProductRepository productRepository;

    public void save(Product product)
    {
        productRepository.save(product);
    }
    public Product findById(Long id)
    {
        return productRepository.getOne(id);
    }
    public List<Product> findByName(String name)
    {
        return productRepository.findFirstByNameContaining(name);
    }
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

    public void update(Product product)
    {
        productRepository.save(product);
    }

    public void deleteById(Long id)
    {
        productRepository.deleteById(id);
    }
}
