package com.example.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "chapters")
public class Chapter extends TextEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book parentBook;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentChapter")
    private List<Section> sections;

    @Column
    private String text;

    public Chapter() {
    }

    public Chapter(String title, int numOrder, Book parentBook, List<Section> sections, String text) {
        super(title, numOrder);
        this.parentBook = parentBook;
        this.sections = sections;
        this.text = text;
    }

    public void addSectionToChapter(Section newSection) {
        if(sections == null) sections = new ArrayList<>();
        sections.add(Objects.requireNonNull(newSection));
        newSection.setParentChapter(this);
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "parentBook=" + parentBook +
                ", text='" + text + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", numOrder=" + numOrder +
                '}';
    }
}
