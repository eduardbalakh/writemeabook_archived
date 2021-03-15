package com.example.application.service.textstory;

import com.example.application.dao.textstory.TextStoryDAO;
import com.example.application.model.TextStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TextStoryServiceImpl implements TextStoryService {

    @Autowired
    private TextStoryDAO textStoryDAO;

    @Override
    @Transactional
    public List<TextStory> getAllTexts() {
        return textStoryDAO.getAllTexts();
    }

    @Override
    @Transactional
    public void saveText(TextStory textStory) {
        textStoryDAO.saveText(textStory);
    }

    @Override
    @Transactional
    public TextStory getText(int id) {
        return textStoryDAO.getText(id);
    }

    @Override
    @Transactional
    public void deleteText(int id) {
        textStoryDAO.deleteTextStory(id);
    }
}
