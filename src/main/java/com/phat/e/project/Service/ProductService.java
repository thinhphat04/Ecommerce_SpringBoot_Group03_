package com.phat.e.project.Service;

import com.phat.e.project.Entity.Product;
import com.phat.e.project.Repository.CategoryRepository;
import com.phat.e.project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    LocalDateTime now = LocalDateTime.now();
    ProductRepository productRepository;
     CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getOneProduct(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        // Check if category is valid
        if (product.getCategory() == null || !categoryRepository.existsById(product.getCategory().getId())) {
            throw new IllegalArgumentException("Invalid category.");
        }
        product.setDateAdded(now);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            // Check if category is valid
            if (updatedProduct.getCategory() == null || !categoryRepository.existsById(updatedProduct.getCategory().getId())) {
                throw new IllegalArgumentException("Invalid category.");
            }

            product.setProductName(updatedProduct.getProductName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            product.setCategory(updatedProduct.getCategory());
            product.setStatus(updatedProduct.isStatus());
            product.setUpdatedAt(now);

            return productRepository.save(product);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteProduct(String id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            productRepository.delete(existingProduct.get());
            return true;
        } else {
            throw new IllegalArgumentException("Product not found with ID: " + id);
        }
    }
    @Override
    public List<Product> findByProductName(String productName){
        return productRepository.findByProductName(productName);
    }
}
