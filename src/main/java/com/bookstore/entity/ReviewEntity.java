package com.bookstore.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review", schema = "bookstoredb")
public class ReviewEntity {

    private Integer reviewId;
    private BookEntity bookByBookId;
    private CustomerEntity customerByCustomerId;
    private Integer rating;
    private String headline;
    private String comment;
    private Date reviewTime;

    public ReviewEntity() {
    }

    public ReviewEntity(Integer reviewId, BookEntity bookByBookId, CustomerEntity customerByCustomerId, Integer rating, String headline, String comment, Date reviewTime) {
        this.reviewId = reviewId;
        this.bookByBookId = bookByBookId;
        this.customerByCustomerId = customerByCustomerId;
        this.rating = rating;
        this.headline = headline;
        this.comment = comment;
        this.reviewTime = reviewTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", unique = true, nullable = false)
    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    @Basic
    @Column(name = "rating", nullable = false)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "headline", nullable = false, length = 128)
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = 500)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "review_time", nullable = false, length = 19)
    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
