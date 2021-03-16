package com.example.application.service.project;

import com.example.application.dao.project.BookProjectDAO;
import com.example.application.model.BookProject;
import com.example.application.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private BookProjectDAO bookProjectDAO;
    @Autowired
    private BookService bookService;


    @Override
    @Transactional
    public List<BookProject> getAllProjects() {
        return bookProjectDAO.getAllProjects();
    }

    @Override
    @Transactional
    public BookProject saveProject(BookProject project) {
        if (project == null) throw new IllegalArgumentException("Project is null. Cannot save to DB");
        if(project.getBooks() != null && project.getBooks().size() > 0)
            project.getBooks().forEach(book ->
                    bookService.saveBook(book));
        bookProjectDAO.saveProject(project);
        return project;
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
                    bookService.deleteBook(book.getId());
                });
            }
            bookProjectDAO.deleteProject(id);
        }
    }
}
