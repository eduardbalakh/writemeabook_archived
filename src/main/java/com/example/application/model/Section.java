package com.example.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sections")
@Data
public class Section extends TextEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chapter_id")
    private Chapter parentChapter;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentSection")
    private List<Subsection> subsections;

    @Column
    private String text;

    public Section() {
    }

    public Section(String title, int numOrder, Chapter parentChapter, List<Subsection> subsections, String text) {
        super(title, numOrder);
        this.parentChapter = parentChapter;
        this.subsections = subsections;
        this.text = text;
    }

    public void addSubsectionToSection(Subsection newSubsection) {
        if (subsections == null) subsections = new ArrayList<>();
        subsections.add(Objects.requireNonNull(newSubsection));
        newSubsection.setParentSection(this);
    }

    @Override
    public String toString() {
        return "Section{" +
                "parentChapter=" + parentChapter +
                ", text='" + text + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", numOrder=" + numOrder +
                '}';
    }
}
