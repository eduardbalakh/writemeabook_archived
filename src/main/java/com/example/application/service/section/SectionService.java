package com.example.application.service.section;

import com.example.application.model.Section;

import java.util.List;

public interface SectionService {
    List<Section> getAllSections();

    Section saveSection(Section section);

    Section getSection(int id);

    void deleteSection(int id);
}
