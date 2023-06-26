package rw.isite.ne.auth.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code")
    private UUID code;

    @Column(name = "name")
    private String name;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "price")
    private double price;

    @Column(name = "in_date")
    private Date inDate;

    @Column(name = "image")
    private String image;

    // constructor
    public Product(String name, String productType, double price, Date inDate, String image) {
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.inDate = inDate;
        this.image = image;
    }

    public Product() {

    }

    // Getters and setters
    public UUID getId() {
        return code;
    }

    public void setCode(UUID code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
