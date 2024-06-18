package com.phat.e.project.Controller.Api.Client;

import com.phat.e.project.Entity.Product;
import com.phat.e.project.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
        @GetMapping
        public List<Product> getAllProducts () {
            return productService.getAllProducts();
        }


    }

