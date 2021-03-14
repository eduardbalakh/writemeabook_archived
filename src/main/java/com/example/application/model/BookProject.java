package com.example.application.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "projects")
public class BookProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "num_order")
    private int numOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentBookProject")
    private List<Book> books;

    public BookProject() {
    }

    public BookProject(User user, String title, int numOrder) {
        this.user = user;
        this.books = books;
        this.title = title;
        this.numOrder = numOrder;
    }

    public BookProject(String projectName) {
        this.title = projectName;
    }

    public void addBookToProject(Book newBook) {
        if (books == null) books = new ArrayList<>();
        books.add(Objects.requireNonNull(newBook));
        newBook.setParentBookProject(this);
    }

    @Override
    public String toString() {
        return "BookProject{" +
                "user=" + user +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", numOrder=" + numOrder +
                '}';
    }
}
