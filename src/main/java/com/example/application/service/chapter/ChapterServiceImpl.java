package com.example.application.service.chapter;

import com.example.application.model.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterService chapterService;

    @Override
    public List<Chapter> getAllChapters() {
        return chapterService.getAllChapters();
    }

    @Override
    public void saveChapter(Chapter chapter) {
        chapterService.saveChapter(chapter);
    }

    @Override
    public Chapter getChapter(int id) {
        return chapterService.getChapter(id);
    }

    @Override
    public void deleteChapter(int id) {
        chapterService.deleteChapter(id);
    }
}
