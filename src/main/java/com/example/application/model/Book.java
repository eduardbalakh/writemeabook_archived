package com.example.application.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name")
    private String book_name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private BookProject parentBookProject;

    @Column(name = "num_order")
    private int numOrder;


    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "parentBook")
    private List<Chapter> chapters;

    public Book() {
    }

    public Book(String book_name, BookProject parentBookProject) {
        this.book_name = book_name;
        this.parentBookProject = parentBookProject;
    }

    public void addChapterToBook(Chapter newChapter) {
        if(chapters == null)
            chapters = new ArrayList<>();
        chapters.add(Objects.requireNonNull(newChapter));
        newChapter.setParentBook(this);
    }

}
