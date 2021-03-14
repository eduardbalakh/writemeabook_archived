package com.example.application.dao.textstory;

import com.example.application.model.TextStory;

import java.util.List;

public interface TextStoryDAO {

    List<TextStory> getAllTexts();

    void saveText(TextStory textStory);

    TextStory getText(int id);

    void deleteTextStory(int id);

}
