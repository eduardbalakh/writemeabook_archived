package com.example.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "chapters")
public class Chapter implements TreeTextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "num_order")
    private int numOrder;

/*    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Book parentBook;*/

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
    orphanRemoval = true)
    @JoinColumn(name="chapter_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Section> sections;


    @OneToOne(fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    @JoinColumn(name = "text_id")
    private TextStory text;

    public Chapter() {
    }

    public Chapter(String title, int numOrder,
                   //Book parentBook,
                   TextStory text) {
        this.title = title;
        this.numOrder = numOrder;
        //this.parentBook = parentBook;
        this.text = text;
        //parentBook.addChapterToBook(this);
    }

    public void addSectionToChapter(Section newSection) {
        if (sections == null) sections = new ArrayList<>();
        sections.add(Objects.requireNonNull(newSection));
        //newSection.setParentChapter(this);
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", title='" + title +
                ", numOrder=" + numOrder +
                //", parentBook=" + parentBook.getTitle() +
                ", text=" + text.getText() +
                '}';
    }

/*    @Override
    public int hashCode() {
        return Objects.hash(id, title, numOrder, parentBook.getId(), parentBook.getTitle());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if (! (obj instanceof Chapter)) return false;
        Chapter that = (Chapter) obj;
        return (that.id == this.id) &&
                (that.title.equals(this.title));
    }*/
}
