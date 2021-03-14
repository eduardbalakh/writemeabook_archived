package com.example.application.service;

import com.example.application.dao.book.BookDAO;
import com.example.application.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Override
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}
