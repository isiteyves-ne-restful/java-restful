package rw.isite.ne.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.isite.ne.auth.exceptions.ResourceNotFoundException;
import rw.isite.ne.auth.models.Quantity;
import rw.isite.ne.auth.repositories.QuantityRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuantityService {

    private final QuantityRepository quantityRepository;

    @Autowired
    public QuantityService(QuantityRepository quantityRepository) {
        this.quantityRepository = quantityRepository;
    }

    public List<Quantity> getAllQuantities() {
        return quantityRepository.findAll();
    }

    public Optional<Quantity> getQuantityById(UUID quantityId) {
        return quantityRepository.findById(quantityId);
    }

    public Quantity createQuantity(Quantity quantity) {
        return quantityRepository.save(quantity);
    }

    public void deleteQuantity(UUID quantityId) {
        quantityRepository.deleteById(quantityId);
    }

    public Quantity updateQuantity(UUID quantityId, Quantity quantityDetails) {
        Quantity existingQuantity = getQuantityById(quantityId)
                .orElseThrow(() -> new ResourceNotFoundException("Quantity", "id", quantityId));
        existingQuantity.setProduct(Optional.ofNullable(quantityDetails.getProduct()));
        existingQuantity.setQuantity(quantityDetails.getQuantity());
        existingQuantity.setOperation(quantityDetails.getOperation());
        existingQuantity.setDate(quantityDetails.getDate());

        return quantityRepository.save(existingQuantity);
    }

}

