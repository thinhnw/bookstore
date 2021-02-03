package com.bookstore.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "book_order", schema = "bookstoredb")
public class BookOrderEntity {

    private Integer orderId;

    private CustomerEntity customerByCustomerId;
    private Date orderDate;
    private String shippingAddress;
    private String recipientName;
    private String recipientPhone;
    private String paymentMethod;
    private Double total;
    private String status;
    private Collection<OrderDetailEntity> orderDetailsByOrderId;

    public BookOrderEntity() {
    }

    public BookOrderEntity(CustomerEntity customerByCustomerId, Date orderDate, String shippingAddress, String recipientName, String recipientPhone, String paymentMethod, Double total, String status) {
        this.customerByCustomerId = customerByCustomerId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.status = status;
    }

    public BookOrderEntity(CustomerEntity customerByCustomerId, Date orderDate, String shippingAddress, String recipientName, String recipientPhone, String paymentMethod, Double total, String status, Collection<OrderDetailEntity> orderDetailsByOrderId) {
        this.customerByCustomerId = customerByCustomerId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.status = status;
        this.orderDetailsByOrderId = orderDetailsByOrderId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    @Basic
    @Column(name = "order_date", nullable = false, length = 19)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "shipping_address", nullable = false, length = 256)
    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Basic
    @Column(name = "recipient_name", nullable = false, length = 30)
    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    @Basic
    @Column(name = "recipient_phone", nullable = false, length = 15)
    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    @Basic
    @Column(name = "payment_method", nullable = false, length = 20)
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Basic
    @Column(name = "total", nullable = false, precision = 12)
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @OneToMany(mappedBy = "bookOrderByOrderId")
    public Collection<OrderDetailEntity> getOrderDetailsByOrderId() {
        return orderDetailsByOrderId;
    }

    public void setOrderDetailsByOrderId(Collection<OrderDetailEntity> orderDetailsByOrderId) {
        this.orderDetailsByOrderId = orderDetailsByOrderId;
    }
}
