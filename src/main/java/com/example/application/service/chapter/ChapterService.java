package com.example.application.service.chapter;

import com.example.application.model.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> getAllChapters();

    void saveChapter(Chapter chapter);

    Chapter getChapter(int id);

    void deleteChapter(int id);
}
