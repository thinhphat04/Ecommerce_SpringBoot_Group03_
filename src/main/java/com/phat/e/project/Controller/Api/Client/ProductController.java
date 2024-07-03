package com.phat.e.project.Controller.Api.Client;

import com.phat.e.project.Entity.Product;
import com.phat.e.project.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

     IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getOneProduct(id);
    }

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        try {
            Product createdProduct = productService.createProduct(product);
            return "Product created successfully with ID: " + createdProduct.getId();
        } catch (Exception e) {
            return "Error creating product: " + e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        try {
            Product updated = productService.updateProduct(id, updatedProduct);
            if (updated != null) {
                return "Product updated successfully with ID: " + updated.getId();
            } else {
                return "Product not found with ID: " + id;
            }
        } catch (Exception e) {
            return "Error updating product: " + e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        try {
            boolean deleted = productService.deleteProduct(id);
            if (deleted) {
                return "Product deleted successfully with ID: " + id;
            } else {
                return "Product not found with ID: " + id;
            }
        } catch (Exception e) {
            return "Error deleting product: " + e.getMessage();
        }
    }

    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String name) {
        return productService.findByProductName(name);
    }
}
