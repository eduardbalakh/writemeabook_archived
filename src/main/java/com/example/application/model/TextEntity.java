package com.example.application.model;

import javax.persistence.*;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class TextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "title")
    protected String title;

    @Column(name = "num_order")
    protected int numOrder;

    public TextEntity() {
    }

    public TextEntity(String title, int numOrder) {
        this.title = title;
        this.numOrder = numOrder;
    }
}
