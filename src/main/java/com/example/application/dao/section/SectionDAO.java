package com.example.application.dao.section;

import com.example.application.model.Section;

import java.util.List;

public interface SectionDAO {
    List<Section> getAllSections();

    void saveSection(Section section);

    Section getSection(int id);

    void deleteSection(int id);
}
