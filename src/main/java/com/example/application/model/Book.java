package com.example.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "books")
@Data
public class Book extends TextEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private BookProject parentBookProject;


    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentBook")
    private List<Chapter> chapters;

    public Book() {
    }

    public Book(String title, int numOrder, BookProject parentBookProject, List<Chapter> chapters) {
        super(title, numOrder);
        this.parentBookProject = parentBookProject;
        this.chapters = chapters;
    }

    public void addChapterToBook(Chapter newChapter) {
        if (chapters == null)
            chapters = new ArrayList<>();
        chapters.add(Objects.requireNonNull(newChapter));
        newChapter.setParentBook(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "parentBookProject=" + parentBookProject +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", numOrder=" + numOrder +
                '}';
    }
}
