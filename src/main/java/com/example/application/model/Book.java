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
@Table(name = "books")
public class Book implements TreeTextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "num_order")
    private int numOrder;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private BookProject parentBookProject;


    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentBook",
            fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Chapter> chapters;

    public Book() {
    }

    public Book(String title, int numOrder, BookProject parentBookProject) {
        this.title = title;
        this.parentBookProject = parentBookProject;
        this.numOrder = numOrder;
        parentBookProject.addBookToProject(this);
    }

    public void addChapterToBook(Chapter newChapter) {
        if (chapters == null)
            chapters = new ArrayList<>();
        chapters.add(Objects.requireNonNull(newChapter));
        newChapter.setParentBook(this);
    }

/*    @Override
    public String toString() {
        return "Book{" +
                "parentBookProject=" + parentBookProject.getTitle() +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", numOrder=" + numOrder +
                '}';
    }*/
}
