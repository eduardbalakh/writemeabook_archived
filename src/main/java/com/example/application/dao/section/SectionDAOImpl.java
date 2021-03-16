package com.example.application.dao.section;

import com.example.application.model.Section;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SectionDAOImpl implements SectionDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Section> getAllSections() {
        Session session = entityManager.unwrap(Session.class);

        Query<Section> query = session.createQuery("from Section",
                Section.class);
        return query.getResultList();
    }

    @Override
    public void saveSection(Section section) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(section);
    }

    @Override
    public Section getSection(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Section.class, id);
    }

    @Override
    public void deleteSection(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Section> query = session.createQuery("delete from Section " +
                "where id=:sectionId");
        query.setParameter("sectionId", id);
        query.executeUpdate();
    }
}
