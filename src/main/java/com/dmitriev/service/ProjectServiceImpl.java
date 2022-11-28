package com.dmitriev.service;

import com.dmitriev.DAO.ProjectDAO;
import com.dmitriev.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDAO projectDAO;
    @Autowired
    public ProjectServiceImpl(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    @Transactional
    public List<Project> getProjects() {
        return projectDAO.getProjects();
    }

    @Override
    @Transactional
    public void saveProject(Project project) {
        projectDAO.saveProject(project);
    }

    @Override
    @Transactional
    public Project getProject(int id) {
        return projectDAO.getProject(id);
    }

    @Override
    @Transactional
    public void deleteProject(int id) {
        projectDAO.deleteProject(id);
    }
}
