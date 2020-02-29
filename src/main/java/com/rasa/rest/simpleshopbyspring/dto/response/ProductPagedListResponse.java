package com.rasa.rest.simpleshopbyspring.dto.response;

import com.rasa.rest.simpleshopbyspring.repository.entity.Product;
import org.springframework.data.domain.Pageable;


import java.util.List;

public class ProductPagedListResponse
{
    private List<Product> productList;
    private int productListSize;
    private Pageable pageable;

    public ProductPagedListResponse(List<Product> productList,
                                    Pageable pageable, int productListSize) {
        this.productList = productList;
        this.pageable = pageable;
        this.productListSize = productListSize;
    }

    public ProductPagedListResponse(){

    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public int getProductListSize() {
        return productListSize;
    }

    public void setProductListSize(int productListSize) {
        this.productListSize = productListSize;
    }
}
