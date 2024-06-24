package com.phat.e.project.Service;

import com.phat.e.project.Entity.Product;
import com.phat.e.project.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    LocalDateTime now = LocalDateTime.now();
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
        product.setDateAdded(now);
        product.setCreatedAt(now);
        product.setUpdatedAt(now);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setProductName(updatedProduct.getProductName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            product.setCategory(updatedProduct.getCategory());
            product.setSeller(updatedProduct.getSeller());
            product.setStatus(updatedProduct.isStatus());
            product.setUpdatedAt(now);

            return productRepository.save(product);
        } else {
            return null;
        }
    }

    @Override
    public Product deleteProduct(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return product.get();
        } else {
            return null;
        }
    }
}
