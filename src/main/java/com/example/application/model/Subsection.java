package com.example.application.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "subsections")
@Data
public class Subsection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "num_order")
    private int numOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Section parentSection;

    @OneToOne
    @JoinColumn(name = "text_id")
    private TextStory text;

    public Subsection() {
    }

}

