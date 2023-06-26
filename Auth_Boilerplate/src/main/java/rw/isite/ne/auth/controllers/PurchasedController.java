package rw.isite.ne.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.isite.ne.auth.dtos.PurchasedDto;
import rw.isite.ne.auth.dtos.SignUpDTO;
import rw.isite.ne.auth.models.Customer;
import rw.isite.ne.auth.models.Purchased;
import rw.isite.ne.auth.payload.ApiResponse;
import rw.isite.ne.auth.services.PurchasedService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/purchased")
public class PurchasedController {
    private final PurchasedService purchasedService;

    @Autowired
    public PurchasedController(PurchasedService purchasedService) {
        this.purchasedService = purchasedService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllPurchasedItems() {
        List<Purchased> purchasedItems = purchasedService.getAllPurchasedItems();
        return ResponseEntity.ok(ApiResponse.success(purchasedItems));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createPurchasedItem(@Valid @RequestBody PurchasedDto purchased) {
        return getApiResponseResponseEntity(purchased);
    }

    private ResponseEntity<ApiResponse> getApiResponseResponseEntity(@RequestBody @Valid PurchasedDto dto) {
        Purchased user = new Purchased();
        System.out.println("The product received is..." + dto.getProduct_code());

        user.setProduct(dto.getProduct_code());
        user.setQuantity(dto.getQuantity());
        user.setTotal(dto.getTotal());
        user.setDate(new Date());

        Purchased entity = this.purchasedService.createPurchasedItem(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, entity));
    }

    @GetMapping("/{purchasedItemId}")
    public ResponseEntity<ApiResponse> getPurchasedItemById(@PathVariable("purchasedItemId") UUID purchasedItemId) {
        Purchased purchasedItem = purchasedService.getPurchasedItemById(purchasedItemId);
        return ResponseEntity.ok(ApiResponse.success(purchasedItem));
    }
}

