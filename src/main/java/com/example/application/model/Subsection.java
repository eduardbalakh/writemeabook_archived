package com.example.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "subsections")
@Data
public class Subsection implements TreeTextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "num_order")
    private int numOrder;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Section parentSection;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "text_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TextStory text;

    public Subsection() {
    }

}

