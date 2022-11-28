package com.dmitriev.DAO;

import com.dmitriev.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProjectDAOImpl implements ProjectDAO{

    private SessionFactory sessionFactory;
    @Autowired
    public ProjectDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Project> getProjects() {
        Session session = sessionFactory.getCurrentSession();
        List<Project> projects = session.createQuery("select e from Project e", Project.class)
                .getResultList();
        return projects;
    }

    @Override
    public void saveProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(project);
    }

    @Override
    public Project getProject(int id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = session.get(Project.class,id);
        return project;
    }

    @Override
    public void deleteProject(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Project.class,id));
    }
}
