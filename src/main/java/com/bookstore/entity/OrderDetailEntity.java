package com.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_detail", schema = "bookstoredb")
public class OrderDetailEntity {

    private Long id;
    private BookOrderEntity bookOrderByOrderId;
    private BookEntity bookByBookId;
    private Integer quantity;
    private Double subtotal;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(Long id) {
        this.id = id;
    }

    public OrderDetailEntity(BookOrderEntity bookOrderByOrderId, BookEntity bookByBookId, Integer quantity, Double subtotal) {
        this.bookOrderByOrderId = bookOrderByOrderId;
        this.bookByBookId = bookByBookId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "subtotal", nullable = false, precision = 12)
    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false, nullable = false)
    public BookOrderEntity getBookOrderByOrderId() {
        return bookOrderByOrderId;
    }

    public void setBookOrderByOrderId(BookOrderEntity bookOrderByOrderId) {
        this.bookOrderByOrderId = bookOrderByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false, nullable = false)
    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }
}
