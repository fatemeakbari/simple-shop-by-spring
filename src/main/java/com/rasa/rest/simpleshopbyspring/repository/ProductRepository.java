package com.rasa.rest.simpleshopbyspring.repository;

import com.rasa.rest.simpleshopbyspring.repository.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    public List<Product> findByNameContaining(String name);
    public List<Product> findByCategory(int category);

    public List<Product> findAll(Pageable page);
}
