package com.example.application.dao.project;

import com.example.application.model.BookProject;

import java.util.List;

public interface BookProjectDAO {
    List<BookProject> getAllProjects();

    void saveProject(BookProject project);

    BookProject getProject(int id);

    void deleteProject(int id);
}
