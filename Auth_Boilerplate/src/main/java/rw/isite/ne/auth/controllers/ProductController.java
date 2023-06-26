package rw.isite.ne.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.isite.ne.auth.dtos.NewProductDto;
import rw.isite.ne.auth.dtos.SignUpDTO;
import rw.isite.ne.auth.models.Customer;
import rw.isite.ne.auth.models.Product;
import rw.isite.ne.auth.payload.ApiResponse;
import rw.isite.ne.auth.services.ProductService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody NewProductDto product) {
        return getApiResponseResponseEntity(product);
    }

    private ResponseEntity<ApiResponse> getApiResponseResponseEntity(@RequestBody @Valid NewProductDto dto) {
        Product product = new Product();
        product.setProductType(dto.getProductType());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        product.setInDate(new Date());

        Product entity = this.productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, entity));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable("productId") UUID productId) {
        Optional<Product> product = productService.getProductById(productId);
        return ResponseEntity.ok(ApiResponse.success(product));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(
            @PathVariable("productId") UUID productId,
            @Valid @RequestBody Product productDetails
    ) {
        Product updatedProduct = productService.updateProduct(productId, productDetails);
        return ResponseEntity.ok(ApiResponse.success(updatedProduct));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productId") UUID productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok(ApiResponse.success("Product deleted successfully"));
    }
}
