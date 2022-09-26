package com.learning.springweb.controller;

import com.learning.springweb.entities.Product;
import com.learning.springweb.entities.repos.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    private final ProductRepository repository;

    public ProductRestController(ProductRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/products/",method = RequestMethod.GET)
    public List<Product> getProduct(){
        return repository.findAll();

    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id) {
        return (Product) repository.findById(id).get();
    }

    @RequestMapping(value = "/products/", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return (Product) repository.save(product);
    }

    @RequestMapping(value = "/product/", method = RequestMethod.PUT)
    public Product UpdateProduct(@RequestBody Product product) {
        return (Product) repository.save(product);
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id) {
        repository.deleteById(id);
    }


}
