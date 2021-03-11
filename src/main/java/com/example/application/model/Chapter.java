package com.example.application.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "chapters")
public class Chapter implements TextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "chapter_name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book parentBook;

    @Column(name = "num_order")
    private int numOrder;

    @Column(name = "text")
    private String text;

    public Chapter() {
    }

}
