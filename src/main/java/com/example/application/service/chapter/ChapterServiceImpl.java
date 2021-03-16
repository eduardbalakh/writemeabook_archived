package com.example.application.service.chapter;

import com.example.application.dao.chapter.ChapterDAO;
import com.example.application.dao.section.SectionDAO;
import com.example.application.dao.textstory.TextStoryDAO;
import com.example.application.model.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDAO chapterDAO;
    @Autowired
    private SectionDAO sectionDAO;
    @Autowired
    private TextStoryDAO textStoryDAO;

    @Override
    @Transactional
    public List<Chapter> getAllChapters() {
        return chapterDAO.getAllChapters();
    }

    @Override
    @Transactional
    public void saveChapter(Chapter chapter) {
        chapterDAO.saveChapter(chapter);
    }

    @Override
    @Transactional
    public Chapter getChapter(int id) {
        return chapterDAO.getChapter(id);
    }

    @Override
    @Transactional
    public void deleteChapter(int id) {
        Chapter chapterToDelete = getChapter(id);
        if (chapterToDelete != null) {
            if(chapterToDelete.getSections() != null && chapterToDelete.getSections().size() > 0) {
                chapterToDelete.getSections().forEach(section -> {
                    sectionDAO.deleteSection(section.getId());
                });
                chapterDAO.deleteChapter(id);
                if(chapterToDelete.getText() != null) {
                    textStoryDAO.deleteTextStory(chapterToDelete.getText().getId());
                }
            }
        }
    }
}
