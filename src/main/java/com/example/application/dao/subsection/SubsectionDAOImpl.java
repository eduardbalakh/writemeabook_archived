package com.example.application.dao.subsection;

import com.example.application.model.BookProject;
import com.example.application.model.Subsection;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SubsectionDAOImpl implements SubsectionDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Subsection> getAllSubsections() {
        Session session = entityManager.unwrap(Session.class);

        Query<Subsection> query = session.createQuery("from Subsection",
                Subsection.class);
        return query.getResultList();
    }

    @Override
    public void saveSubsection(Subsection subsection) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(subsection);
    }

    @Override
    public Subsection getSubsection(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Subsection.class, id);
    }

    @Override
    public void deleteSubsection(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<BookProject> query = session.createQuery("delete from Subsection " +
                "where id=:subsectionId");
        query.setParameter("subsectionId", id);
        query.executeUpdate();
    }
}
