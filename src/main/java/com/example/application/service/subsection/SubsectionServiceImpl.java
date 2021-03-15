package com.example.application.service.subsection;

import com.example.application.dao.subsection.SubsectionDAO;
import com.example.application.model.Subsection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubsectionServiceImpl implements SubsectionService {

    @Autowired
    private SubsectionDAO subsectionDAO;

    @Override
    @Transactional
    public List<Subsection> getAllProjects() {
        return subsectionDAO.getAllProjects();
    }

    @Override
    @Transactional
    public void saveProject(Subsection subsection) {
        subsectionDAO.saveProject(subsection);
    }

    @Override
    @Transactional
    public Subsection getProject(int id) {
        return subsectionDAO.getProject(id);
    }

    @Override
    @Transactional
    public void deleteProject(int id) {
        subsectionDAO.deleteProject(id);
    }
}
