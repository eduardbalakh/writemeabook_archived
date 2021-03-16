package com.example.application.service.chapter;

import com.example.application.dao.chapter.ChapterDAO;
import com.example.application.model.Chapter;
import com.example.application.service.section.SectionService;
import com.example.application.service.textstory.TextStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDAO chapterDAO;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private TextStoryService textStoryService;

    @Override
    @Transactional
    public List<Chapter> getAllChapters() {
        return chapterDAO.getAllChapters();
    }

    @Override
    @Transactional
    public Chapter saveChapter(Chapter chapter) {
        if (chapter == null) throw new IllegalArgumentException("Chapter is null. Cannot save to DB");
        if (chapter.getSections() != null && chapter.getSections().size() > 0)
            chapter.getSections().forEach(section -> {
                sectionService.saveSection(section);
            });
        if (chapter.getText() != null)
            textStoryService.saveText(chapter.getText());
        chapterDAO.saveChapter(chapter);
        return chapter;
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
            if (chapterToDelete.getSections() != null && chapterToDelete.getSections().size() > 0) {
                chapterToDelete.getSections().forEach(section -> {
                    sectionService.deleteSection(section.getId());
                });
            }

            chapterDAO.deleteChapter(id);
            if (chapterToDelete.getText() != null) {
                textStoryService.deleteText(chapterToDelete.getText().getId());
            }
        }
    }
}

