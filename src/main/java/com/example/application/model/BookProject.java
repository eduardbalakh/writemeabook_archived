package com.example.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "projects")
public class BookProject implements TreeTextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "num_order")
    private int numOrder;

/*    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;*/

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @JoinColumn(name = "project_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Book> books;

    public BookProject() {
    }

    public BookProject(
            //User user,
            String title, int numOrder) {
        this.title = title;
        this.numOrder = numOrder;
        //this.user = Objects.requireNonNull(user);
        //user.addBookProject(this);
    }

    public BookProject(String projectName) {
        this.title = projectName;
    }

    public void addBookToProject(Book newBook) {
        if (books == null) books = new ArrayList<>();
        books.add(Objects.requireNonNull(newBook));
        //newBook.setParentBookProject(this);
    }

    @Override
    public String toString() {
        return "BookProject{" +
                //"user=" + user.getId() +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", numOrder=" + numOrder +
                '}';
    }
}
