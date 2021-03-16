package com.example.application.service.section;

import com.example.application.dao.section.SectionDAO;
import com.example.application.model.Section;
import com.example.application.service.subsection.SubsectionService;
import com.example.application.service.textstory.TextStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDAO sectionDAO;
    @Autowired
    private SubsectionService subsectionService;
    @Autowired
    private TextStoryService textStoryService;

    @Override
    @Transactional
    public List<Section> getAllSections() {
        return sectionDAO.getAllSections();
    }

    @Override
    @Transactional
    public Section saveSection(Section section) {
        if (section == null) throw new IllegalArgumentException("Section is null. Cannot save to DB");
        if (section.getSubsections() != null && section.getSubsections().size() > 0)
            section.getSubsections().forEach(subsection -> {
                subsectionService.saveSubsection(subsection);
            });
        if (section.getText() != null)
            textStoryService.saveText(section.getText());
        sectionDAO.saveSection(section);
        return section;
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
                    subsectionService.deleteSubsection(subsection.getId());
                });
            }
            sectionDAO.deleteSection(id);
            if (sectionToDelete.getText() != null) {
                textStoryService.deleteText(sectionToDelete.getText().getId());
            }
        }
    }
}

