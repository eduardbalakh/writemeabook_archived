package com.example.application.service.book;

import com.example.application.dao.book.BookDAO;
import com.example.application.model.Book;
import com.example.application.service.chapter.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private ChapterService chapterService;


    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book is null. Cannot save to DB");
        if (book.getChapters() != null && book.getChapters().size() > 0)
            book.getChapters().forEach(chapter -> {
                chapterService.saveChapter(chapter);
            });
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
        Book bookToDelete = getBook(id);
        if (bookToDelete.getChapters() != null && bookToDelete.getChapters().size() > 0) {
            bookToDelete.getChapters().forEach(chapter -> {
                chapterService.deleteChapter(chapter.getId());
            });
        }
        bookDAO.deleteBook(id);
    }
}
