package com.example.application.service.textstory;

import com.example.application.dao.textstory.TextStoryDAO;
import com.example.application.model.TextStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextStoryServiceImpl implements TextStoryService {

    @Autowired
    private TextStoryDAO textStoryDAO;

    @Override
    public List<TextStory> getAllTexts() {
        return textStoryDAO.getAllTexts();
    }

    @Override
    public void saveText(TextStory textStory) {
        textStoryDAO.saveText(textStory);
    }

    @Override
    public TextStory getText(int id) {
        return textStoryDAO.getText(id);
    }

    @Override
    public void deleteText(int id) {
        textStoryDAO.deleteTextStory(id);
    }
}
