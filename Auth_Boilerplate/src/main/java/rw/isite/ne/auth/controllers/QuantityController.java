package rw.isite.ne.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.isite.ne.auth.models.Product;
import rw.isite.ne.auth.models.Quantity;
import rw.isite.ne.auth.payload.ApiResponse;
import rw.isite.ne.auth.services.ProductService;
import rw.isite.ne.auth.services.QuantityService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityController {

    private final QuantityService quantityService;
    private final ProductService productService;

    @Autowired
    public QuantityController(QuantityService quantityService, ProductService productService) {
        this.quantityService = quantityService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllQuantities() {
        List<Quantity> quantities = quantityService.getAllQuantities();
        return ResponseEntity.ok(ApiResponse.success(quantities));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createQuantity(@Valid @RequestBody Quantity quantity) {
        // Retrieve the associated product
        Optional<Product> product = productService.getProductById(quantity.getProduct().getId());
        quantity.setProduct(product);

        Quantity createdQuantity = quantityService.createQuantity(quantity);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(createdQuantity));
    }

    @GetMapping("/{quantityId}")
    public ResponseEntity<ApiResponse> getQuantityById(@PathVariable("quantityId") UUID quantityId) {
        Optional<Quantity> quantity = quantityService.getQuantityById(quantityId);
        return ResponseEntity.ok(ApiResponse.success(quantity));
    }

    @PutMapping("/{quantityId}")
    public ResponseEntity<ApiResponse> updateQuantity(
            @PathVariable("quantityId") UUID quantityId,
            @Valid @RequestBody Quantity quantityDetails
    ) {
        // Retrieve the associated product
        Optional<Product> product = productService.getProductById(quantityDetails.getProduct().getId());
        quantityDetails.setProduct(product);

        Quantity updatedQuantity = quantityService.updateQuantity(quantityId, quantityDetails);
        return ResponseEntity.ok(ApiResponse.success(updatedQuantity));
    }

    @DeleteMapping("/{quantityId}")
    public ResponseEntity<ApiResponse> deleteQuantity(@PathVariable("quantityId") UUID quantityId) {
        quantityService.deleteQuantity(quantityId);
        return ResponseEntity.ok(ApiResponse.success("Quantity deleted successfully"));
    }
}

