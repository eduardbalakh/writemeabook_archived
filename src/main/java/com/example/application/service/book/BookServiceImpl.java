package com.example.application.service.book;

import com.example.application.dao.book.BookDAO;
import com.example.application.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Override
    @Transactional
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}
