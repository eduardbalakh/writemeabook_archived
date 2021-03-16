package com.example.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sections")
@Data
public class Section implements TreeTextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "num_order")
    private int numOrder;

/*    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "chapter_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Chapter parentChapter;*/

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
    orphanRemoval = true)
    @JoinColumn(name = "section_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Subsection> subsections;

    @OneToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    @JoinColumn(name = "text_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TextStory text;

    public Section() {
    }

    public Section(String title, int numOrder, TextStory text, Chapter parentChapter) {
        this.title = title;
        this.numOrder = numOrder;
        this.text = text;
        parentChapter.addSectionToChapter(this);
    }

    public void addSubsectionToSection(Subsection newSubsection) {
        if (subsections == null) subsections = new ArrayList<>();
        subsections.add(Objects.requireNonNull(newSubsection));
        //newSubsection.setParentSection(this);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numOrder=" + numOrder +
                //", parentChapter=" + parentChapter.getTitle() +
                ", text=" + text.getText() +
                '}';
    }
}
