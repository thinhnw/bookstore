package com.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "bookstoredb")
@NamedQueries({
    @NamedQuery(name = "UsersEntity.findAll", query = "SELECT u FROM UsersEntity u ORDER BY u.fullName"),
    @NamedQuery(name = "UsersEntity.findByEmail", query = "SELECT u FROM UsersEntity u WHERE u.email = :email"),
    @NamedQuery(name = "UsersEntity.countAll", query = "SELECT Count(*) FROM UsersEntity u"),
    @NamedQuery(name = "UsersEntity.checkLogin", query = "SELECT u FROM UsersEntity u WHERE u.email = :email AND password = :password")
})
public class UsersEntity {

    private Integer userId;
    private String email;
    private String fullName;
    private String password;

    public UsersEntity() {

    }

    public UsersEntity(Integer userId, String email, String fullName, String password) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public UsersEntity(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
