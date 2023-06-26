package rw.isite.ne.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.isite.ne.auth.exceptions.ResourceNotFoundException;
import rw.isite.ne.auth.models.Product;
import rw.isite.ne.auth.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(UUID productId) {
        return productRepository.findById(productId);
    }

    public Product createProduct(Product product) {
        // Add any additional validation or business logic here
        return productRepository.save(product);
    }

    public Product updateProduct(UUID productId, Product productDetails) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        // Update the existing product with the provided details
        existingProduct.setName(productDetails.getName());
        existingProduct.setProductType(productDetails.getProductType());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setInDate(productDetails.getInDate());
        existingProduct.setImage(productDetails.getImage());

        // Save the updated product
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }

}
