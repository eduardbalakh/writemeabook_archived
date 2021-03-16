package com.example.application.service.subsection;

import com.example.application.dao.subsection.SubsectionDAO;
import com.example.application.model.Subsection;
import com.example.application.service.textstory.TextStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubsectionServiceImpl implements SubsectionService {

    @Autowired
    private SubsectionDAO subsectionDAO;

    @Autowired
    private TextStoryService textStoryService;

    @Override
    @Transactional
    public List<Subsection> getAllSubsections() {
        return subsectionDAO.getAllSubsections();
    }

    @Override
    @Transactional
    public Subsection saveSubsection(Subsection subsection) {
        if (subsection == null) throw new IllegalArgumentException("Subsection is null. Cannot save to DB");
        if (subsection.getText() != null)
            textStoryService.saveText(subsection.getText());
        subsectionDAO.saveSubsection(subsection);
        return subsection;
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
                textStoryService.deleteText(subsectionToDelete.getText().getId());
            }
        }
    }
}
