package com.example.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sections")
public class Section extends TextEntity {

    //private static final byte LEVEL = 3;

    //private List<Subsection> subsections;
    @Column
    private String text;

    public Section(long id, String entityName, TextEntity parent) {
        super(id, entityName, parent);
    }

    public Section() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /*public List<Subsection> getSubsections() {
        return subsections;
    }

    public void setSubsections(List<Subsection> subsections) {
        this.subsections = subsections;
    }
*/
/*    public static byte getLEVEL() {
        return LEVEL;
    }*/
}
