package rw.isite.ne.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.isite.ne.auth.models.Purchased;
import rw.isite.ne.auth.repositories.PurchasedRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PurchasedService {

    private final PurchasedRepository purchasedRepository;

    @Autowired
    public PurchasedService(PurchasedRepository purchasedRepository) {
        this.purchasedRepository = purchasedRepository;
    }

    public List<Purchased> getAllPurchasedItems() {
        return purchasedRepository.findAll();
    }

    public Purchased createPurchasedItem(Purchased purchased) {
        return purchasedRepository.save(purchased);
    }

    public Purchased getPurchasedItemById(UUID purchasedItemId) {
        Optional<Purchased> optionalPurchasedItem = purchasedRepository.findById(purchasedItemId);
        return optionalPurchasedItem.orElse(null);
    }

}
