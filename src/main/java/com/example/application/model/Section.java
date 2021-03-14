package com.example.application.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sections")
@Data
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "num_order")
    private int numOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chapter_id")
    private Chapter parentChapter;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentSection")
    private List<Subsection> subsections;

    @OneToOne
    @JoinColumn(name = "text_id")
    private TextStory text;

    public Section() {
    }

    public void addSubsectionToSection(Subsection newSubsection) {
        if (subsections == null) subsections = new ArrayList<>();
        subsections.add(Objects.requireNonNull(newSubsection));
        newSubsection.setParentSection(this);
    }

}
