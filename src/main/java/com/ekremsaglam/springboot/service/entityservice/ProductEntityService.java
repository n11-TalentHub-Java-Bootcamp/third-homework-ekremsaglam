package com.ekremsaglam.springboot.service.entityservice;

import com.ekremsaglam.springboot.dao.ProductDao;
import com.ekremsaglam.springboot.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductEntityService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll(){
        return (List<Product>) productDao.findAll();
    }

    public Product findById(Long id){
        Optional<Product> optionalProduct = productDao.findById(id);

        Product product = null;
        if (optionalProduct.isPresent()){
            product = optionalProduct.get();
        }

        return product;
    }

    public Product save(Product product){
        product = productDao.save(product);

        return product;
    }

    public void delete(Product product){
        productDao.delete(product);
    }

    public void deleteById(Long id){
        productDao.deleteById(id);
    }

    public long count(){
        return productDao.count();
    }
}