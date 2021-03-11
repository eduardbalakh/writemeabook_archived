package com.example.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "subsections")
@Data
public class Subsection extends TextEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Section parentSection;

    @Column
    private String text;

    public Subsection() {
    }

    public Section getParentSection() {
        return parentSection;
    }

    public void setParentSection(Section parentSection) {
        this.parentSection = parentSection;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Subsection{" +
                "parentSection=" + parentSection +
                ", text='" + text + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", numOrder=" + numOrder +
                '}';
    }
}

