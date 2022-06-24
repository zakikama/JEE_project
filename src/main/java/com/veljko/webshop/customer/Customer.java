package com.veljko.webshop.customer;

import com.veljko.webshop.sale.Sale;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @NotBlank
    @Size(min = 4, max = 15, message = "Name must be between 4 and 15 characters")
    private String name;

    @NotBlank
    @Email
    @Size(min = 4, max = 60, message = "Email must be between 4 and 60 characters")
    private String email;

    @NotBlank
    @Size(min = 4, max = 30, message = "Address must be between 4 and 30 characters")
    private String address;

    private int purchases;
    private int spent;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Sale> sales;

    public Customer() {
    }

    public Customer(String name, String email, String address, int purchases, int spent) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.purchases = purchases;
        this.spent = spent;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getSpent() {
        return spent;
    }

    public void setSpent(int spent) {
        this.spent = spent;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", purchases=" + purchases +
                ", spent=" + spent +
                ", sales=" + sales +
                '}';
    }
}
