package com.example.application.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "num_order")
    private int numOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book parentBook;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentChapter")
    private List<Section> sections;


    @OneToOne
    @JoinColumn(name = "text_id")
    private TextStory text;

    public Chapter() {
    }

    public Chapter(String title, int numOrder, Book parentBook, List<Section> sections, TextStory text) {
        this.title = title;
        this.numOrder = numOrder;
        this.parentBook = parentBook;
        this.sections = sections;
        this.text = text;
    }

    public void addSectionToChapter(Section newSection) {
        if(sections == null) sections = new ArrayList<>();
        sections.add(Objects.requireNonNull(newSection));
        newSection.setParentChapter(this);
    }



}
