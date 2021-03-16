package com.example.application.service.project;

import com.example.application.dao.book.BookDAO;
import com.example.application.dao.project.BookProjectDAO;
import com.example.application.model.BookProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private BookProjectDAO bookProjectDAO;
    @Autowired
    private BookDAO bookDAO;


    @Override
    @Transactional
    public List<BookProject> getAllProjects() {
        List<BookProject> list = bookProjectDAO.getAllProjects();
        return list;
    }

    @Override
    @Transactional
    public void saveProject(BookProject project) {
        bookProjectDAO.saveProject(project);
    }

    @Override
    @Transactional
    public BookProject getProject(int id) {
        return bookProjectDAO.getProject(id);
    }

    @Override
    @Transactional
    public void deleteProject(int id) {
        BookProject projectToDelete = getProject(id);
        if (projectToDelete != null) {
            if (projectToDelete.getBooks() != null && projectToDelete.getBooks().size() > 0) {
                projectToDelete.getBooks().forEach(book -> {
                    bookDAO.deleteBook(book.getId());
                });
            }
            bookProjectDAO.deleteProject(id);
        }
    }
}
