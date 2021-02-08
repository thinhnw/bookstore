package com.bookstore.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category", schema = "bookstoredb")
@NamedQueries({
        @NamedQuery(name = "CategoryEntity.findAll",
                    query = "SELECT c FROM CategoryEntity c ORDER BY c.name"),
        @NamedQuery(name = "CategoryEntity.countAll",
                    query = "SELECT COUNT(*) FROM CategoryEntity c"),
        @NamedQuery(name = "CategoryEntity.findByName",
                    query = "SELECT c FROM CategoryEntity c WHERE c.name = :name")
})
public class CategoryEntity {

    private Integer categoryId;
    private String name;
    private Collection<BookEntity> booksByCategoryId;

    public CategoryEntity() {
    }

    public CategoryEntity(String name) {
        this.name = name;
    }

    public CategoryEntity(String name, Collection<BookEntity> booksByCategoryId) {
        this.name = name;
        this.booksByCategoryId = booksByCategoryId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true, nullable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<BookEntity> getBooksByCategoryId() {
        return booksByCategoryId;
    }

    public void setBooksByCategoryId(Collection<BookEntity> booksByCategoryId) {
        this.booksByCategoryId = booksByCategoryId;
    }
}
