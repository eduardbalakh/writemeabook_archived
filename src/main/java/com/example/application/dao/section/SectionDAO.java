package com.example.application.dao.section;

import com.example.application.model.Section;

import java.util.List;

public interface SectionDAO {
    List<Section> getAllProjects();

    void saveProject(Section section);

    Section getProject(int id);

    void deleteProject(int id);
}
