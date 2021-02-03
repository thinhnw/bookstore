package com.bookstore.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "customer", schema = "bookstoredb")
public class CustomerEntity {
    private Integer customerId;

    private String email;
    private String fullname;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String zipcode;
    private String password;
    private Date registerDate;
    private Collection<BookOrderEntity> bookOrdersByCustomerId;
    private Collection<ReviewEntity> reviewsByCustomerId;

    public CustomerEntity() {
    }

    public CustomerEntity(String email, String fullname, String address, String city, String country, String phone, String zipcode, String password, Date registerDate) {
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.zipcode = zipcode;
        this.password = password;
        this.registerDate = registerDate;
    }

    public CustomerEntity(String email, String fullname, String address, String city, String country, String phone, String zipcode, String password, Date registerDate, Collection<BookOrderEntity> bookOrdersByCustomerId, Collection<ReviewEntity> reviewsByCustomerId) {
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.zipcode = zipcode;
        this.password = password;
        this.registerDate = registerDate;
        this.bookOrdersByCustomerId = bookOrdersByCustomerId;
        this.reviewsByCustomerId = reviewsByCustomerId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", unique = true, nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "email", unique = true, nullable = false, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "fullname", nullable = false, length = 30)
    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 120)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 32)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 64)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "zipcode", nullable = false, length = 24)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "register_date", nullable = false, length = 19)
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }


    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<BookOrderEntity> getBookOrdersByCustomerId() {
        return bookOrdersByCustomerId;
    }

    public void setBookOrdersByCustomerId(Collection<BookOrderEntity> bookOrdersByCustomerId) {
        this.bookOrdersByCustomerId = bookOrdersByCustomerId;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<ReviewEntity> getReviewsByCustomerId() {
        return reviewsByCustomerId;
    }

    public void setReviewsByCustomerId(Collection<ReviewEntity> reviewsByCustomerId) {
        this.reviewsByCustomerId = reviewsByCustomerId;
    }
}
