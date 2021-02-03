package com.bookstore.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "book", schema = "bookstoredb")
public class BookEntity {

    private Integer bookId;

    private CategoryEntity categoryByCategoryId;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private byte[] image;
    private Double price;
    private Date publishDate;
    private Date lastUpdateTime;
    private Collection<OrderDetailEntity> orderDetailsByBookId;
    private Collection<ReviewEntity> reviewsByBookId;

    public BookEntity() {
    }

    public BookEntity(Integer bookId) {
        this.bookId = bookId;
    }

    public BookEntity(String title, String author, String description, String isbn, byte[] image, Double price, Date publishDate, Date lastUpdateTime, CategoryEntity categoryByCategoryId) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
        this.image = image;
        this.price = price;
        this.publishDate = publishDate;
        this.lastUpdateTime = lastUpdateTime;
        this.categoryByCategoryId = categoryByCategoryId;
    }

    public BookEntity(String title, String author, String description, String isbn, byte[] image, Double price, Date publishDate, Date lastUpdateTime, CategoryEntity categoryByCategoryId, Collection<OrderDetailEntity> orderDetailsByBookId, Collection<ReviewEntity> reviewsByBookId) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
        this.image = image;
        this.price = price;
        this.publishDate = publishDate;
        this.lastUpdateTime = lastUpdateTime;
        this.categoryByCategoryId = categoryByCategoryId;
        this.orderDetailsByBookId = orderDetailsByBookId;
        this.reviewsByBookId = reviewsByBookId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true, nullable = false)
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "title", unique = true, nullable = false, length = 128)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author", nullable = false, length = 64)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 16777215)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "isbn", nullable = false, length = 15)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "image", nullable = false)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 12)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "publish_date", nullable = false, length = 10)
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "last_update_time", nullable = false, length = 19)
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date  lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<OrderDetailEntity> getOrderDetailsByBookId() {
        return orderDetailsByBookId;
    }

    public void setOrderDetailsByBookId(Collection<OrderDetailEntity> orderDetailsByBookId) {
        this.orderDetailsByBookId = orderDetailsByBookId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<ReviewEntity> getReviewsByBookId() {
        return reviewsByBookId;
    }

    public void setReviewsByBookId(Collection<ReviewEntity> reviewsByBookId) {
        this.reviewsByBookId = reviewsByBookId;
    }
}
