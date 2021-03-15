package com.example.application.service.section;

import com.example.application.dao.section.SectionDAO;
import com.example.application.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDAO sectionDAO;

    @Override
    @Transactional
    public List<Section> getAllProjects() {
        return sectionDAO.getAllProjects();
    }

    @Override
    @Transactional
    public void saveProject(Section section) {
        sectionDAO.saveProject(section);
    }

    @Override
    @Transactional
    public Section getProject(int id) {
        return sectionDAO.getProject(id);
    }

    @Override
    @Transactional
    public void deleteProject(int id) {
        sectionDAO.deleteProject(id);
    }
}
