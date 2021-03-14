package com.example.application.dao.chapter;

import com.example.application.model.Chapter;

import java.util.List;

public interface ChapterDAO {

    List<Chapter> getAllChapters();

    void saveChapter(Chapter chapter);

    Chapter getChapter(int id);

    void deleteChapter(int id);
}
