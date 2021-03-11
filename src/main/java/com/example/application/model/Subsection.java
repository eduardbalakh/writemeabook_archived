package com.example.application.model;

public class Subsection extends TextEntity {

    private static final byte LEVEL = 4;

    private Section parentSection;

    private String text;

    public Subsection(long id, String entityName, TextEntity parent) {
        super(id, entityName, parent);
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

    public static byte getLEVEL() {
        return LEVEL;
    }
}
