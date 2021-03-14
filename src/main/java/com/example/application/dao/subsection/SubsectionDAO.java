package com.example.application.dao.subsection;

import com.example.application.model.Subsection;

import java.util.List;

public interface SubsectionDAO {
    List<Subsection> getAllProjects();

    void saveProject(Subsection subsection);

    Subsection getProject(int id);

    void deleteProject(int id);
}
