package com.example.application.dao.book;

import com.example.application.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks();

    void saveBook(Book project);

    Book getBook(int id);

    void deleteBook(int id);
}
