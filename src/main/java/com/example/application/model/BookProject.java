package com.example.application.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "projects")
@Data
public class BookProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentBookProject")
    private List<Book> books;

    public BookProject() {
    }

    public BookProject(String projectName) {
        this.projectName = projectName;
    }

    public void addBookToProject(Book newBook) {
        if (books == null) books = new ArrayList<>();
        books.add(Objects.requireNonNull(newBook));
        newBook.setParentBookProject(this);
    }


}
