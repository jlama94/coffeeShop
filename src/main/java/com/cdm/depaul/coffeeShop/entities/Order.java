package com.cdm.depaul.coffeeShop.entities;

import com.cdm.depaul.coffeeShop.interfaces.iOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "customer_order")
@Component
@Scope("prototype")
public class Order implements iOrder, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_number")
    private Long id;

    @Column
    private String orderName;
    @Column
    private String description;
    @Column
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public void setName(String name) {
        this.orderName = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String getName() {
        return orderName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Double.compare(order.getPrice(), getPrice()) == 0 &&
                Objects.equals(getId(), order.getId()) &&
                Objects.equals(orderName, order.orderName) &&
                Objects.equals(getDescription(), order.getDescription()) &&
                Objects.equals(getCustomer(), order.getCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), orderName, getDescription(), getPrice(), getCustomer());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order: {");
        sb.append("id=").append(id);
        sb.append(", orderName='").append(orderName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append(", customer=").append(customer);
        sb.append('}');
        return sb.toString();
    }
}
