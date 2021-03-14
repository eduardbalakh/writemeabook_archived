package com.example.application.service.textstory;

import com.example.application.model.TextStory;

import java.util.List;

public interface TextStoryService {
    List<TextStory> getAllTexts();

    void saveText(TextStory textStory);

    TextStory getText(int id);

    void deleteText(int id);
}
