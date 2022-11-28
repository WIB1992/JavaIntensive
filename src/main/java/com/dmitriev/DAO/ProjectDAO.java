package com.dmitriev.DAO;


import com.dmitriev.entity.Project;

import java.util.List;

public interface ProjectDAO {
    public List<Project> getProjects();
    public void saveProject(Project project);
    public Project getProject(int id);
    public void deleteProject(int id);
}
