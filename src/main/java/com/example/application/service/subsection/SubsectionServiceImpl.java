package com.example.application.service.subsection;

import com.example.application.dao.subsection.SubsectionDAO;
import com.example.application.model.Subsection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsectionServiceImpl implements SubsectionService {

    @Autowired
    private SubsectionDAO subsectionDAO;

    @Override
    public List<Subsection> getAllProjects() {
        return subsectionDAO.getAllProjects();
    }

    @Override
    public void saveProject(Subsection subsection) {
        subsectionDAO.saveProject(subsection);
    }

    @Override
    public Subsection getProject(int id) {
        return subsectionDAO.getProject(id);
    }

    @Override
    public void deleteProject(int id) {
        subsectionDAO.deleteProject(id);
    }
}
