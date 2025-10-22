package sum25vietnxse184785.pojo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "SonyProducts")
public class SonyProduct {

    @Id
    @Column(name = "ProductID", nullable = false)
    private Integer productID;

    @Column(name = "ProductName", length = 50)
    private String productName;

    @Column(name = "Price")
    private Integer price;

    @Column(name = "Stock")
    private Integer stock;

    @Column(name = "CreatedAt")
    private LocalDate createdAt;

    public SonyProduct() {
    }
    public SonyProduct(Integer productID, String productName, Integer price, Integer stock, LocalDate createdAt, SonyCategorie category) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
        this.category = category;
    }

    // Many-to-One với SonyCategories
    @ManyToOne
    @JoinColumn(name = "CateID")  // Khóa ngoại trong SonyProducts
    private SonyCategorie category;

    // Getter & Setter
    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public SonyCategorie getCategory() {
        return category;
    }

    public void setCategory(SonyCategorie category) {
        this.category = category;
    }
}
