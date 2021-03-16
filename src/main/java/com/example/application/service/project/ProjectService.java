package com.example.application.service.project;

import com.example.application.model.BookProject;

import java.util.List;

public interface ProjectService {
    List<BookProject> getAllProjects();

    BookProject saveProject(BookProject project);

    BookProject getProject(int id);

    void deleteProject(int id);
}
