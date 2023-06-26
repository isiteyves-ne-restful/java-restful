package rw.isite.ne.auth.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "purchased")
public class Purchased {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "code")
    @Column(name = "prodocut_code")
    private String product_code;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total")
    private double total;

    @Column(name = "date")
    private Date date;

    // constructor
    public Purchased() {
    }

    public Purchased(String product, int quantity, double total, Date date) {
        this.product_code = product;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }

    // Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProduct() {
        return product_code;
    }

    public void setProduct(String product) {
        this.product_code = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

