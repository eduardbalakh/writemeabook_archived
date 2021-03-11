package com.example.application.model;

import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {

        User user = new User(Role.ADMIN, new ArrayList<>());
        BookProject bookProject = new BookProject(user, new ArrayList<>(), "Final Fantasy", 1);
        user.addBookProject(bookProject);
        Book book1 = new Book("Final Fantasy VII", 1, bookProject, new ArrayList<>());
        bookProject.addBookToProject(book1);
        Chapter chapter1_1 = new Chapter("First chapter", 1, book1, new ArrayList<>(), null);
        book1.addChapterToBook(chapter1_1);
        Chapter chapter2_1 = new Chapter("Second chapter", 2, book1, new ArrayList<>(), null);
        book1.addChapterToBook(chapter2_1);
        Section section1_1_1 = new Section("Section 1_1", 1, chapter1_1, new ArrayList<>(), "Text of section 1_1_1");
        chapter1_1.addSectionToChapter(section1_1_1);
        Section section2_1_1 = new Section("Section 1_2", 2, chapter1_1, new ArrayList<>(), "Text of section 2_1_1");
        chapter1_1.addSectionToChapter(section2_1_1);
        Section section1_2_1 = new Section("Section 2_1", 1, chapter2_1, new ArrayList<>(), "Text of section 1_2_1");
        chapter2_1.addSectionToChapter(section1_2_1);
        Section section2_2_1 = new Section("Section 2_2", 2, chapter2_1, new ArrayList<>(), "Text of section 2_2_1");
        chapter2_1.addSectionToChapter(section2_2_1);
    }
}
