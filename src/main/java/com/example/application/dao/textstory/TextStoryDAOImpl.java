package com.example.application.dao.textstory;

import com.example.application.model.TextStory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TextStoryDAOImpl implements TextStoryDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<TextStory> getAllTexts() {
        Session session = entityManager.unwrap(Session.class);

        Query<TextStory> query = session.createQuery("from TextStory",
                TextStory.class);
        return query.getResultList();
    }

    @Override
    public void saveText(TextStory textStory) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(textStory);
    }

    @Override
    public TextStory getText(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(TextStory.class, id);
    }

    @Override
    public void deleteTextStory(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<TextStory> query = session.createQuery("delete from TextStory " +
                "where id=:textstoryId");
        query.setParameter("textstoryId", id);
        if (getText(id) != null)
            query.executeUpdate();
    }
}
