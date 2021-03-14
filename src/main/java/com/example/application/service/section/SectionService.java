package com.example.application.service.section;

import com.example.application.model.Section;

import java.util.List;

public interface SectionService {
    List<Section> getAllProjects();

    void saveProject(Section section);

    Section getProject(int id);

    void deleteProject(int id);
}
