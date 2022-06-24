package com.veljko.webshop.product;

import com.veljko.webshop.sale.Sale;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @NotBlank
    @Size(min = 4, max = 25, message = "Name must be between 4 and 25 characters")
    private String name;

    @NotBlank
    @Size(min = 10, max = 300, message = "Description must be between 10 and 300 characters")
    private String description;

    @NotNull
    @Min(value = 0)
    private int stock;

    @NotNull
    @Min(value = 10, message = "Price must be larger then 10")
    private int price;

    @NotBlank
    private String image;

    @Column(name = "times_sold")
    private int timesSold;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Sale> sales;

    public Product() {
    }

    public Product(String name, String description, int stock, int price, String image, int timesSold) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.image = image;
        this.timesSold = timesSold;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTimesSold() {
        return timesSold;
    }

    public void setTimesSold(int timesSold) {
        this.timesSold = timesSold;
    }


    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", timesSold=" + timesSold +
                ", sales=" + sales +
                '}';
    }
}
