package com.example.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "projects")
@Data
public class BookProject extends TextEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentBookProject")
    private List<Book> books;

    public BookProject() {
    }

    public BookProject(User user, List<Book> books, String title, int numOrder) {
        super(title, numOrder);
        this.user = user;
        this.books = books;
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
