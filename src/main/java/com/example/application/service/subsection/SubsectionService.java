package com.example.application.service.subsection;

import com.example.application.model.Subsection;

import java.util.List;

public interface SubsectionService {

    List<Subsection> getAllProjects();

    void saveProject(Subsection subsection);

    Subsection getProject(int id);

    void deleteProject(int id);
}
