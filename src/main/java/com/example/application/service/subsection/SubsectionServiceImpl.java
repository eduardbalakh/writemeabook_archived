package com.example.application.service.subsection;

import com.example.application.dao.subsection.SubsectionDAO;
import com.example.application.dao.textstory.TextStoryDAO;
import com.example.application.model.Subsection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubsectionServiceImpl implements SubsectionService {

    @Autowired
    private SubsectionDAO subsectionDAO;

    @Autowired
    private TextStoryDAO textStoryDAO;

    @Override
    @Transactional
    public List<Subsection> getAllSubsections() {
        return subsectionDAO.getAllSubsections();
    }

    @Override
    @Transactional
    public void saveSubsection(Subsection subsection) {
        subsectionDAO.saveSubsection(subsection);
    }

    @Override
    @Transactional
    public Subsection getSubsection(int id) {
        return subsectionDAO.getSubsection(id);
    }

    @Override
    @Transactional
    public void deleteSubsection(int id) {
        Subsection subsectionToDelete = getSubsection(id);
        if (subsectionToDelete != null) {
            subsectionDAO.deleteSubsection(id);
            if (subsectionToDelete.getText() != null){
                textStoryDAO.deleteTextStory(subsectionToDelete.getText().getId());
            }
        }
    }
}
