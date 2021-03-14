package com.example.application.service;

import com.example.application.model.BookProject;

import java.util.List;

public interface ProjectService {
    List<BookProject> getAllProjects();

    void saveProject(BookProject project);

    BookProject getProject(int id);

    void deleteProject(int id);
}
