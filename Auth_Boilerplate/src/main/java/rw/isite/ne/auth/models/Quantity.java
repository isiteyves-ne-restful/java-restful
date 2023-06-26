package rw.isite.ne.auth.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "quantities")
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "operation")
    private String operation;

    @Column(name = "date")
    private Date date;

    // Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Optional<Product> product) {
        this.product = product.orElse(null);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
