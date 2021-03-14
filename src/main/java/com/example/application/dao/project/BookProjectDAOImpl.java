package com.example.application.dao.project;

import com.example.application.dao.project.BookProjectDAO;
import com.example.application.model.BookProject;
import com.example.application.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookProjectDAOImpl implements BookProjectDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<BookProject> getAllProjects() {
        Session session = entityManager.unwrap(Session.class);

        Query<BookProject> query = session.createQuery("from BookProject",
                BookProject.class);
        return query.getResultList();
    }

    @Override
    public void saveProject(BookProject project) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(project);
    }

    @Override
    public BookProject getProject(int id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(BookProject.class, id);
    }

    @Override
    public void deleteProject(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<BookProject> query = session.createQuery("delete from BookProject " +
                "where id=:projectId");
        query.setParameter("projectId", id);
        query.executeUpdate();
    }
}
