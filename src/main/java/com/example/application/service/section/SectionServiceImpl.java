package com.example.application.service.section;

import com.example.application.dao.section.SectionDAO;
import com.example.application.dao.subsection.SubsectionDAO;
import com.example.application.dao.textstory.TextStoryDAO;
import com.example.application.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDAO sectionDAO;
    @Autowired
    private SubsectionDAO subsectionDAO;
    @Autowired
    private TextStoryDAO textStoryDAO;

    @Override
    @Transactional
    public List<Section> getAllSections() {
        return sectionDAO.getAllSections();
    }

    @Override
    @Transactional
    public void saveSection(Section section) {
        sectionDAO.saveSection(section);
    }

    @Override
    @Transactional
    public Section getSection(int id) {
        return sectionDAO.getSection(id);
    }

    @Override
    @Transactional
    public void deleteSection(int id) {
        Section sectionToDelete = getSection(id);
        if (sectionToDelete != null) {
            if (sectionToDelete.getSubsections() != null && sectionToDelete.getSubsections().size() > 0) {
                sectionToDelete.getSubsections().forEach((subsection) -> {
                    subsectionDAO.deleteSubsection(subsection.getId());
                });
            }
            sectionDAO.deleteSection(id);
            if (sectionToDelete.getText() != null) {
                textStoryDAO.deleteTextStory(sectionToDelete.getText().getId());
            }
        }
    }
}

